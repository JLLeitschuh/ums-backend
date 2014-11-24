package org.lnu.is.facade.converter.person.type;

import org.lnu.is.domain.person.PersonType;
import org.lnu.is.facade.annotations.Converter;
import org.lnu.is.facade.converter.AbstractConverter;
import org.lnu.is.facade.resource.person.type.PersonTypeResource;

/**
 * Person Type PersonType - > PersonTypeResource converter.
 * @author ivanursul
 *
 */
@Converter("personTypeConverter")
public class PersonTypeConverter extends AbstractConverter<PersonType, PersonTypeResource> {

	@Override
	public PersonTypeResource convert(final PersonType source, final PersonTypeResource target) {
		
		target.setId(source.getId());
		target.setName(source.getName());
		target.setAbbrName(source.getAbbrName());
		
		return target;
	}

	@Override
	public PersonTypeResource convert(final PersonType source) {
		return convert(source, new PersonTypeResource());
	}

}