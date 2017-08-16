package com.lx.mvc.argumentResolver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lx.mvc.annotation.RequestHeader;
import com.lx.mvc.annotation.Service;

@Service("requestHeaderArgumentResolver")
public class RequestHeaderArgumentResolver implements ArgumentResolver {

	@Override
	public boolean support(Class<?> type, int paramIndex, Method method) {
		Annotation[][] paramAn = method.getParameterAnnotations();

		Annotation[] an = paramAn[paramIndex];

		for (Annotation ant : an) {
			if (RequestHeader.class.isAssignableFrom(ant.getClass())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int paramIndex, Method method) {
		Annotation[][] paramAn = method.getParameterAnnotations();

		Annotation[] an = paramAn[paramIndex];

		for (Annotation ant : an) {
			if (RequestHeader.class.isAssignableFrom(ant.getClass())) {
				RequestHeader rp = (RequestHeader) ant;

				String value = rp.value();
				return request.getHeader(value);
			}
		}
		return null;
	}

}
