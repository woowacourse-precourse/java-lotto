package data;

/**
 * numeric은 숫자, outputMoney는 출력용 문자열 입니다.
 */
public enum NumericData {
    NUMBER_AMOUNT(6, "6"),
    MIN_NUMBER(1, "1"),
    MAX_NUMBER(45, "45"),
    LOTTO_PRICE(1000, "1,000"),
    FIFTH_PRIZE(5000, "5,000"),
    FOURTH_PRIZE(50000, "50,000"),
    THIRD_PRIZE(1500000, "1,500,000"),
    SECOND_PRIZE(30000000, "30,000,000"),
    FIRST_PRIZE(2000000000, "2,000,000,000");

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
