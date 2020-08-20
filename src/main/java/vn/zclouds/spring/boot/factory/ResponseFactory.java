package vn.zclouds.spring.boot.factory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseFactory {

    public static ResponseEntity success() {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setStatus(ResponseStatus.SUCCESS_STATUS);
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity success(Object data, Class clazz) {
        GeneralResponse<Object> responseObject = new GeneralResponse();
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseStatus.SUCCESS_CODE);
        responseStatus.setMessage(ResponseStatus.SUCCESS_MESSAGE);
        responseObject.setStatus(responseStatus);
        responseObject.setData(clazz.cast(data));
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity success(Object data, Class clazz, Long total) {
        GeneralResponse<Object> responseObject = new GeneralResponse();
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseStatus.SUCCESS_CODE);
        responseStatus.setMessage(ResponseStatus.SUCCESS_MESSAGE);
        responseObject.setStatus(responseStatus);
        responseObject.setData(clazz.cast(data));
        return ResponseEntity.ok(responseObject);
    }

    public static ResponseEntity success(List<Object> data, PageResponse pageResponse) {
        GeneralPageResponse<Object> responseObject = new GeneralPageResponse<>(
                ResponseStatus.SUCCESS_STATUS,
                data,
                pageResponse);
        return ResponseEntity.ok(responseObject);
    }

    public static ResponseEntity success(Object data) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setStatus(ResponseStatus.SUCCESS_STATUS);
        responseObject.setData(data);
        return ResponseEntity.ok(responseObject);
    }

    public static ResponseEntity error(HttpStatus httpStatus, String errorCode, String errorMessage) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus = new ResponseStatus(errorCode, errorMessage);
        responseObject.setStatus(responseStatus);
        return new ResponseEntity(responseObject, httpStatus);
    }

    public static ResponseEntity error(HttpStatus httpStatus, String errorCode, String errorMessage, Object data, Class clazz) {
        GeneralResponse<Object> responseObject = new GeneralResponse();
        ResponseStatus responseStatus = new ResponseStatus(errorCode, errorMessage);
        responseObject.setStatus(responseStatus);
        responseObject.setData(clazz.cast(data));
        return new ResponseEntity(responseObject, httpStatus);

    }

    public static ResponseEntity generalError() {
        ResponseStatus responseStatus = new ResponseStatus();
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseStatus.setCode(ResponseStatus.GENERAL_ERROR_CODE);
        responseStatus.setMessage(ResponseStatus.GENERAL_ERROR_MESSAGE);
        responseObject.setStatus(responseStatus);
        ResponseEntity responseEntity = new ResponseEntity(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}