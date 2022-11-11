package lotto;

public class LottoAmount {
    public long lottoTries(String money) {
        Validate checkMoney = new Validate();
        checkMoney.isContainOthers(money);
        return checkMoney.validMoney(Long.parseLong(money));
    }
}
