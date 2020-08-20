package vn.zclouds.spring.boot.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.zclouds.spring.boot.controller.request.InsertRequest;
import vn.zclouds.spring.boot.repository.BaseRepository;
import vn.zclouds.spring.boot.repository.entity.BaseEntity;

import java.util.List;

@Service
public class BaseService {
    private static Logger logger = LogManager.getLogger(BaseService.class);

    @Autowired
    private BaseRepository baseRepository;

    public List<BaseEntity> readAllFromDB(){
        List<BaseEntity> data = baseRepository.findAll();
        logger.info("Found [{}] record from DB", data.size());
        return data;
    }

    public String insertDataToDB(InsertRequest request){
        BaseEntity entity = new BaseEntity();
        entity.setName(request.getName());
        entity.setPhone(request.getPhone());
        baseRepository.save(entity);
        return "SUCCESS";
    }
}
