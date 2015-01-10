package org.lnu.is.resource.education.type;

import java.text.MessageFormat;

import org.lnu.is.resource.ApiResource;

/**
 * Education Type Resource.
 * @author ivanursul
 *
 */
public class EducationTypeResource extends ApiResource {

	private String abbrName;
	private String name;
	
	@Override
	public String getUri() {
		return MessageFormat.format("/educations/types/{0}", getId());
	}
	
	@Override
	public String getRootUri() {
		return "/educations/types";
	}
	
	public String getAbbrName() {
		return abbrName;
	}
	public void setAbbrName(final String abbrName) {
		this.abbrName = abbrName;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abbrName == null) ? 0 : abbrName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EducationTypeResource other = (EducationTypeResource) obj;
		if (abbrName == null) {
			if (other.abbrName != null) {
				return false;
			}
		} else if (!abbrName.equals(other.abbrName)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "EducationResource [abbrName=" + abbrName + ", name=" + name
				+ "]";
	}
	
}