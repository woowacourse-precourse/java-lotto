package lotto.domain;

import lotto.message.ErrorMessage;
import lotto.util.Input;

public class PurchaseLotto {

    public int purchaseAmount;
    public int purchaseCount;

    public PurchaseLotto() throws IllegalArgumentException {
        this.purchaseAmount = purchaseAmountCal(Input.input());
        this.purchaseCount = purchaseAmount/1000;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    // 입력값 검증 메서드
    private int purchaseAmountCal(String input) throws IllegalArgumentException {
        validEmpty(input);
        validCharacter(input.toCharArray());
        int inputInt = StringToInt(input);
        validThousand(inputInt);
        return inputInt;
    }

    // 사용자가 입력한 값이 숫자인지 아닌지 예외처리
    private void validCharacter(char[] inputArray) throws IllegalArgumentException{
        for (char c : inputArray) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.PURCHASE_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    // 사용자가 입력한 값이 빈값이면 예외처리
    private void validEmpty(String input) throws IllegalArgumentException{
        if (input.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_EMPTY_ERROR_MESSAGE);
        }
    }

    // 입력값 int로 형변환
    private int StringToInt(String input) {
        return Integer.parseInt(input);
    }

    // 입력값이 1000으로 나누어지는지 검증
    private void validThousand(int input) throws IllegalArgumentException{
        if(input % 1000 != 0 || input < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_THOUSAND_ERROR_MESSAGE);
        }
    }
}
