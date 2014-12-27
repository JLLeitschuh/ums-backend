package org.lnu.is.converter.eduformtype;

import org.lnu.is.annotations.Converter;
import org.lnu.is.converter.AbstractConverter;
import org.lnu.is.domain.eduformtype.EduFormType;
import org.lnu.is.resource.eduformtype.EduFormTypeResource;

/**
 * Edu Form Type Converter.
 * @author ivanursul
 *
 */
@Converter("eduFormTypeConverter")
public class EduFormTypeConverter extends AbstractConverter<EduFormType, EduFormTypeResource> {

	@Override
	public EduFormTypeResource convert(final EduFormType source, final EduFormTypeResource target) {
		
		target.setId(source.getId());
		target.setName(source.getName());
		
		return target;
	}

	@Override
	public EduFormTypeResource convert(final EduFormType source) {
		return convert(source, new EduFormTypeResource());
	}

}