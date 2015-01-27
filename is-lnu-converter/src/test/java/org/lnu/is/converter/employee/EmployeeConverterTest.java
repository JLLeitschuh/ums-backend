package org.lnu.is.converter.employee;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.lnu.is.domain.department.Department;
import org.lnu.is.domain.employee.Employee;
import org.lnu.is.domain.employee.status.EmployeeStatus;
import org.lnu.is.domain.employee.type.EmployeeType;
import org.lnu.is.domain.gendertype.GenderType;
import org.lnu.is.domain.jobtype.JobType;
import org.lnu.is.domain.order.Order;
import org.lnu.is.domain.person.Person;
import org.lnu.is.domain.post.Post;
import org.lnu.is.resource.employee.EmployeeResource;

public class EmployeeConverterTest {

	private EmployeeConverter unit = new EmployeeConverter();
	
	@Test
	public void testConvert() throws Exception {
		// Given
		Long employeeTypeId = 2L;
		EmployeeType employeeType = new EmployeeType();
		employeeType.setId(employeeTypeId);
		
		Long personId = 3L;
		Person person = new Person();
		person.setId(personId);
		
		Long genderTypeId = 4L;
		GenderType genderType = new GenderType();
		genderType.setId(genderTypeId);
		
		Long departmentId = 5L;
		Department department = new Department();
		department.setId(departmentId);
		
		Long postId = 6L;
		Post post = new Post();
		post.setId(postId);
		
		Long jobTypeId = 7L;
		JobType jobType = new JobType();
		jobType.setId(jobTypeId);
		
		Long employeeStatusId = 8L;
		EmployeeStatus employeeStatus = new EmployeeStatus();
		employeeStatus.setId(employeeStatusId);
		
		Long orderId = 9L;
		Order order = new Order();
		order.setId(orderId);
		
		Long parentId = 10L;
		Employee parent = new Employee();
		parent.setId(parentId);
		
		String name = "name1";
		String firstName = "first name";
		String fatherName = "father name";
		String surname = "surname";
		String invNum = "inv num";
		Double rate = 1.0;
		Integer isPlurality = 1;
		Integer isPensioner = 2;
		Date endDate = new Date();
		String docSeries = "doc series";
		String docNum = "Dco num";
		String phone = "phone number";
		String email = "email@email.com";
		Date begDate = new Date();
		Date birthDate = new Date();
		
		EmployeeResource expected = new EmployeeResource();
		expected.setName(name);
		expected.setFirstName(firstName);
		expected.setFatherName(fatherName);
		expected.setSurname(surname);
		expected.setBirthDate(birthDate);
		expected.setInvNum(invNum);
		expected.setRate(rate);
		expected.setIsPlurality(isPlurality);
		expected.setIsPensioner(isPensioner);
		expected.setBegDate(begDate);
		expected.setEndDate(endDate);
		expected.setDocSeries(docSeries);
		expected.setDocNum(docNum);
		expected.setPhone(phone);
		expected.setEmail(email);
		expected.setEmployeeTypeId(employeeTypeId);
		expected.setPersonId(personId);
		expected.setGenderTypeId(genderTypeId);
		expected.setDepartmentId(departmentId);
		expected.setPostId(postId);
		expected.setJobTypeId(jobTypeId);
		expected.setEmployeeStatusId(employeeStatusId);
		expected.setOrderId(orderId);
		expected.setParentId(parentId);
		
		Employee source = new Employee();
		source.setName(name);
		source.setFirstName(firstName);
		source.setFatherName(fatherName);
		source.setSurname(surname);
		source.setBirthDate(birthDate);
		source.setInvNum(invNum);
		source.setRate(rate);
		source.setIsPlurality(isPlurality);
		source.setIsPensioner(isPensioner);
		source.setBegDate(begDate);
		source.setEndDate(endDate);
		source.setDocSeries(docSeries);
		source.setDocNum(docNum);
		source.setPhone(phone);
		source.setEmail(email);
		source.setEmployeeType(employeeType);
		source.setPerson(person);
		source.setGenderType(genderType);
		source.setDepartment(department);
		source.setPost(post);
		source.setJobType(jobType);
		source.setEmployeeStatus(employeeStatus);
		source.setOrder(order);
		source.setParent(parent);
		
		// When
		EmployeeResource actual = unit.convert(source);

		// Then
		assertEquals(expected, actual);
	}
	
	@Test
	public void testConvertWithNoRelations() throws Exception {
		// Given
		String name = "name1";
		String firstName = "first name";
		String fatherName = "father name";
		String surname = "surname";
		String invNum = "inv num";
		Double rate = 1.0;
		Integer isPlurality = 1;
		Integer isPensioner = 2;
		Date endDate = new Date();
		String docSeries = "doc series";
		String docNum = "Dco num";
		String phone = "phone number";
		String email = "email@email.com";
		Date begDate = new Date();
		Date birthDate = new Date();
		
		EmployeeResource expected = new EmployeeResource();
		expected.setName(name);
		expected.setFirstName(firstName);
		expected.setFatherName(fatherName);
		expected.setSurname(surname);
		expected.setBirthDate(birthDate);
		expected.setInvNum(invNum);
		expected.setRate(rate);
		expected.setIsPlurality(isPlurality);
		expected.setIsPensioner(isPensioner);
		expected.setBegDate(begDate);
		expected.setEndDate(endDate);
		expected.setDocSeries(docSeries);
		expected.setDocNum(docNum);
		expected.setPhone(phone);
		expected.setEmail(email);
		
		Employee source = new Employee();
		source.setName(name);
		source.setFirstName(firstName);
		source.setFatherName(fatherName);
		source.setSurname(surname);
		source.setBirthDate(birthDate);
		source.setInvNum(invNum);
		source.setRate(rate);
		source.setIsPlurality(isPlurality);
		source.setIsPensioner(isPensioner);
		source.setBegDate(begDate);
		source.setEndDate(endDate);
		source.setDocSeries(docSeries);
		source.setDocNum(docNum);
		source.setPhone(phone);
		source.setEmail(email);
		
		// When
		EmployeeResource actual = unit.convert(source);
		
		// Then
		assertEquals(expected, actual);
	}
}
