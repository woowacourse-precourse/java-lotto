package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Notice;


public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void executeLottoProgram() {
        createLotto();
        confirmResult();
    }

    private void createLotto() {
        System.out.println(Notice.LOTTO_PURCHASE_AMOUNT.getMessage());

        String purchaseAmount = Console.readLine();
        lottoService.generateLotto(purchaseAmount);
        lottoService.printLottoInfo();

    }

    private void confirmResult() {
        System.out.println(Notice.ENTER_WINNING_NUMBER.getMessage());
        String winningNumbers = Console.readLine();

        System.out.println(Notice.ENTER_BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();

        lottoService.checkWinningResult(winningNumbers, bonusNumber);
        lottoService.printResultMessage();
    }
}
