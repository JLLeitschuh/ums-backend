package org.lnu.is.facade.converter.search;

import org.lnu.is.facade.converter.AbstractConverter;
import org.lnu.is.facade.resource.ApiResource;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.pagination.PagedResult;
import org.springframework.stereotype.Component;

/**
 * PagedSearchConverter that converts from PagedREsult into PagedResultResource.
 * Main idea is that PagedResult is from facade layer and
 * PagedResultResource is from domain layer.
 * @author ivanursul
 *
 */
@Component("pagedSearchConverter")
public class PagedSearchConverter extends AbstractConverter<PagedResult<?>, PagedResultResource<? extends ApiResource>> {

    @Override
    public PagedResultResource<? extends ApiResource> convert(final PagedResult<?> source) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PagedResultResource<? extends ApiResource> convert(final PagedResult<?> source, final PagedResultResource<? extends ApiResource> target) {

    	target.setOffset(source.getOffset());
    	target.setLimit(source.getLimit());
        target.setCount(source.getCount());

        return target;
    }
}

