package org.lnu.is.web.controller.language;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.facade.facade.Facade;
import org.lnu.is.facade.resource.language.LanguageResource;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.web.controller.AbstractControllerTest;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class LanguageControllerTest extends AbstractControllerTest {

	@Mock
	private Facade<LanguageResource, Long> facade;

	@InjectMocks
	private LanguageController unit;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(unit).build();
	}

	@Test
	public void testGetLanguages() throws Exception {
		// Given
		String name = "LieToMe";
		int offset = 0;
		int limit = 20;
		long count = 1;
		
		LanguageResource resource = new LanguageResource();
		resource.setName(name);

		List<LanguageResource> entities = Arrays.asList(resource);
		PagedResultResource<LanguageResource> expected = new PagedResultResource<>("/languages");
		expected.setResources(entities);
		expected.setCount(count);
		expected.setLimit(limit);
		expected.setOffset(offset);

		LanguageResource paramResource = new LanguageResource();
		paramResource.setName(name);
		
		PagedRequest<LanguageResource> request = new PagedRequest<LanguageResource>(paramResource, offset, limit);

		// When
		when(facade.getResources(Matchers.<PagedRequest<LanguageResource>> any())).thenReturn(expected);
		String response = getJson(expected, false);

		// Then
		mockMvc.perform(get("/languages")
				.param("name", name))
				.andExpect(status().isOk())
				.andExpect(content().string(response));

		verify(facade).getResources(request);
	}
}