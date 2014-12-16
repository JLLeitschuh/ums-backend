package org.lnu.is.extractor.language;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.lnu.is.domain.language.Language;

public class LanguageParametersExtractorTest {

	private LanguageParametersExtractor unit = new LanguageParametersExtractor();
	
	@Test
	public void testGetParameters() throws Exception {
		// Given
		String name = "name";
		String abbrName = "abbr name";
		Language entity = new Language();
		entity.setAbbrName(abbrName);
		entity.setName(name);
		
		Map<String, Object> expected = new HashMap<String, Object>();
		expected.put("name", name);
		expected.put("abbrName", abbrName);
		
		// When
		Map<String, Object> actual = unit.getParameters(entity);

		// Then
		assertEquals(expected, actual);
	}
}