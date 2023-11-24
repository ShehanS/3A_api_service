package com.ncinga.aaa.dtos.response;


import com.ncinga.aaa.util.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseMessageDto {
    protected Object data;
    protected String message;
    protected Object error;
    protected ResponseCode code;

    public static ResponseMessageDto getInstance(Object response, String message, Object error, ResponseCode code) {
        ResponseMessageDto responseMessageDto = new ResponseMessageDto(response, null, null, code);
        return responseMessageDto;
    }

    public static ResponseMessageDto getInstance(String message, Object error, ResponseCode code) {
        ResponseMessageDto responseMessageDto = new ResponseMessageDto(null, message, null, code);
        return responseMessageDto;
    }

    public static ResponseMessageDto getInstance(String error, ResponseCode code) {
        ResponseMessageDto responseMessageDto = new ResponseMessageDto(null, null, error, code);
        return responseMessageDto;
    }
}
