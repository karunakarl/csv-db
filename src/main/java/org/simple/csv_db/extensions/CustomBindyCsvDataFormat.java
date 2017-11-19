package org.simple.csv_db.extensions;

import org.apache.camel.dataformat.bindy.BindyAbstractFactory;
import org.apache.camel.dataformat.bindy.FormatFactory;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomBindyCsvDataFormat extends BindyCsvDataFormat {

    private static final Logger LOG = LoggerFactory.getLogger(CustomBindyCsvDataFormat.class);

    private boolean generateCSVHeader;

    public CustomBindyCsvDataFormat(Class<?> type, boolean generateCSVHeader) {
	super(type);
	this.generateCSVHeader = generateCSVHeader;
    }

    
   
    @Override
    protected BindyAbstractFactory createModelFactory(FormatFactory formatFactory) throws Exception {
	// TODO Auto-generated method stub
	CustomBindyCsvFactory customBindyCSVFactory = new CustomBindyCsvFactory(getClassType(), generateCSVHeader);
	customBindyCSVFactory.setFormatFactory(formatFactory);
	return customBindyCSVFactory;
    }


    protected BindyAbstractFactory createModelFactory() throws Exception {
	return new CustomBindyCsvFactory(getClassType(), generateCSVHeader);
    }

    public boolean isGenerateCSVHeader() {
	return generateCSVHeader;
    }

    public void setGenerateCSVHeader(boolean generateCSVHeader) {
	this.generateCSVHeader = generateCSVHeader;
	try {
	    ((CustomBindyCsvFactory) this.getFactory()).setGenarateHeader(generateCSVHeader);
	} catch (Exception e) {
	    LOG.error(e.getMessage());
	}
    }

}
