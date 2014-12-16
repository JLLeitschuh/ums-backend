package org.lnu.is.facade.converter.order.type;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lnu.is.domain.order.OrderType;
import org.lnu.is.facade.resource.order.type.OrderTypeResource;

public class OrderTypeConverterTest {

	private OrderTypeConverter unit = new OrderTypeConverter();
	
	@Test
	public void testConvert() throws Exception {
		// Given
		String abbrName = "abbrName";
		String name = "name";
		OrderType source = new OrderType();
		source.setAbbrName(abbrName);
		source.setName(name);

		OrderTypeResource expected = new OrderTypeResource();
		expected.setAbbrName(abbrName);
		expected.setName(name);
		
		// When
		OrderTypeResource actual = unit.convert(source);

		// Then
		assertEquals(expected, actual);
	}
}