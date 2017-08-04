package com.prohire.user.client;

import com.prohire.service.annotation.PHServiceClient;
import com.prohire.user.service.LoggingService;
import com.prohire.service.PHServiceInvoker;
import org.springframework.stereotype.Component;
import org.springframework.cache.annotation.Cacheable;

@Component
@PHServiceClient
public class LoggingClient implements LoggingService {

private PHServiceInvoker serviceInvoker;


	@Override
	public void logData(final String serviceName, final String message) {
		Class[] paramClasses = new Class[2];
		try {
			paramClasses[0] = Class.forName("java.lang.String");
			paramClasses[1] = Class.forName("java.lang.String");
		} catch(ClassNotFoundException cnfe) { throw new IllegalStateException(cnfe); }
			serviceInvoker.callAsync("logData", null, paramClasses, serviceName, message);
	}

	@Override
	public void setServiceInvoker(final PHServiceInvoker serviceInvoker) {
		this.serviceInvoker = serviceInvoker;
	}

}
