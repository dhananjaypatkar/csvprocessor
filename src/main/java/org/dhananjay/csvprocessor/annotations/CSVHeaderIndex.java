package org.dhananjay.csvprocessor.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation storing metadata for CSV format
 * 
 * @author dhananjayp
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CSVHeaderIndex {
	
	
	/**
	 * Index of the attribute / property in CSV format
	 * @return int
	 * 		Index number 
	 */
	int index();
	
	/**
	 * Name of the header in CSV format
	 * @return
	 * 			Header name
	 */
	String headerName();
}
