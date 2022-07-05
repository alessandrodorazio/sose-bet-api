package it.univaq.aggm;

import java.util.List;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class StartService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startRest();
        startSoap();
	}
	
	public static void startRest() {
		JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(BetRepository.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new BetRepository()));
        factoryBean.setAddress("http://localhost:8082/");
        Server server = factoryBean.create();
        System.out.println("REST server ready...");
	}
	
	public static void startSoap() {
		Endpoint ep = Endpoint.create(new BetRepository());
		List<Handler> handlerChain = ep.getBinding().getHandlerChain();
		ep.getBinding().setHandlerChain(handlerChain);
		ep.publish("http://localhost:8083/bet");
		System.out.println("SOAP server ready...");
	}

}