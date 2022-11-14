package lotto.domain;

public class PurchaseService {

    private final static String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 구매 금액은 숫자여야 합니다.";
    private final static String NOT_NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 구매 금액은 0 이상의 1000의 배수여야 합니다.";
    private final static String NOT_MULTIPLE_OF_1000_ERROR_MESSAGE= "[ERROR] 구매 금액은 1000의 배수여야 합니다.";
    private final static int PRICE = 1000;
    private final static int MIN = 0;

    private int purchaseAmount;

    public void parsePurchaseInput(String input){
        calculateAmount(input);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void calculateAmount(String input){
            isInteger(input);
            int totalAmount = Integer.parseInt(input);
            isNegative(totalAmount);
            isMultipleOf1000(totalAmount);
            purchaseAmount = totalAmount/PRICE;
    }

    private void isInteger(String input){
        final String numberRegex= "[0-9]+";

        if(!input.matches(numberRegex)){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private void isNegative(int input){
        if(input < MIN){
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private void isMultipleOf1000(int input){
        if(input % PRICE != 0){
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_1000_ERROR_MESSAGE);
        }
    }

}
