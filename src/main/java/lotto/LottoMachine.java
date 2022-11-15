package lotto;

public class LottoMachine {

    private final int buyLineMoney = 1000;
    private final int minLottoNumber = 1;
    private final int maxLottoNumber = 45;
    private final int oneLineLottoNumber = 6;

    public int buyLottoLineNumber(String inputMoney) {

        int money = Integer.parseInt(inputMoney);

        return money / buyLineMoney;
    }
}
