package lotto;

public class LottoCount {
    public int lottoTries(String money) {
        Exception checkMoney = new Exception();
        return checkMoney.isvalidMoney(Integer.parseInt(money));
    }
}
