package org.lnu.is.dao.builder.department.type;

import org.lnu.is.dao.annotations.QBuilder;
import org.lnu.is.dao.builder.AbstractQueryBuilder;
import org.lnu.is.dao.builder.BaseQueryBuilder;
import org.lnu.is.domain.department.type.DepartmentType;

/**
 * Department Type Query Builder.
 * @author ivanursul
 *
 */
@QBuilder("departmentTypeQueryBuilder")
public class DepartmentTypeQueryBuilder extends AbstractQueryBuilder<DepartmentType> {
	private static final String NAME_CONDITION = "e.name LIKE CONCAT('%',:name,'%') ";
	private static final String ABBR_NAME_CONDITION = "e.abbrName LIKE CONCAT('%',:abbrName,'%') ";

	@Override
	protected String getBaseQuery() {
		return "SELECT e FROM DepartmentType e %s";
	}

	@Override
	protected BaseQueryBuilder build(final DepartmentType context, final BaseQueryBuilder builder) {
		return builder
				.where()
				.openBracket()
					.addAndCondition(NAME_CONDITION, context.getName())
					.addAndCondition(ABBR_NAME_CONDITION, context.getAbbrName())
				.closeBracket();
	}

}
