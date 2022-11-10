package lotto.container;

import lotto.service.*;
import lotto.view.InputOutputView;

import java.util.List;

public class LottoGameController {
    /**
     * 구입금액을 입력해 주세요.
     * 8000
     *
     * 8개를 구매했습니다.
     * [8, 21, 23, 41, 42, 43]
     * [3, 5, 11, 16, 32, 38]
     * [7, 11, 16, 35, 36, 44]
     * [1, 8, 11, 31, 41, 42]
     * [13, 14, 16, 38, 42, 45]
     * [7, 11, 30, 40, 42, 43]
     * [2, 13, 22, 32, 38, 45]
     * [1, 3, 5, 14, 22, 45]
     *
     * 당첨 번호를 입력해 주세요.
     * 1,2,3,4,5,6
     *
     * 보너스 번호를 입력해 주세요.
     * 7
     *
     * 당첨 통계
     * ---
     * 3개 일치 (5,000원) - 1개
     * 4개 일치 (50,000원) - 0개
     * 5개 일치 (1,500,000원) - 0개
     * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
     * 6개 일치 (2,000,000,000원) - 0개
     * 총 수익률은 62.5%입니다.
     */
    private InputOutputView inputOutputView = new InputOutputView();
    private MyTotalMoney myTotalMoney = new MyTotalMoney();
    private BuyLotto buyLotto = new BuyLotto();
    private ProduceWinningNumbers produceWinningNumbers = new ProduceWinningNumbers();
    private WinningMoney winningMoney;
    private TotalYield totalYield;

    private int money;
    private int gain;
    private double myYield;
    private int bonusNumber;
    private int quantity;
    private List<List<Integer>> myLottoNumbers;
    private List<Integer> winningNumbers;
    private List<Integer> grades;

    public void gameStart() {
        money = inputOutputView.buyMoney();
        quantity = buyLotto.buyLotto(money);
        myLottoNumbers = buyLotto.getMyLottoNumbers(quantity);
        winningNumbers = produceWinningNumbers.getWinningNumbers();
        bonusNumber = produceWinningNumbers.getBonusNumber(winningNumbers);
        gain = myTotalMoney.totalMoney(myLottoNumbers, winningNumbers, bonusNumber);

        totalYield = new TotalYield(money, gain);

        myYield = totalYield.getYield();

        winningMoney = new WinningMoney();

        System.out.println("당첨 통계");
        System.out.println("--");
        grades = winningMoney.getGrade(winningNumbers, myLottoNumbers, bonusNumber);
        inputOutputView.saveResult(grades);
        inputOutputView.totalYield(myYield);
    }

}
