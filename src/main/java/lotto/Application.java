package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            UI lottoUI = new UI();

            String moneyInput = lottoUI.moneyInput();
            lottoUI.lottoByMoney(moneyInput);

            lottoUI.printNumberOfLotto();
            lottoUI.printLottoNumber();

            List<String> prizeNumbers = lottoUI.prizeNumbersInput();
            lottoUI.setPrizeNumbers(prizeNumbers);
            String bonusNumber = lottoUI.bonusNumberInput();
            lottoUI.setBonusNumber(bonusNumber);

            lottoUI.printLottoResult();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
