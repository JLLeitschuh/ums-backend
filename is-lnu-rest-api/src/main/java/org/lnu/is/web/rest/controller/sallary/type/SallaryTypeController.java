package org.lnu.is.web.rest.controller.sallary.type;

import javax.annotation.Resource;

import org.lnu.is.facade.facade.Facade;
import org.lnu.is.resource.sallary.type.SallaryTypeResource;
import org.lnu.is.resource.search.PagedRequest;
import org.lnu.is.resource.search.PagedResultResource;
import org.lnu.is.web.rest.constant.Request;
import org.lnu.is.web.rest.controller.BaseController;
import org.lnu.is.web.rest.controller.PagedController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;

/**
 * SallaryType controller.
 * @author ivanursul
 *
 */
@RestController
@RequestMapping("/sallaries/types")
public class SallaryTypeController extends BaseController implements PagedController<SallaryTypeResource> {
	private static final Logger LOG = LoggerFactory.getLogger(SallaryTypeController.class);
	
	@Resource(name = "sallaryTypeFacade")
	private Facade<SallaryTypeResource, Long> facade;
	
	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get All SallaryTypes")
	public PagedResultResource<SallaryTypeResource> getPagedResource(final PagedRequest<SallaryTypeResource> request) {
		LOG.info("Getting PagedResultResource for SallaryTypes with offset: {}, limit: {}", request.getOffset(), request.getLimit());
		return facade.getResources(request);	
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = Request.ID, method = RequestMethod.GET)
	@ApiOperation(value = "Get reason resource by id")
	public SallaryTypeResource getResource(@PathVariable("id") final Long id) {
		return facade.getResource(id);
	}

}