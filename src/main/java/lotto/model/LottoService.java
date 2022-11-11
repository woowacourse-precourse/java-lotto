package lotto.model;


public class LottoService {
    static final int LOTTO_PRICE = 1000;

    private void validateMoney(String money) {
        int tempMoney;

        try {
            tempMoney = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]구입 금액은 숫자여야합니다.");
        }
        if (tempMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR]구입 금액은 1000으로 나누어 떨어져야합니다.");
        }
        if (tempMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR]구입 금액은 로또 한장의 가격을 넘어야 합니다.");
        }
    }
}
