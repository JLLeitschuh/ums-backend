package org.lnu.is.facade.facade.addresstype;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.domain.addresstype.AddressType;
import org.lnu.is.facade.converter.Converter;
import org.lnu.is.facade.resource.ApiResource;
import org.lnu.is.facade.resource.addresstype.AddressTypeResource;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.pagination.PagedResult;
import org.lnu.is.pagination.PagedSearch;
import org.lnu.is.queries.Queries;
import org.lnu.is.service.addresstype.AddressTypeService;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultAddressTypeFacadeTest {

	@InjectMocks
	private DefaultAddressTypeFacade unit;

	@Mock
	private Converter<PagedRequest<AddressTypeResource>, PagedSearch<AddressType>> pagedRequestConverter;

	@Mock
	private Converter<PagedResult<?>, PagedResultResource<? extends ApiResource>> pagedResultConverter;

	@Mock
	private AddressTypeService addressTypeService;

	@Mock
	private Converter<AddressType, AddressTypeResource> addressTypeConverter;

	@Mock
	private Converter<AddressTypeResource, AddressType> addressTypeResourceConverter;

	@Test
	public void getAddressTypes() throws Exception {
		// Given
		AddressTypeResource resource = new AddressTypeResource();
		PagedRequest<AddressTypeResource> pagedRequest = new PagedRequest<AddressTypeResource>(
				resource, 10, 10);
		List<AddressTypeResource> myResources = Collections
				.singletonList(new AddressTypeResource());
		PagedResultResource<AddressTypeResource> expectedResources = new PagedResultResource<>(
				"/addresstypes");
		expectedResources.setResources(myResources);

		int limit = 8;
		int offset = 3;
		int count = 100;

		String queryCommand = "query";
		String queryName = "queryName";
		Queries query = new Queries(queryName, queryCommand);

		PagedSearch<AddressType> pagedSearch = new PagedSearch<AddressType>(
				offset, limit, query, Collections.<String, Object> emptyMap(),
				AddressType.class);
		List<AddressType> entities = Arrays.asList(new AddressType());
		PagedResult<AddressType> pagedResult = new PagedResult<AddressType>(
				offset, limit, count, entities);

		// When
		when(
				pagedRequestConverter.convert(Matchers
						.<PagedRequest<AddressTypeResource>> any()))
				.thenReturn(pagedSearch);
		when(
				addressTypeService.getAddressTypes(Matchers
						.<PagedSearch<AddressType>> any())).thenReturn(
				pagedResult);
		when(addressTypeConverter.convertAll(anyListOf(AddressType.class)))
				.thenReturn(myResources);

		PagedResultResource<AddressTypeResource> actualResources = unit
				.getAddressTypes(pagedRequest);

		// Then
		verify(pagedRequestConverter).convert(pagedRequest);
		verify(addressTypeService).getAddressTypes(pagedSearch);
		verify(addressTypeConverter).convertAll(entities);
		verify(pagedResultConverter).convert(pagedResult, expectedResources);

		assertEquals(expectedResources, actualResources);
	}
}