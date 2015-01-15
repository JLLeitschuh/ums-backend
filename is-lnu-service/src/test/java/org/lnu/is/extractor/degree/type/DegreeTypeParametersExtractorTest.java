package org.lnu.is.extractor.degree.type;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.lnu.is.domain.degree.DegreeType;

public class DegreeTypeParametersExtractorTest {
	
	private DegreeTypeParametersExtractor unit = new DegreeTypeParametersExtractor();

	@Test
	public void testGetParameters() throws Exception {
		// Given
		String name = "DegreeN";
		String abbrName = "AN";

		DegreeType entity = new DegreeType();
		entity.setName(name);
		entity.setAbbrName(abbrName);

		Map<String, Object> expected = new HashMap<String, Object>();
		expected.put("name", name);
		expected.put("abbrName", abbrName);

		// When
		Map<String, Object> actual = unit.getParameters(entity);

		// Then
		assertEquals(expected, actual);
	}

	@Test
	public void testGetParametersWithDefaultEntity() throws Exception {
		// Given
		DegreeType entity = new DegreeType();
		
		Map<String, Object> expected = Collections.emptyMap();
		// When
		Map<String, Object> actual = unit.getParameters(entity);

		// Then
		assertEquals(expected, actual);
	}
}
