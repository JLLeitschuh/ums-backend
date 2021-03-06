package org.lnu.is.resource.order;

import java.text.MessageFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.lnu.is.annotation.CrudableResource;
import org.lnu.is.resource.ApiResource;

/**
 * Order Resource.
 * @author ivanursul
 *
 */
@CrudableResource
public class OrderResource extends ApiResource {

	@Min(value = 1, message = "Minimal value is 1")
	private Long parentId;

	@NotNull(message = "Field required")
	@Min(value = 1, message = "Minimal value is 1")
	private Long orderTypeId;

	@Min(value = 1, message = "Minimal value is 1")
	private Long employeeId;
	
	@NotNull(message = "Field required")
	@Min(value = 1, message = "Minimal value is 1")
	private Long assetId;

	@NotNull(message = "Field required")
	@Min(value = 1, message = "Minimal value is 1")
	private Long partnerId;
	
	@Min(value = 1, message = "Minimal value is 1")
	private Long operationTypeId;

	@NotNull(message = "Field required")
	@Min(value = 1, message = "Minimal value is 1")
	private Long departmentId;
	
	@NotNull(message = "Field required")
	@Min(value = 1, message = "Minimal value is 1")
	private Long timePeriodId;
	
	@Min(value = 1, message = "Minimal value is 1")
	private Long reasonId;
	
	@NotNull(message = "Field required")
	private String reasonText;
	
	@NotNull(message = "Field required")
	private String docSeries;
	
	@NotNull(message = "Field required")
	private String docNum;
	
	@NotNull(message = "Field required")
	private Date docDate;
	
	@NotNull(message = "Field required")
	private Date evDate;

	@NotNull(message = "Field required")
	private String docIssued;
	
	@NotNull(message = "Field required")
	private String title;
	
	@NotNull(message = "Field required")
	private String description;
	 
	
	@Override
	public String getUri() {
		return MessageFormat.format("/orders/{0}", getId());
	}

	@Override
	public String getRootUri() {
		return "/orders";
	}

	public Long getOrderTypeId() {
		return orderTypeId;
	}

	public void setOrderTypeId(final Long orderTypeId) {
		this.orderTypeId = orderTypeId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(final Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(final Long assetId) {
		this.assetId = assetId;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(final Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getOperationTypeId() {
		return operationTypeId;
	}

	public void setOperationTypeId(final Long opTypeId) {
		this.operationTypeId = opTypeId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(final Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getReasonId() {
		return reasonId;
	}

	public void setReasonId(final Long reasonId) {
		this.reasonId = reasonId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(final Long parentId) {
		this.parentId = parentId;
	}

	public String getReasonText() {
		return reasonText;
	}

	public void setReasonText(final String reasonText) {
		this.reasonText = reasonText;
	}

	public String getDocSeries() {
		return docSeries;
	}

	public void setDocSeries(final String docSeries) {
		this.docSeries = docSeries;
	}

	public String getDocNum() {
		return docNum;
	}

	public void setDocNum(final String docNum) {
		this.docNum = docNum;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(final Date docDate) {
		this.docDate = docDate;
	}

	public String getDocIssued() {
		return docIssued;
	}

	public void setDocIssued(final String docIssued) {
		this.docIssued = docIssued;
	}

	public Date getEvDate() {
		return evDate;
	}

	public void setEvDate(final Date evDate) {
		this.evDate = evDate;
	}
	
	public Long getTimePeriodId() {
		return timePeriodId;
	}

	public void setTimePeriodId(final Long timePeriodId) {
		this.timePeriodId = timePeriodId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result
				+ ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((docDate == null) ? 0 : docDate.hashCode());
		result = prime * result
				+ ((docIssued == null) ? 0 : docIssued.hashCode());
		result = prime * result + ((docNum == null) ? 0 : docNum.hashCode());
		result = prime * result
				+ ((docSeries == null) ? 0 : docSeries.hashCode());
		result = prime * result
				+ ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((evDate == null) ? 0 : evDate.hashCode());
		result = prime * result
				+ ((operationTypeId == null) ? 0 : operationTypeId.hashCode());
		result = prime * result
				+ ((orderTypeId == null) ? 0 : orderTypeId.hashCode());
		result = prime * result
				+ ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result
				+ ((partnerId == null) ? 0 : partnerId.hashCode());
		result = prime * result
				+ ((reasonId == null) ? 0 : reasonId.hashCode());
		result = prime * result
				+ ((reasonText == null) ? 0 : reasonText.hashCode());
		result = prime * result + ((timePeriodId == null) ? 0 : timePeriodId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OrderResource other = (OrderResource) obj;
		if (assetId == null) {
			if (other.assetId != null) {
				return false;
			}
		} else if (!assetId.equals(other.assetId)) {
			return false;
		}
		if (departmentId == null) {
			if (other.departmentId != null) {
				return false;
			}
		} else if (!departmentId.equals(other.departmentId)) {
			return false;
		}
		if (docDate == null) {
			if (other.docDate != null) {
				return false;
			}
		} else if (!docDate.equals(other.docDate)) {
			return false;
		}
		if (docIssued == null) {
			if (other.docIssued != null) {
				return false;
			}
		} else if (!docIssued.equals(other.docIssued)) {
			return false;
		}
		if (docNum == null) {
			if (other.docNum != null) {
				return false;
			}
		} else if (!docNum.equals(other.docNum)) {
			return false;
		}
		if (docSeries == null) {
			if (other.docSeries != null) {
				return false;
			}
		} else if (!docSeries.equals(other.docSeries)) {
			return false;
		}
		if (employeeId == null) {
			if (other.employeeId != null) {
				return false;
			}
		} else if (!employeeId.equals(other.employeeId)) {
			return false;
		}
		if (evDate == null) {
			if (other.evDate != null) {
				return false;
			}
		} else if (!evDate.equals(other.evDate)) {
			return false;
		}
		if (operationTypeId == null) {
			if (other.operationTypeId != null) {
				return false;
			}
		} else if (!operationTypeId.equals(other.operationTypeId)) {
			return false;
		}
		if (orderTypeId == null) {
			if (other.orderTypeId != null) {
				return false;
			}
		} else if (!orderTypeId.equals(other.orderTypeId)) {
			return false;
		}
		if (parentId == null) {
			if (other.parentId != null) {
				return false;
			}
		} else if (!parentId.equals(other.parentId)) {
			return false;
		}
		if (partnerId == null) {
			if (other.partnerId != null) {
				return false;
			}
		} else if (!partnerId.equals(other.partnerId)) {
			return false;
		}
		if (reasonId == null) {
			if (other.reasonId != null) {
				return false;
			}
		} else if (!reasonId.equals(other.reasonId)) {
			return false;
		}
		if (reasonText == null) {
			if (other.reasonText != null) {
				return false;
			}
		} else if (!reasonText.equals(other.reasonText)) {
			return false;
		}
		if (timePeriodId == null) {
			if (other.timePeriodId != null) {
				return false;
			}
		} else if (!timePeriodId.equals(other.timePeriodId)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "OrderResource [parentId=" + parentId + ", orderTypeId="
				+ orderTypeId + ", employeeId=" + employeeId + ", assetId="
				+ assetId + ", partnerId=" + partnerId + ", operationTypeId="
				+ operationTypeId + ", departmentId=" + departmentId
				+ ", timePeriodId=" + timePeriodId + ", reasonId=" + reasonId
				+ ", reasonText=" + reasonText + ", docSeries=" + docSeries
				+ ", docNum=" + docNum + ", docDate=" + docDate + ", evDate="
				+ evDate + ", docIssued=" + docIssued + ", title=" + title
				+ ", description=" + description + "]";
	}

}
