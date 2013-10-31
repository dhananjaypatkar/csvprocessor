package org.dhananjay.csvprocessor.processor.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.dhananjay.csvprocessor.pojo.Employee;
import org.dhananjay.csvprocessor.processor.CSVWriter;
/**
 * Class under test {@link BeanIndexCSVConvertor} and {@link CSVFileWriter}
 * 
 * @author dhananjayp
 *
 */
public class BeanIndexCSVWriterTest extends TestCase {

	public void testCSVConvertor(){
		Employee employee = new Employee();
		employee.setName("Dhananjay Patkar");
		employee.setEmail("dhananjay.patkar@gmail.com");
		employee.setAddress("Mumbai");
		employee.setId(1234L);
		employee.setSalary(10.99D);
		CSVConvertor<Employee>  csvConvertor = new BeanIndexCSVConvertor<Employee>(Employee.class);
		String str = csvConvertor.convert(employee);
		assertNotNull(str);
		assertTrue("Dhananjay Patkar,1234,10.99,Mumbai,dhananjay.patkar@gmail.com".equals(str));
	}
	
	public void testWrapperWriter(){
		List<Employee> lst = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setName("Dhananjay Patkar");
		employee.setEmail("dhananjay.patkar@gmail.com");
		employee.setAddress("Mumbai");
		employee.setId(1234L);
		employee.setSalary(10.99D);
		lst.add(employee);
		employee = new Employee();
		employee.setName("Dhananjay Patkar2");
		employee.setEmail("dhananjay.patkar2@gmail.com");
		employee.setAddress("Mumbai2");
		employee.setId(1234L);
		employee.setSalary(10.87D);
		lst.add(employee);
		CSVWriter<Employee> writer = new CSVFileWriter<Employee>(Employee.class);
		writer.write("employee.csv", lst);
		
	}
	/*
	public void testWrapperWriterException(){
		List<NoCSVProcessorEmployee> lst = new ArrayList<NoCSVProcessorEmployee>();
		NoCSVProcessorEmployee employee = new NoCSVProcessorEmployee();
		employee.setName("Dhananjay Patkar");
		employee.setEmail("dhananjay.patkar@gmail.com");
		employee.setAddress("Mumbai");
		employee.setId(1234L);
		employee.setSalary(10.99D);
		lst.add(employee);
		employee = new NoCSVProcessorEmployee();
		employee.setName("Dhananjay Patkar2");
		employee.setEmail("dhananjay.patkar2@gmail.com");
		employee.setAddress("Mumbai2");
		employee.setId(1234L);
		employee.setSalary(10.87D);
		lst.add(employee);
		try{
		CSVWriter<NoCSVProcessorEmployee> writer = new CSVFileWriter<NoCSVProcessorEmployee>(NoCSVProcessorEmployee.class);
		writer.write("employee.txt", lst);
		}catch(Exception e){
			assertTrue("Pojo is not annotated with @CSVProcessor".equals(e.getMessage()));
		}
	}*/
}
