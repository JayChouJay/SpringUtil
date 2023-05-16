package exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException{
    private String message;
    public MyException(){}
    public MyException(String message){this.message=message;}
}
