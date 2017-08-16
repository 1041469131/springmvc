package com.lx.mvc.argumentResolver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lx.mvc.annotation.RequestParam;
import com.lx.mvc.annotation.Service;

@Service("requestParamArgumentResolver")
public class RequestParamArgumentResolver implements ArgumentResolver {

	@Override
	public boolean support(Class<?> type, int paramIndex, Method method) {

		Annotation[][] an = method.getParameterAnnotations();

		Annotation[] paramAns = an[paramIndex];

		for (Annotation paramAn : paramAns) {
			if (RequestParam.class.isAssignableFrom(paramAn.getClass())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int paramIndex, Method method) {

		Annotation[][] an = method.getParameterAnnotations();

		Annotation[] paramAns = an[paramIndex];

		for (Annotation paramAn : paramAns) {
			if (RequestParam.class.isAssignableFrom(paramAn.getClass())) {
				RequestParam rp = (RequestParam) paramAn;

				String value = rp.value();
				return request.getParameter(value);
			}
		}

		return null;
	}

}
