package lotto;

public class LottoAmount {
    public int lottoTries(String money) {
        Validate checkMoney = new Validate();
        return checkMoney.isValidMoney(Integer.parseInt(money));
    }
}
