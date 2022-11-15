package data;

/**
 * numeric은 숫자, outputMoney는 출력용 문자열 입니다.
 */
public enum NumericData {
    NUMBER_AMOUNT(6, "6"),
    MIN_NUMBER(1, "1"),
    MAX_NUMBER(45, "45");

    private final int numeric;
    private String outputMoney;
    NumericData(int numeric){
        this.numeric = numeric;
    }

    NumericData(int numeric, String outputMoney){
        this.numeric = numeric;
        this.outputMoney = outputMoney;
    }

    public int getNumericValue(){
        return numeric;
    }

    public String getStringValue(){
        return outputMoney;
    }
}
