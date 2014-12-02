package org.lnu.is.extractor.person.name;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.lnu.is.dao.dao.Dao;
import org.lnu.is.domain.language.Language;
import org.lnu.is.domain.person.Person;
import org.lnu.is.domain.person.PersonName;
import org.lnu.is.extractor.AbstractParametersExtractor;
import org.springframework.stereotype.Component;

/**
 * Person Name parameters extractor.
 * @author ivanursul
 *
 */
@Component("personNameParametersExtractor")
public class PersonNameParametersExtractor extends AbstractParametersExtractor<PersonName> {

	@Resource(name = "languageDao")
	private Dao<Language, Long> languageDao;
	
	@Resource(name = "personDao")
	private Dao<Person, Long> personDao;
	
	@Override
	public Map<String, Object> getParameters(final PersonName entity) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		addParameter(entity.getPerson(), personDao, "person", parameters);
		addParameter(entity.getLanguage(), languageDao, "language", parameters);
		
		addParameter(entity.getName(), "name", parameters);
		addParameter(entity.getFirstName(), "firstName", parameters);
		addParameter(entity.getFatherName(), "fatherName", parameters);
		addParameter(entity.getSurname(), "surname", parameters);
		
		return parameters;
	}

}