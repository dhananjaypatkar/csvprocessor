package org.dhananjay.csvprocessor.processor.impl;


/**
 * CSV Convertor interface, accepts the domain object or POJO 
 * and converts it to string in comma separated format
 * 
 * @author dhananjayp
 *
 * @param <T>
 */
interface CSVConvertor<T> {

	/**
	 * @param object
	 * 		Domain object /pojo which needs to converted in to CSV format
	 * @return	string
	 * 		CSV formatted string of the provided object
	 */
	String convert(T object);
	
	/**
	 * Returns the header of the CSV file.., this can be optional
	 * 
	 * @return
	 */
	String getHeader();
}
