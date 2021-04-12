package com.smhrd.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class MemberExceptionController {
    /* @Valid 어노테이션의 유효성 체크에 통과하지 못하면 MethodArgumentNotValidException 발생 */
    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public static ErrorResponse methodValidException(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = makeErrorResponse(e.getBindingResult());
        return errorResponse;
    }
     */

    public static ErrorResponse makeErrorResponse(BindingResult bindingResult) {
        String code = "";
        String description = "";
        //String detail = "";

        if(bindingResult.hasErrors()) {
            // 에러가 있다면 객체에서 지정한 message 값을 가져옴
            //detail = bindingResult.getFieldError().getDefaultMessage();

            // 유효성 체크 어노테이션명을 가져옴
            String bindResultCode = bindingResult.getFieldError().getCode();

            switch (bindResultCode) {
                case "NotBlank":
                    code = MemberErrorCode.NOT_NULL.getCode();
                    description = MemberErrorCode.NOT_NULL.getDescription();
                    break;

                case "Email":
                    code = MemberErrorCode.INVALID_EMAIL.getCode();
                    description = MemberErrorCode.INVALID_EMAIL.getDescription();

            }
        }

        return new ErrorResponse(code, description);
    }
}
