package org.lnu.is.dao.builder.enrolment.type;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lnu.is.domain.enrolment.EnrolmentType;

public class EnrolmentTypeQueryBuilderTest {

	private EnrolmentTypeQueryBuilder unit = new EnrolmentTypeQueryBuilder();

	@Test
	public void testBuild() throws Exception {
		// Given
		String name = "name";
		EnrolmentType context = new EnrolmentType();
		context.setName(name);

		String expectedQuery = "SELECT e FROM EnrolmentType e WHERE e.name LIKE CONCAT('%',:name,'%') ";

		// When
		String actualQuery = unit.build(context);

		// Then
		assertEquals(expectedQuery, actualQuery);
	}
}