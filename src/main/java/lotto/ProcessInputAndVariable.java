package lotto;

public class ProcessInputAndVariable {
    private static final Integer LOTTO_DIVIDE_PRICE = 1000;
    private final ValidInput validInput = new ValidInput();
    public Integer convertToInteger (String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 정수로 변환될 수 없습니다.");
        }
    }

    public Integer calculateLottoAmount (Integer price) {
        validInput.validCashAmount(price, LOTTO_DIVIDE_PRICE);
        return price / LOTTO_DIVIDE_PRICE;
    }
}
