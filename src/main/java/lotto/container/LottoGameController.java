package lotto.container;

import lotto.service.*;
import lotto.view.InputOutputView;

import java.util.List;

public class LottoGameController {
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
