package org.lnu.is.facade.converter.marriedtype;

import org.lnu.is.domain.marriedtype.MarriedType;
import org.lnu.is.facade.annotations.Converter;
import org.lnu.is.facade.converter.AbstractConverter;
import org.lnu.is.facade.resource.marriedtype.MarriedTypeResource;

/**
 * Converter from MarriedType to MarriedTypeResource.
 * @author Bohdan
 *
 */
@Converter("marriedTypeConverter")
public class MarriedTypeConverter extends AbstractConverter<MarriedType, MarriedTypeResource> {

	@Override
	public MarriedTypeResource convert(final MarriedType source, final MarriedTypeResource target) {
		
		target.setId(source.getId());
		target.setName(source.getName());
		target.setAbbrName(source.getAbbrName());

		return target;
	}

	@Override
	public MarriedTypeResource convert(final MarriedType source) {
		return convert(source, new MarriedTypeResource());
	}

}
