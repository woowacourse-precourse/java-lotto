package lotto;

import java.util.List;

public class Application {
    static Domain domain = new Domain();
    static UI ui = new UI();
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void main(String[] args) {
        try {
            manageLottoProcess();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return;
        }
    }

    private static void manageLottoProcess() {
        String moneyInput = ui.getInputMoney();
        domain.validatePriceInput(moneyInput);
        int numberOfLottos = Integer.parseInt(moneyInput) / 1000;
        List<Lotto> lottos = domain.createRandomLottoNumbers(numberOfLottos);
        ui.printLottoNumber(lottos);
        String winningNumberInput = ui.getInputWinningNumber();
        domain.validateWinningNumberInput(winningNumberInput);
        List<Integer> winningNumbers = domain.trimLottoNumberInput(winningNumberInput);
        String bonusNumberInput = ui.getInputBonusNumber();
        domain.validateNumberRange(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        ui.printWinningStats(domain.getRankList(lottos, winningNumbers, bonusNumber), numberOfLottos);
    }
}