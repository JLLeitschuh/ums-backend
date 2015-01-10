package org.lnu.is.web.rest.controller.paper.type;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.facade.facade.Facade;
import org.lnu.is.resource.paper.type.PaperTypeResource;
import org.lnu.is.resource.search.PagedRequest;
import org.lnu.is.resource.search.PagedResultResource;
import org.lnu.is.web.rest.controller.AbstractControllerTest;
import org.lnu.is.web.rest.controller.BaseController;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaperTypeControllerTest extends AbstractControllerTest {
	
	@Mock
	private Facade<PaperTypeResource, Long> facade;
	
	@InjectMocks
	private PaperTypeController unit;
	
	@Override
	protected BaseController getUnit() {
		return unit;
	}

	@Test
	public void testGetPaperTypes() throws Exception {
		// Given
		String name = "all difficult";
		String abbrName = "ad";
		PaperTypeResource resource = new PaperTypeResource();
		resource.setName(name);
		resource.setAbbrName(abbrName);
		
		List<PaperTypeResource> entities = Arrays.asList(resource);
		
		int offset = 0;
		int limit = 60;
		long count = 1;
		PagedResultResource<PaperTypeResource> expected = new PagedResultResource<>("/papers/types");
		expected.setResources(entities);
		expected.setOffset(offset);
		expected.setLimit(limit);
		expected.setCount(count);
		
		PaperTypeResource paramResource = new PaperTypeResource();
		paramResource.setName(name);
		paramResource.setAbbrName(abbrName);		
		
		PagedRequest<PaperTypeResource> request = new PagedRequest<PaperTypeResource>(paramResource, offset, limit);
		
		// When
		when(facade.getResources(Matchers.<PagedRequest<PaperTypeResource>> any())).thenReturn(expected);
		String response = getJson(expected, false);
		
		// Then
		mockMvc.perform(get("/papers/types")
				.param("name", name)
				.param("abbrName", abbrName))
				.andExpect(status().isOk())
				.andExpect(content().string(response));
		
		verify(facade).getResources(request);
	}

}