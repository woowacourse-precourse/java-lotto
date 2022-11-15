package controller;

import lotto.Lotto;
import service.LottoUserService;
import view.InputUI;
import view.OutputUI;

import java.util.List;

public class GameController {
    private int count = 0;
    private InputUI inputUI;
    private OutputUI outputUI;
    private LottoUserService lottoService;
    private Lotto lotto;
    private int bonusNumber;
    List<List<Integer>> userRandomNumbers;

    // 필드 초기화 및 게임 작동
    public void runGame() {
        inputUI = new InputUI();
        outputUI = new OutputUI();
        lottoService = new LottoUserService();

        startGame();
        doGame();
        endGame();
    }

    // 게임 시작 부분
    public void startGame() {
        // 1. 로또 구입 금액 입력 기능 (게임 시작)
        int amount = Integer.parseInt(inputUI.inputPurchaseAmount());
        count = outputUI.printPurchaseAmountResult(amount);
    }

    // 게임 동작 부분
    public void doGame() {
        // 2. 구매한 로또 개수만큼 랜덤 번호 생성
        userRandomNumbers = outputUI.printUserRandomNumbers(count);

        // 3. 당첨 번호 및 보너스 숫자 입력 기능
        lotto = new Lotto(lottoService.changeTypeOfWinningNumbers(inputUI.inputWinningNumbers()));
        bonusNumber = inputUI.inputBonusNumber();
    }

    // 게임 종료 부분
    public void endGame() {
        outputUI.printWinningResult(userRandomNumbers, count, lotto);
    }
}
