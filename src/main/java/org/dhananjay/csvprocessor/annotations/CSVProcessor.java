package org.dhananjay.csvprocessor.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marker annotation for POJO's which needs to be outputed
 * in CSV format
 * 
 * @author dhananjayp
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CSVProcessor {

}
