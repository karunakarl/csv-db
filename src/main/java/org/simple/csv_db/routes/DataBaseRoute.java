package org.simple.csv_db.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.simple.csv_db.extensions.CustomBindyCsvDataFormat;
import org.simple.csv_db.model.Employee;
import org.simple.csv_db.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DataBaseRoute extends RouteBuilder {
    
    @Autowired
    private DataRepository dataRepository;
    
    @Autowired
    private CustomBindyCsvDataFormat bindyCSVDataFromat;

    @Override
    public void configure() throws Exception {
	from("file://data/output?fileName=Sample.txt&noop=true").routeId("readRoute").autoStartup(true).split(body()).unmarshal(bindyCSVDataFromat).process(this::saveEmployees);
    }
    
    private  void saveEmployees(Exchange exchange){
	System.out.println("saving... "+((Employee)exchange.getIn().getBody()).getFirstName());
	dataRepository.save((Employee)exchange.getIn().getBody());
    }
    
    

}
