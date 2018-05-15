package Exceptions;

public class DuplicatedMsgException extends RuntimeException{
    private static final String Duplicated_Msg = "Mensagem duplicada.";

    public DuplicatedMsgException(){
        super();
    }

    public String getErrorMsg() {
        return Duplicated_Msg;
    }
}
