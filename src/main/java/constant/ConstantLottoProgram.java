package constant;

public enum ConstantLottoProgram {
    RANGE_OF_LOTTO_NUMBER(1,45),LOTTO_LENGTH(6);
    int length;
    int minimum;
    int maximum;
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
}
