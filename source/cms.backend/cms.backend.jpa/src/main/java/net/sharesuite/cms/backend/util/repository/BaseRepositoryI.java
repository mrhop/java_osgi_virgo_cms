package net.sharesuite.cms.backend.util.repository;

import java.util.LinkedHashMap;

public interface BaseRepositoryI<T> {
	
    public long getCount(Class<T> entityClass);  
    
    public void clear();  
     
    public void save(Object entity);  
      
    public void update(Object entity);  
     
    public void delete(Class<T> entityClass, Object entityid);  
     
    public void delete(Class<T> entityClass, Object[] entityids);  
     
    public T find(Class<T> entityClass, Object entityId);  
    
    public QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult  
            , String wherejpql, Object[] queryParams,LinkedHashMap<String, String> orderby);  
      
    public QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult  
            , String wherejpql, Object[] queryParams);  
      
    public QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult  
            , LinkedHashMap<String, String> orderby);  
      
    public QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult);  
      
    public QueryResult<T> getScrollData(Class<T> entityClass);  
   
}
