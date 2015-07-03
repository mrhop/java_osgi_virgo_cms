package net.sharesuite.cms.backend.util.repository;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRepository<T> implements BaseRepositoryI<T> {

	protected EntityManagerFactory entityManagerFactory;
	
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}
	

	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		return getScrollData(entityClass, firstindex, maxresult, null, null,
				orderby);
	}

	public QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
			int maxresult, String wherejpql, Object[] queryParams) {
		return getScrollData(entityClass, firstindex, maxresult, wherejpql,
				queryParams, null);
	}

	public QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
			int maxresult) {
		return getScrollData(entityClass, firstindex, maxresult, null, null,
				null);
	}

	public QueryResult<T> getScrollData(Class<T> entityClass) {
		return getScrollData(entityClass, -1, -1);
	}

	@SuppressWarnings("unchecked")
	public QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
			int maxresult, String wherejpql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		EntityManager em = entityManagerFactory.createEntityManager();
		QueryResult<T> qr = new QueryResult<T>();
		String entityname = getEntityName(entityClass);
		Query query = em.createQuery("select o from " + entityname + " o "
				+ (wherejpql == null ? "" : "where " + wherejpql)
				+ buildOrderby(orderby));
		setQueryParams(query, queryParams);
		if (firstindex != -1 && maxresult != -1)
			query.setFirstResult(firstindex).setMaxResults(maxresult);
		qr.setResultlist(query.getResultList());
		query = em.createQuery("select count(" + getCountField(entityClass)
				+ ") from " + entityname + " o "
				+ (wherejpql == null ? "" : "where " + wherejpql));
		setQueryParams(query, queryParams);
		qr.setTotalrecord((Long) query.getSingleResult());
		return qr;
	}

	@Override
	public void clear() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.clear();
	}

	@Override
	public void delete(Class<T> entityClass, Object entityid) {
		delete(entityClass, new Object[] { entityid });
	}

	@Override
	public void delete(Class<T> entityClass, Object[] entityids) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		for (Object id : entityids) {
			em.remove(em.getReference(entityClass, id));
		}
		em.getTransaction().commit();
	}

	@Override
	public T find(Class<T> entityClass, Object entityId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		return em.find(entityClass, entityId);
	}

	@Override
	public void save(Object entity) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public long getCount(Class<T> entityClass) {
		EntityManager em = entityManagerFactory.createEntityManager();
		return (Long) em.createQuery(
				"select count(" + getCountField(entityClass) + ") from "
						+ getEntityName(entityClass) + " o").getSingleResult();
	}

	@Override
	public void update(Object entity) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	protected String getEntityName(Class<T> entityClass) {
		String entityname = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if (entity.name() != null && !"".equals(entity.name())) {
			entityname = entity.name();
		}
		return entityname;
	}

	protected String getCountField(Class<T> clazz) {
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector
					.getBeanInfo(clazz).getPropertyDescriptors();
			for (PropertyDescriptor propertydesc : propertyDescriptors) {
				Method method = propertydesc.getReadMethod();
				if (method != null
						&& method.isAnnotationPresent(EmbeddedId.class)) {
					PropertyDescriptor[] ps = Introspector.getBeanInfo(
							propertydesc.getPropertyType())
							.getPropertyDescriptors();
					out = "o."
							+ propertydesc.getName()
							+ "."
							+ (!ps[1].getName().equals("class") ? ps[1]
									.getName() : ps[0].getName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	protected void setQueryParams(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i + 1, queryParams[i]);
			}
		}
	}

	protected String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuffer orderbyql = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			orderbyql.append(" order by ");
			for (String key : orderby.keySet()) {
				orderbyql.append("o.").append(key).append(" ")
						.append(orderby.get(key)).append(",");
			}
			orderbyql.deleteCharAt(orderbyql.length() - 1);
		}
		return orderbyql.toString();
	}

}
