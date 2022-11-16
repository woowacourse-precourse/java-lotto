package util;

public enum ErrorMessage {

    PREFIX("[ERROR] "),
    ONLY_NUMBER("숫자만 입력할 수 있습니다."),
    OVERLAP_NUMBER("중복된 숫자가 입력되었습니다."),
    NOT_LOTTONUMBER("1~45 사이에 숫자만 입력하셔야 합니다."),
    NOT_DIVIDE("천원으로 나누어 떨어지지 않습니다.");

    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return PREFIX.message+this.message;
    }
}
