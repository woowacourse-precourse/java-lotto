package constant;

import java.util.Collections;

public enum ConstantLottoProgram {
    RANGE_OF_LOTTO_NUMBER(1,45),LOTTO_LENGTH(6),ERROR_CODE(false,-1);
    int length,minimum,maximum,errorCode;
    boolean isError;
    ConstantLottoProgram(boolean isError, int errorCode){
        this.isError =isError;
        this.errorCode = errorCode;
    }
    ConstantLottoProgram(int length){
        this.length = length;
    }
    ConstantLottoProgram(int minimum, int maximum){
        this.maximum = maximum;
        this.minimum = minimum;
    }
    public int getMax(){
        return maximum;
    }
    public int getLength(){
        return length;
    }
    public int getMin(){
        return minimum;
    }
    public boolean isErrorState(){return isError;}
    public int getErrorCode(){return errorCode;}
}
