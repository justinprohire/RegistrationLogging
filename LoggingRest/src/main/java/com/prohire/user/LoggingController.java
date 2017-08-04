package com.prohire.user;

import com.prohire.user.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    @Autowired
    LoggingService loggingService;

    @RequestMapping(value = "/logg",method = RequestMethod.GET)
    public ResponseEntity<String> logData(@RequestParam(value = "serviceName") String serviceName,
                                          @RequestParam(value = "message") String message){
        loggingService.logData(serviceName,message);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
