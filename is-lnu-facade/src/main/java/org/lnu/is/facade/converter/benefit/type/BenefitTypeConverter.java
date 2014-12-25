package org.lnu.is.facade.converter.benefit.type;

import org.lnu.is.domain.benefit.BenefitType;
import org.lnu.is.facade.annotations.Converter;
import org.lnu.is.facade.converter.AbstractConverter;
import org.lnu.is.facade.resource.benefit.type.BenefitTypeResource;

/**
 * Benefit Type Converter.
 * @author ivanursul
 *
 */
@Converter("benefitTypeConverter")
public class BenefitTypeConverter extends AbstractConverter<BenefitType, BenefitTypeResource> {

	@Override
	public BenefitTypeResource convert(final BenefitType source, final BenefitTypeResource target) {
		
		target.setName(source.getName());
		target.setPriority(source.getPriority());
		target.setId(source.getId());
		
		return target;
	}

	@Override
	public BenefitTypeResource convert(final BenefitType source) {
		return convert(source, new BenefitTypeResource());
	}

}
