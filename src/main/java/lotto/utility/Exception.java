package lotto.utility;

public interface Exception {
    public final int ZERO_ASCII = 48;
    public final int NINE_ASCII = 57;

    public final String INPUT_IS_NOT_NUM_EXCEPTION_MESSAGE = "[ERROR] 입력 값이 숫자가 아닙니다.";
    public final String PRICE_CAN_NOT_DIVIDE_EXCEPTION_MESSAGE = "[ERROR] 입력 값이 1,000원 단위가 아닙니다.";

    public static void checkInputIsNum(String input){
        for(int index = 0; index < input.length(); ++index)
            if(input.charAt(index) > NINE_ASCII || input.charAt(index) < ZERO_ASCII)
                throw new IllegalArgumentException(INPUT_IS_NOT_NUM_EXCEPTION_MESSAGE);
    }

    public static void checkPriceCanDivide(int price){
        if(price % 1000 != 0)
            throw new IllegalArgumentException(PRICE_CAN_NOT_DIVIDE_EXCEPTION_MESSAGE);
    }
}
