package org.lnu.is.service.person.type;

import java.util.Map;

import javax.annotation.Resource;

import org.lnu.is.dao.dao.person.type.PersonTypeDao;
import org.lnu.is.domain.person.PersonType;
import org.lnu.is.extractor.ParametersExtractor;
import org.lnu.is.pagination.PagedResult;
import org.lnu.is.pagination.PagedSearch;
import org.springframework.stereotype.Service;

/**
 * Default Person Type Service.
 * @author ivanursul
 *
 */
@Service("personTypeService")
public class DefaultPersonTypeService implements PersonTypeService {

	@Resource(name = "personTypeDao")
	private PersonTypeDao personTypeDao;
	
	@Resource(name = "personTypeParametersExtractors")
	private ParametersExtractor<PersonType> parametersExtractor;
	
	@Override
	public PagedResult<PersonType> getPersonTypes(final PagedSearch<PersonType> pagedSearch) {
		Map<String, Object> parameters = parametersExtractor.getParameters(pagedSearch.getEntity());
		pagedSearch.setParameters(parameters);
		
		return personTypeDao.getEntities(pagedSearch);
	}

}