package lotto;

import java.util.List;

public class Application {
    static Domain domain = new Domain();
    static UI ui = new UI();
    private static final String ERROR_MESSAGE = "[ERROR] ";


    public static void main(String[] args) {
        try {
            // 1. 구입 금액 입력받기
            String moneyInput = ui.getInputMoney();
            domain.validatePriceInput(moneyInput);
            int numberOfLottos = Integer.parseInt(moneyInput) / 1000;
            // 2. 자동생성된 로또번호 리스트 저장 후 출력하기
            List<Lotto> lottos = domain.createRandomLottoNumbers(numberOfLottos);
            ui.printLottoNumber(lottos);
            // 3. 당첨 번호 입력받기
            String winningNumberInput = ui.getInputWinningNumber();
            domain.validateWinningNumberInput(winningNumberInput);
            List<Integer> winningNumbers = domain.trimLottoNumberInput(winningNumberInput);
            // 4. 보너스 번호 입력받기
            String bonusNumberInput = ui.getInputBonusNumber();
            domain.validateNumberRange(bonusNumberInput);
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            // 5. 당첨 통계, 수익률 출력하기
            ui.printWinningStats(domain.getRankList(lottos, winningNumbers, bonusNumber), numberOfLottos);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }
}