package org.lnu.is.facade.facade.eduformtype;

import java.util.List;

import javax.annotation.Resource;

import org.lnu.is.domain.eduformtype.EduFormType;
import org.lnu.is.facade.annotations.Facade;
import org.lnu.is.facade.converter.Converter;
import org.lnu.is.facade.resource.ApiResource;
import org.lnu.is.facade.resource.eduformtype.EduFormTypeResource;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.pagination.PagedResult;
import org.lnu.is.pagination.PagedSearch;
import org.lnu.is.service.eduformtype.EduFormTypeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author ivanursul
 *
 */
@Transactional
@Facade("eduFormTypeFacade")
public class DefaultEduFormTypeFacade implements EduFormTypeFacade {

	@Resource(name = "pagedRequestConverter")
	private Converter<PagedRequest<EduFormTypeResource>, PagedSearch<EduFormType>> pagedRequestConverter;

	@Resource(name = "pagedSearchConverter")
	private Converter<PagedResult<?>, PagedResultResource<? extends ApiResource>> pagedResultConverter;
	
	@Resource(name = "eduFormTypeConverter")
	private Converter<EduFormType, EduFormTypeResource> eduFormTypeConverter;
	
	@Resource(name = "eduFormTypeResourceConverter")
	private Converter<EduFormTypeResource, EduFormType> eduFormTypeResourceConverter;
	
	@Resource(name = "eduFormTypeService")
	private EduFormTypeService eduFormTypeService;
	
	@Override
	public PagedResultResource<EduFormTypeResource> getEduFormTypes(final PagedRequest<EduFormTypeResource> request) {
		
		PagedSearch<EduFormType> pagedSearch = pagedRequestConverter.convert(request);
		pagedSearch.setEntity(eduFormTypeResourceConverter.convert(request.getResource()));
		
		PagedResult<EduFormType> pagedResult = eduFormTypeService.getEduFormTypes(pagedSearch);
		
		List<EduFormTypeResource> resources = eduFormTypeConverter.convertAll(pagedResult.getEntities());
		
		PagedResultResource<EduFormTypeResource> pagedResultResource = new PagedResultResource<>("/eduformtypes");
		pagedResultResource.setResources(resources);
		pagedResultConverter.convert(pagedResult, pagedResultResource);
		
		return pagedResultResource;
	}

}
