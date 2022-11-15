package lotto.Constant;

public enum ErrorMessage {
    INVALID_NOTANUMBER("Input is not a number"),
    INVALID_INPUTARGSNUM("Invalid number of input arguments"),
    INVALID_DUPLICATED("Input has Duplicated number"),
    INVALID_1000X("Input value is not a multiple of 1000");
    final private String ErrMes;
    public String print(){
        return ErrMes;
    }
    private ErrorMessage(String ErrMes){
        this.ErrMes = "[ERROR] "+ ErrMes;
    }
}
