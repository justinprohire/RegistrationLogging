package com.prohire.user.service;

import com.prohire.service.ProhireService;
import com.prohire.service.annotation.PHEndpoint;
import com.prohire.service.annotation.PHEndpoints;
import com.prohire.service.annotation.PHService;
import com.prohire.service.annotation.PHServiceMethod;

@PHService(minor = 1,major = 1)
@PHEndpoints(endpoints = {
        @PHEndpoint(name = LoggingService.LOGGING_ASYNC_ENDPOINT,synchronous = false)
})
public interface LoggingService extends ProhireService {

    public static final String LOGGING_ASYNC_ENDPOINT = "loggingEndpointAsync";
    public static final String LOGGING_ASYNC_METHOD = "logData";

    @PHServiceMethod(endPointName = LOGGING_ASYNC_ENDPOINT,name = LOGGING_ASYNC_METHOD)
    void logData(String serviceName, String message);
}
