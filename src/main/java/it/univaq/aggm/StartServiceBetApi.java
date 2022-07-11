package it.univaq.aggm;

import java.util.List;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class StartServiceBetApi {

	public static void main(String[] args) {

		String restAddress = "http://localhost:8082/";
		String soapAddress = "http://localhost:8083/bet";
		startRest(restAddress);
        startSoap(soapAddress);
	}
	
	public static void startRest(String restAddress) {
		JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(BetRepository.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new BetRepository()));
        factoryBean.setAddress(restAddress);
        Server server = factoryBean.create();
        System.out.println("REST server ready...");
	}
	
	public static void startSoap(String soapAddress) {
		Endpoint.publish(soapAddress, new BetRepository());
		System.out.println("SOAP server ready...");
	}

}
