package lotto;

public class LottoAmount {
    public long lottoTries(String money) {
        Validate checkMoney = new Validate();
        return checkMoney.isValidMoney(Long.parseLong(money));
    }
}
