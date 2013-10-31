package org.dhananjay.csvprocessor.processor.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dhananjay.csvprocessor.processor.CSVWriter;

/**
 * Class to output list of objects as per standard
 * http://tools.ietf.org/html/rfc4180
 * 
 * @author dhananjayp
 *
 * @param <T>
 */
public class CSVFileWriter<T> implements CSVWriter<T> {

	/**
	 * 
	 */
	private final Class<T> type;
	
	public CSVFileWriter(Class<T> type) {
		this.type = type;
	}
	
	/**
	 * @see org.dhananjay.csvprocessor.processor.CSVWriter#write(java.lang.String, java.util.List)
	 */
	@Override
	public void write(String path, List<T> objects) {
		if(path == null || path.isEmpty())
			throw new RuntimeException("File path is empty or null");
		
		BufferedWriter writer = null;
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(path);
			writer = new BufferedWriter(fileWriter);
			CSVConvertor<T> convertor = new BeanIndexCSVConvertor<T>(type);
			
			//Writting header...
			String header = convertor.getHeader();
			writer.write(header);
			writer.newLine();
			
			//Writting data ...
			if(objects != null && !objects.isEmpty()){
				for (T t : objects) {
					String csvLine = convertor.convert(t);
					writer.write(csvLine);
					writer.newLine();
				}
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			throw new RuntimeException("Error while creating CSV file",e);
		}
	}

}
