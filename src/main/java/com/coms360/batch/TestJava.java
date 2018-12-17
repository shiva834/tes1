package com.coms360.batch;

import java.util.ArrayList;

import com.google.gson.Gson;

public class TestJava {

	public static void main(String[] args) {
		CustomerBusinessEvent cbe= new CustomerBusinessEvent("eventId","eventType","eventStatus","sourceSystem","businessNatureCode",
    			"amwayPartyId","aBONumber","channel","localeId","marketCode","eCommTypeCd",
    			"eventLogDate","communicationDate","businessKeys","internalId","content");
		/*CustomerBusinessEvent cbe1= new CustomerBusinessEvent("eventId","eventType","eventStatus","sourceSystem","businessNatureCode",
    			"amwayPartyId","aBONumber","channel","localeId","marketCode","eCommTypeCd",
    			"eventLogDate","communicationDate","businessKeys","internalId","content");*/
    	ArrayList<CustomerBusinessEvent> cbe3=new ArrayList<CustomerBusinessEvent>();
    //	cbe3.add(cbe);
    	cbe3.add(cbe);
    	Gson gson = new Gson();
        String json = gson.toJson(cbe3);
        System.out.println(json);
	}

}
