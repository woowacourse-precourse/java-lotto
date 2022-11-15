package controller;

import lotto.Lotto;
import service.LottoService;
import view.InputUI;
import view.OutputUI;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private int count = 0;
    private InputUI inputUI;
    private OutputUI outputUI;
    private LottoService lottoService;
    private Lotto lotto;
    private int bonusNumber;
    List<List<Integer>> userRandomNumbers;

    public void startGame() {
        // 1. 로또 구입 금액 입력 기능 (게임 시작)
        inputUI = new InputUI();
        int amount = Integer.parseInt(inputUI.inputPurchaseAmount());
        outputUI = new OutputUI();
        count = outputUI.printPurchaseAmountResult(amount);
    }

    public void doGame() {
        // 2. 구매한 로또 개수만큼 랜덤 번호 생성
        userRandomNumbers = outputUI.printUserRandomNumbers(count);

        // 3. 당첨 번호 및 보너스 숫자 입력 기능
        lottoService = new LottoService();
        lotto = new Lotto(lottoService.changeTypeOfWinningNumbers(inputUI.inputWinningNumbers()));
        bonusNumber = inputUI.inputBonusNumber();
    }

    public void endGame() {
        outputUI.printWinningResult(userRandomNumbers, count, lotto);
    }
}
