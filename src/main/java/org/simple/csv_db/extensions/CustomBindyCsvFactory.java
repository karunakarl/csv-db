package org.simple.csv_db.extensions;

import org.apache.camel.dataformat.bindy.BindyCsvFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomBindyCsvFactory extends BindyCsvFactory {

    private static final Logger LOG = LoggerFactory.getLogger(CustomBindyCsvFactory.class);

    private boolean isCustomHeaderGenerate;

    public CustomBindyCsvFactory(Class<?> classType, boolean isCustomHeaderGenerate) throws Exception {
	super(classType);
	this.isCustomHeaderGenerate = isCustomHeaderGenerate;
    }

    public void setGenarateHeader(boolean isCustomHeaderGenerate) {
	this.isCustomHeaderGenerate = isCustomHeaderGenerate;
	LOG.debug("Setting Header value in the CustomBindyFactory :{}", isCustomHeaderGenerate);
    }

    /**
     * Flag indicating if the first line of the CSV must be skipped
     */
    @Override
    public synchronized boolean getGenerateHeaderColumnNames() {
	if (isCustomHeaderGenerate) {
	    LOG.debug("Toggling the Header value in the CustomBindyFactory:{}", isCustomHeaderGenerate);
	    this.isCustomHeaderGenerate = false;
	    return true;
	}
	return this.isCustomHeaderGenerate;
    }

}
