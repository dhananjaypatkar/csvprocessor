package org.dhananjay.csvprocessor.processor.impl;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.dhananjay.csvprocessor.annotations.CSVHeaderIndex;
import org.dhananjay.csvprocessor.annotations.CSVProcessor;


/**
 * Implementation class for {@link CSVConvertor}
 * Utillizes {@link CSVHeaderIndex} and {@link CSVProcessor} annotations to 
 * derive the metadata.
 * Metadata is used to find the appropriate position of the pojo attribute in a csv.
 * 
 * 
 * @author dhananjayp
 *
 * @param <T>
 */
class BeanIndexCSVConvertor<T> implements CSVConvertor<T> {
	
	/**
	 * 
	 */
	private Map<CSVHeaderMetadata,Field> indexMap = new TreeMap<CSVHeaderMetadata, Field>(new Comparator<CSVHeaderMetadata>() {
		@Override
		public int compare(CSVHeaderMetadata o1, CSVHeaderMetadata o2) {
			if(o1.getIndex() == o2.getIndex())
				throw new RuntimeException("properties can not have same index "+o1.getIndex() + " for "+o1.getHeader() + ", "+o2.getHeader());
			if(o1.getIndex() < o2.getIndex())
				return -1;
			else
				return 1;
		}
	});

	/**
	 * Constructor has logic to populate index map based on {@link CSVHeaderIndex} & {@link CSVProcessor}.
	 * 
	 * @param type
	 */
	BeanIndexCSVConvertor(Class<T> type){
		if(type.isAnnotationPresent(CSVProcessor.class)){
			Field[] fields = type.getDeclaredFields();
			if(fields != null && fields.length !=0){
				for (Field field : fields) {
					if(field.isAnnotationPresent(CSVHeaderIndex.class)){
						CSVHeaderIndex csvIndexAnnotation = field.getAnnotation(CSVHeaderIndex.class);
						field.setAccessible(true);
						CSVHeaderMetadata headerMetadata = new CSVHeaderMetadata(csvIndexAnnotation.index(), csvIndexAnnotation.headerName());
						indexMap.put(headerMetadata,field);
					}
				}
			}else{
				throw new RuntimeException("Pojo fields are not annotated with @CSVHeaderIndex");	
			}
		}else{
			throw new RuntimeException("Pojo is not annotated with @CSVProcessor");
		}
	}


	/**
	 * @see org.dhananjay.csvprocessor.processor.impl.CSVConvertor#convert(java.lang.Object)
	 */
	@Override
	public String convert(T object) {
		StringBuilder commaSeparatedString = new StringBuilder("");
		for(Map.Entry<CSVHeaderMetadata, Field> entry : this.indexMap.entrySet()){
			Field field = entry.getValue();
			try {
				Object value = field.get(object);
				commaSeparatedString.append(value!=null ? value : "").append(",");
			} catch (IllegalArgumentException e) {
				// TODO Assuming empty value, logging an exceptionand moving ahead
				e.printStackTrace();
				commaSeparatedString.append(",");
			} catch (IllegalAccessException e) {
				// TODO assuming empty value,  logging an exceptionand moving ahead
				e.printStackTrace();
				commaSeparatedString.append(",");
			}
		}
		commaSeparatedString.deleteCharAt(commaSeparatedString.lastIndexOf(","));
		return commaSeparatedString.toString();
	}


	/**
	 * @see org.dhananjay.csvprocessor.processor.impl.CSVConvertor#getHeader()
	 */
	@Override
	public String getHeader() {
		StringBuilder commaSeparatedString = new StringBuilder("");
		for(Map.Entry<CSVHeaderMetadata, Field> entry : this.indexMap.entrySet()){
			CSVHeaderMetadata csvHeaderMetadata = entry.getKey();
			commaSeparatedString.append(csvHeaderMetadata.getHeader()).append(",");
		}
		commaSeparatedString.deleteCharAt(commaSeparatedString.lastIndexOf(","));
		return commaSeparatedString.toString();
	}

}