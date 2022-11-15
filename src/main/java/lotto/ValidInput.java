package lotto;

public class ValidInput {
    public void validCashAmount(Integer cash, Integer lottoDividePrice) {
        if (cash % lottoDividePrice != 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 1,000으로 나누어지지 않습니다!");
        }
    }
}
