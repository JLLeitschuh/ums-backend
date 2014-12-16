package org.lnu.is.dao.builder.timeperiod.type;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lnu.is.domain.timeperiod.TimePeriodType;

public class TimePeriodTypeQueryBuilderTest {

	private TimePeriodTypeQueryBuilder unit = new TimePeriodTypeQueryBuilder();
	
	@Test
	public void testBuild() throws Exception {
		// Given
		TimePeriodType context = new TimePeriodType();

		String expected = "SELECT t FROM TimePeriodType t ";
		// When
		String actual = unit.build(context);

		// Then
		assertEquals(expected, actual);
	}

	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		String abbrName = "abbrNAme";
		String name = "name";
		TimePeriodType context = new TimePeriodType();
		context.setAbbrName(abbrName);
		context.setName(name);
		
		String expected = "SELECT t FROM TimePeriodType t WHERE t.name LIKE CONCAT('%',:name,'%') OR t.abbrName LIKE CONCAT('%',:abbrName,'%') ";
		// When
		String actual = unit.build(context);
		
		// Then
		assertEquals(expected, actual);
	}
}