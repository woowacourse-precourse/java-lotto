package lotto.Function;

import java.util.List;

public class Pay {
    private final int cash;

    public Pay(int cash) {
        validateCash(cash);
        this.cash = cash;
    }

    private void validateCash(int cash) {
        if (0 < cash % 1000) {
            System.out.println("[ERROR] 금액 오류 1000원 단위만 입력가능");
            throw new IllegalArgumentException();
        }
    }

    public int makeLotto() {
        int result = 0;
        result = cash / 1000;
        return result;
    }
}
