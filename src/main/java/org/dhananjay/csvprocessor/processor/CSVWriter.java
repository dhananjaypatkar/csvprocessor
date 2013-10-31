package org.dhananjay.csvprocessor.processor;

import java.util.List;

/**
 * Interface for writting list of domain objects / POJO in CSV format
 *  
 * @author dhananjayp
 *
 * @param <T>
 */
public interface CSVWriter<T> {

	/**
	 * Core method of the interface
	 * 
	 * @param path
	 * 			Path at which data needs to be written
	 * @param objects
	 * 			List of domain objects / pojo which contains data elements to be written
	 */
	void write(String path,List<T> objects);
	
}
