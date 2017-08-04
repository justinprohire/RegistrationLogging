package com.prohire.user.service;

import com.prohire._domain.HireCompany;
import com.prohire.event.annotation.PHEventListener;
import com.prohire.event.annotation.PHEventType;
import com.prohire.service.PHServiceInvoker;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoggingServiceImpl implements LoggingService {
    private static final Logger LOGGER = Logger.getLogger(LoggingServiceImpl.class);

    @Override
    public void logData(String serviceName,String message) {
        LOGGER.info("Service : " +serviceName + " Msg: " + message);
    }

    @Override
    public void setServiceInvoker(PHServiceInvoker phServiceInvoker) {

    }

    @PHEventListener(type = PHEventType.TARIFF_UPDATE)
    public void logFromKafka(String message){
        LOGGER.info("KAFKA LOGGING SERVICE " + message);

    }

}
