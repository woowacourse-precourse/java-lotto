package data;

/**
 * numeric은 숫자, outputMoney는 출력용 문자열 입니다.
 */
public enum NumericData {
    NUMBER_AMOUNT(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_PRICE(1000);

    private final int numeric;
    NumericData(int numeric){
        this.numeric = numeric;
    }

    public int getNumericValue(){
        return numeric;
    }

}
