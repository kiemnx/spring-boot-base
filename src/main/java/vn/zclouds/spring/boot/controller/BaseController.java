package vn.zclouds.spring.boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.zclouds.spring.boot.controller.request.InsertRequest;
import vn.zclouds.spring.boot.factory.ResponseFactory;
import vn.zclouds.spring.boot.repository.entity.BaseEntity;
import vn.zclouds.spring.boot.services.BaseService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1.0/base")
public class BaseController {

    private static Logger logger = LogManager.getLogger(BaseController.class);

    @Autowired
    BaseService baseService;

    @Autowired
    ResponseFactory factory;

    @GetMapping(value = "/read", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity readData(){
        logger.info("Start read data from DB and return data");
        List<BaseEntity> data = baseService.readAllFromDB();
        return factory.success(data, List.class);
    }

    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String insertDataIntoDB(@RequestBody InsertRequest request){
        logger.info("Start insert data from user to DB");
        String result = baseService.insertDataToDB(request);
        return result;
    }
}
