package org.lnu.is.extractor.order.type;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.dao.dao.Dao;
import org.lnu.is.domain.order.OrderType;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderTypeParametersExtractorTest {

	@Mock
	private Dao<OrderType, Long> orderTypeDao;
	
	@InjectMocks
	private OrderTypeParametersExtractor unit;
	
	@Test
	public void testGetParameters() throws Exception {
		// Given
		Long parentId = 1L;
		String abbrName = "abbrName";
		String name = "name";
		OrderType parent = new OrderType();
		parent.setId(parentId);
		
		OrderType entity = new OrderType();
		entity.setAbbrName(abbrName);
		entity.setName(name);
		entity.setParent(parent);

		Map<String, Object> expected = new HashMap<String, Object>();
		expected.put("abbrName", abbrName);
		expected.put("name", name);
		expected.put("parent", parent);
		
		// When
		when(orderTypeDao.getEntityById(anyLong())).thenReturn(parent);
		
		Map<String, Object> actual = unit.getParameters(entity);

		// Then
		verify(orderTypeDao).getEntityById(parentId);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetParametersWithDefaultEntity() throws Exception {
		// Given
		OrderType entity = new OrderType();
		
		Map<String, Object> expected = Collections.emptyMap();
		// When
		Map<String, Object> actual = unit.getParameters(entity);

		// Then
		assertEquals(expected, actual);
	}
}
