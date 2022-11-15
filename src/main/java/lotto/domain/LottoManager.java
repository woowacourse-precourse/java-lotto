package lotto.domain;

import lotto.view.controller.MoneyView;

import java.util.Arrays;
import java.util.List;

import static lotto.view.controller.BonusNumberView.inputBonusNumber;
import static lotto.view.controller.LottoNumberView.inputLottoNumbers;
import static lotto.view.controller.LottoNumberView.printScoreBoard;

public class LottoManager {

    private static final Integer NEXT_COUNT = 1;
    private Integer totalBuyMoney;
    private Lotto winnerLottoNumbers;
    private Integer winnerBonusNumber;

    /**
     * score board 저장 순서: Empty/ THREE/ FOUR/ FIVE/ FIVE_ALPHA/ SIX/ ELSE
     */
    private List<Integer> scoreBoard;

    public LottoManager() {
        totalBuyMoney = 0;
        winnerBonusNumber = 0;
        scoreBoard = Arrays.asList(0,0,0,0,0,0,0);
    }

    public void start() {
        totalBuyMoney = MoneyView.inputMoneyNumber();
        List<Lotto> usersLottoNumbers = LottoGenerateManager.generateTotalLotto(totalBuyMoney);
        registerWinnerLottoNumbers();
        registerWinnerBonus();
        updateScoreBoard(usersLottoNumbers);
        printScoreBoard(scoreBoard);
    }

    private void updateScoreBoard(List<Lotto> usersLottoNumbers) {
        for (Lotto lotto : usersLottoNumbers) {
            ScoreInfo scoreInfo = lotto.getScoreInfoByWinnerLottoCountInfo(winnerLottoNumbers, winnerBonusNumber);
            scoreBoard.set(scoreInfo.getRank(), scoreBoard.get(scoreInfo.getRank()) + NEXT_COUNT);
        }
    }

    private void registerWinnerLottoNumbers() {
        List<Integer> inputLottoNumbers = inputLottoNumbers();
        winnerLottoNumbers = new Lotto(inputLottoNumbers);
    }

    private void registerWinnerBonus() {
        winnerBonusNumber = inputBonusNumber();
    }
}
