package org.dhananjay.csvprocessor.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * TODO..
 * @author dhananjayp
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CSVHeaderName {

	String headerName();
}
