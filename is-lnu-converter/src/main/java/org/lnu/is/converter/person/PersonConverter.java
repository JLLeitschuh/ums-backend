package org.lnu.is.converter.person;

import org.lnu.is.annotations.Converter;
import org.lnu.is.converter.AbstractConverter;
import org.lnu.is.domain.person.Person;
import org.lnu.is.resource.person.PersonResource;

/**
 * Person converter.
 * @author ivanursul
 *
 */
@Converter("personConverter")
public class PersonConverter extends AbstractConverter<Person, PersonResource> {

	@Override
	public PersonResource convert(final Person source, final PersonResource target) {
		
		target.setBegDate(source.getBegDate());
		target.setBirthPlace(source.getBirthPlace());
		target.setDocNum(source.getDocNum());
		target.setDocSeries(source.getDocSeries());
		target.setEndDate(source.getEndDate());
		target.setFatherName(source.getFatherName());
		target.setFirstName(source.getFirstName());
		target.setId(source.getId());
		target.setIdentifier(source.getIdentifier());
		target.setIsHostel(source.getIsHostel());
		target.setIsMilitary(source.getIsMilitary());
		target.setName(source.getName());
		target.setPhoto(source.getPhoto());
		target.setResident(source.getResident());
		target.setSurname(source.getSurname());
		
		if (source.getPersonType() != null) {
			target.setPersonTypeId(source.getPersonType().getId());
		}
		
		if (source.getGenderType() != null) {
			target.setGenderTypeId(source.getGenderType().getId());
		}
		
		if (source.getMarriedType() != null) {
			target.setMarriedTypeId(source.getMarriedType().getId());
		}
		
		if (source.getParent() != null) {
			target.setParentId(source.getParent().getId());
		}	
		if (source.getCitizenCountry() != null) {
			target.setCitizenCountryId(source.getCitizenCountry().getId());
		}
			
		
		return target;
	}

	@Override
	public PersonResource convert(final Person source) {
		return convert(source, new PersonResource());
	}
}
