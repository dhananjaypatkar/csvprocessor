package org.dhananjay.csvprocessor.processor.impl;

class CSVHeaderMetadata {

	private int index;
	
	private String header;
	
	public CSVHeaderMetadata(int index,String header) {
		this.index = index;
		this.header = header;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if (obj instanceof CSVHeaderMetadata) {
			CSVHeaderMetadata other = (CSVHeaderMetadata) obj;
			if((other.index == this.index ) && (other.header.equals(this.header)))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.index + this.header.hashCode();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
}
