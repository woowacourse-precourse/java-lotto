package lotto.service;

import lotto.view.InputOutputView;

import java.util.List;

public class RelativeResultService {
    private InputOutputView inputOutputView = new InputOutputView();
    private MyTotalMoney myTotalMoney = new MyTotalMoney();
    private WinningMoney winningMoney = new WinningMoney();;
    private TotalYield totalYield;

    private int gain;
    private double myYield;
    private List<Integer> grades;
    private List<List<Integer>> myLottoNumbers;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int money;

    public RelativeResultService(List<List<Integer>> myLottoNumbers, List<Integer> winningNumbers, int bonusNumber, int money) {
        this.myLottoNumbers = myLottoNumbers;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.money = money;
    }

    public void relativeResult() {
        gain = myTotalMoney.totalMoney(myLottoNumbers, winningNumbers, bonusNumber);

        totalYield = new TotalYield(money, gain);

        myYield = totalYield.getYield();
        System.out.println("당첨 통계");
        System.out.println("--");
        grades = winningMoney.getGrade(winningNumbers, myLottoNumbers, bonusNumber);
        inputOutputView.saveResult(grades);
        inputOutputView.totalYield(myYield);
    }
}
