package com.iqmsoft.endpoint;

import java.math.BigInteger;

import javax.xml.bind.JAXBElement;


import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.iqmsoft.ticketagent.ObjectFactory;
import com.iqmsoft.ticketagent.TFlightsResponse;
import com.iqmsoft.ticketagent.TListFlights;

@Endpoint
public class TicketAgentEndpoint {

  @PayloadRoot(namespace = "http://iqmsoft.com/TicketAgent.xsd", localPart = "listFlightsRequest")
  @ResponsePayload
  public JAXBElement<TFlightsResponse> listFlights(
      @RequestPayload JAXBElement<TListFlights> request) {
    ObjectFactory factory = new ObjectFactory();
    
    TFlightsResponse tFlightsResponse = factory.createTFlightsResponse();
    
    tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(101));
    tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(102));
    tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(103));
    tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(104));
    tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(105));
    
    return factory.createListFlightsResponse(tFlightsResponse);
  }
}
