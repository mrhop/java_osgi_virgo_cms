package net.sharesuite.cms.backend.util.tool;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;

public abstract class BeanUtils extends org.springframework.beans.BeanUtils {
	public static void copyProperties(Object source, Object target)
			throws BeansException {
		try {
			Class<?> actualEditable = target.getClass();
			PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
			for (PropertyDescriptor targetPd : targetPds) {
				if (targetPd.getWriteMethod() != null) {
					PropertyDescriptor sourcePd = getPropertyDescriptor(
							source.getClass(), targetPd.getName());
					if (sourcePd != null && sourcePd.getReadMethod() != null) {

						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass()
								.getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						// �����ж�����value�Ƿ�Ϊ�� ��Ȼ����Ҳ�ܽ���һЩ����Ҫ��Ĵ��� �����ʱ��ʽת���ȵ�
						if (value != null) {
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod
									.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						}

					}
				}
			}
		} catch (Throwable ex) {
			throw new FatalBeanException(
					"Could not copy properties from source to target", ex);
		}
	}
}
