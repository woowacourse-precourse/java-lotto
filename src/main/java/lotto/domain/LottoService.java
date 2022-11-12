package lotto.domain;

public class LottoService {
    public int getLottoAmount(String number) {
        int balance = 0;

        try {
            balance = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("구입금액으로 입력된 문자열이 올바르지 않습니다.");
        }

        if (balance % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1,000원 단위이어야 합니다.");
        }

        return balance / 1000;
    }
}
