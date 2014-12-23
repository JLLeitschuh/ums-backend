package org.lnu.is.web.rest.processor.resolver;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.lnu.is.facade.annotations.Limit;
import org.lnu.is.facade.annotations.Offset;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.web.rest.constant.Constants;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * Paged request argument resolver.
 * @author ivanursul
 *
 */
@Component("pagedRequestHandlerMethodArgumentResolver")
public class PagedRequestHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	/**
	 * Method for initializing required staff for commons-beanutils classes.
	 */
	@PostConstruct
	public void init() {
		DateTimeConverter dtConverter = new DateConverter();
		dtConverter.setPattern(Constants.DEFAULT_DATEFORMAT);
		ConvertUtils.register(dtConverter, Date.class);		
	}
	
	
	@Override
	public boolean supportsParameter(final MethodParameter parameter) {
		return PagedRequest.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(final MethodParameter param,
			final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest,
			final WebDataBinderFactory binderFactory) throws Exception {
		
		HttpServletRequest httprequest = (HttpServletRequest) webRequest.getNativeRequest();
		
        Object resource = getResource(param, httprequest);
        Integer limit = getLimit(param, httprequest);
        Integer offset = getOffset(param, httprequest);
		
        PagedRequest<Object> pagedRequest = new PagedRequest<Object>(resource, offset, limit);
		return pagedRequest;
	}

	/**
	 * Method for getting limit value.
	 * @param param
	 * @param httprequest
	 * @return offset.
	 * @throws Exception exception.
	 */
	private Integer getLimit(final MethodParameter param, final HttpServletRequest httprequest) throws Exception {
		Limit annotation = param.getParameterAnnotation(Limit.class);
		Field field = param.getParameterType().getDeclaredField("limit");

		if (annotation == null) {
			annotation = field.getAnnotation(Limit.class);
		}
		
		String value = httprequest.getParameter(annotation.value());

		if (value == null) {
			value = annotation.defaultValue();
		}

		if (value == null && annotation.required()) {
			raiseMissingParameterException(annotation.value(), field.getDeclaringClass());
		}

		return Integer.valueOf(value);
	}

	/**
	 * Method for getting offset value.
	 * @param param
	 * @param httprequest
	 * @return offset.
	 * @throws Exception exception.
	 */
	private Integer getOffset(final MethodParameter param, final HttpServletRequest httprequest) throws Exception {
		Offset annotation = param.getParameterAnnotation(Offset.class);
		Field field = param.getParameterType().getDeclaredField("offset");

		if (annotation == null) {
			annotation = field.getAnnotation(Offset.class);
		}
		
		String value = httprequest.getParameter(annotation.value());
		
		if (value == null) {
			value = annotation.defaultValue();
		}
		
		if (value == null && annotation.required()) {
			raiseMissingParameterException(annotation.value(), field.getDeclaringClass());
		}
			
		return Integer.valueOf(value);
	}

	/**
	 * Method for getting resource.
	 * @param parameter
	 * @param httprequest
	 * @return resource.
	 * @throws Exception exception.
	 */
	private Object getResource(final MethodParameter parameter, final HttpServletRequest httprequest) throws Exception {
		Type genericParameterType = parameter.getGenericParameterType();
        ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
        Class<?> clz = (Class<?>) parameterizedType.getActualTypeArguments()[0];
		Object resource = clz.newInstance();

		BeanUtils.populate(resource, httprequest.getParameterMap());

		return resource;
	}

	/**
	 * Method for raising exception.
	 * 
	 * @param paramName
	 * @param paramType
	 * @throws Exception
	 *             exception.
	 */
	protected void raiseMissingParameterException(final String paramName, final Class<?> paramType) throws Exception {
		throw new IllegalStateException("Missing parameter '" + paramName + "' of type [" + paramType.getName() + "]");
	}
	
}
