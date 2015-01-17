package org.lnu.is.converter.subject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lnu.is.domain.subject.Subject;
import org.lnu.is.domain.subject.SubjectType;
import org.lnu.is.resource.subject.SubjectResource;

public class SubjectResourceConverterTest {

	private SubjectResourceConverter unit = new SubjectResourceConverter();

	@Test
	public void testConvert() throws Exception {
		// Given
		String name = "first blood";

		Long subjectTypeId = 1L;
		SubjectType subjectType = new SubjectType();
		subjectType.setId(subjectTypeId);
		
		Subject expected = new Subject();
		expected.setName(name);
		expected.setSubjectType(subjectType);
		
		SubjectResource source = new SubjectResource();
		source.setName(name);
		source.setSubjectTypeId(subjectTypeId);

		// When
		Subject actual = unit.convert(source);

		// Then
		assertEquals(expected, actual);
	}

	@Test
	public void testConvertWithNoRelations() throws Exception {
		// Given
		String name = "first blood";
		
		Subject expected = new Subject();
		expected.setName(name);
		
		SubjectResource source = new SubjectResource();
		source.setName(name);
		
		// When
		Subject actual = unit.convert(source);
		
		// Then
		assertEquals(expected, actual);
	}

}
