package org.lnu.is.web.controller.specialty;

import javax.annotation.Resource;

import org.lnu.is.facade.facade.specialty.SpecialtyFacade;
import org.lnu.is.facade.resource.message.MessageResource;
import org.lnu.is.facade.resource.message.MessageType;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.facade.resource.specialty.SpecialtyResource;
import org.lnu.is.web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller, that handles all operations with
 * Specialty entity.
 * @author ivanursul
 *
 */
@RestController
@RequestMapping("/specialties")
public class SpecialtyController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(SpecialtyController.class);
	
	@Resource(name = "specialtyFacade")
	private SpecialtyFacade specialtyFacade;

	/**
	 * Method for creating new specialty.
	 * Http Method - POST.
	 * Content Body - specialty resource.
	 * PS - to help you understand how you should map methods, this
	 * method url will look like:
	 * 
	 * http://localhost:8080/is-lnu-rest-api/api/specailties,
	 * the method should be POST
	 * 
	 * @param specialtyResource
	 * @return specialty with generated identifier.
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public SpecialtyResource createSpecialty(@RequestBody final SpecialtyResource specialtyResource) {
		LOG.info("Creating specialty: {}", specialtyResource);
		return specialtyFacade.createSpecialty(specialtyResource);
	}
	
	/**
	 * Method for updating specialty.
	 * HttpMethod - PUT.
	 * 
	 * PS - To help you understand how you should map methods, this
	 * method url will look like:
	 * 
	 * http://localhost:8080/is-lnu-rest-api/api/specialties/1,
	 * where 1 - is identifier of specialty.
	 * method should be PUT.
	 * 
	 * @param id identifier
	 * @param specialtyResource 
	 * @return message about result of operation, we don't need to return any
	 * additional info.
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public MessageResource updateSpecialty(@PathVariable("id") final Long id,
			@RequestBody final SpecialtyResource specialtyResource) {
		LOG.info("Updated specialty with id: {}, {}", id, specialtyResource);
		specialtyFacade.updateSpecialty(id, specialtyResource);
		return new MessageResource(MessageType.INFO, "Specialty Updated");
	}
	
	/**
	 * Method for getting specialty by it's id.
	 * Http Method - GET
	 * 
	 * PS - to try this method, use your browser
	 * 
	 * http://localhost:8080/is-lnu-rest-api/api/specialties/1,
	 * http method - GET.
	 * 
	 * @param id identifier.
	 * @return specialty resource.
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public SpecialtyResource getSpecialty(@PathVariable("id") final Long id) {
		LOG.info("Retrieving specialty with id: {}", id);
		return specialtyFacade.getSpecialty(id);
	}
	
	/**
	 * Method for removing specialty.
	 * HttpMethod - DELETE.
	 * 
	 * PS - For better understanding , url should look like
	 * this:
	 * 
	 * http://localhost:8080/is-lnu-rest-api/api/specialties/1
	 * Http Method - DELETE.
	 * @param id identifier.
	 * @return message about result of operation, we don't need to return any
	 * additional info.
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MessageResource removeSpecialty(@PathVariable("id") final Long id) {
		LOG.info("Removing specoffer with id: {}", id);
		specialtyFacade.removeSpecialty(id);
		return new MessageResource(MessageType.INFO, "Specialty removed");
	}
	
	/**
	 * Method for paged search.
	 * This means, that if you can pass parameters to this method
	 * 
	 * Http Method - GET
	 * 
	 * http://localhost:8080/is-lnu-rest-api/api/specialties?offset=0&limit=20
	 * Request to this url will return 20 specialties, starting from 0 position.
	 * 
	 * Another example of url
	 * http://localhost:8080/is-lnu-rest-api/api/specialties
	 * 
	 * Request to this url will return 20 specialties, starting from 0 position.
	 * Why 20 specialties, starting from 0 position? Because of default values of
	 * offset ant limit parameters.
	 * @param offset start position.If not specified, default value will be - 0.
	 * @param limit maximum results. If not specified, default value will be - 20.
	 * @return Paged Result with generated entities.
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping
	public PagedResultResource<SpecialtyResource> getSpecialties(@RequestParam(value = "offset", defaultValue = "0") final Integer offset,
			@RequestParam(value = "limit", defaultValue = "20") final Integer limit) {
		LOG.info("Retrieving PagedResultResource for Specialty Resources with offset: {}, limit: {}", offset, limit);
		PagedRequest pagedRequest = new PagedRequest(offset, limit);
		return specialtyFacade.getSpecialties(pagedRequest);
	}	
}
