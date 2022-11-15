package lotto.service;

import java.util.List;
import java.util.Random;

import lotto.domain.Lotto;
import lotto.domain.RandomLottoNumber;
import lotto.domain.Winner;
import lotto.util.ParserUtil;
import lotto.util.RandomUtil;
import lotto.util.ValidationUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private String inputPurchaseAmount;
    private List<RandomLottoNumber> randomLottoNumber;
    private Lotto winningNumber;
    private Integer bonusNumber;
    private int numOf1stPrize=0;
    private int numOf2ndPrize=0;
    private int numOf3rdPrize=0;
    private int numOf4thPrize=0;
    private int numOf5thPrize=0;
    private int accumulatedWinningPrize=0;

    public LottoService() {
        OutputView.purchaseAmountMsg();
        this.inputPurchaseAmount = InputView.getInputPurchaseAmount();
        int numOfLottery = RandomUtil.getCountFromMoney(inputPurchaseAmount);
        this.randomLottoNumber = RandomUtil.getLottoNumbers(inputPurchaseAmount);
        OutputView.purchaseResultMsg(randomLottoNumber, numOfLottery);
    }

    public void drawLotteries() {
        createWinningNumber();
        createBonusNumber();
        drawForWinner();
    }

    public void createWinningNumber() {
        OutputView.winningNumberMsg();
        String winningNumberInput = InputView.getInputWinningNumber();
        ParserUtil.parseWinningNumbersInput(winningNumberInput);
        List<Integer> winningNumberList = InputView.revertInputToList(winningNumberInput);
        this.winningNumber = new Lotto(winningNumberList);
    }

    private void createBonusNumber() {
        OutputView.bonusNumberMsg();
        String bonusNumberInput = InputView.getInputBonusNumber();
        ParserUtil.parseBonusNumberInput(bonusNumberInput);
        isDuplicate(bonusNumberInput);
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    private void drawForWinner() {
        for (RandomLottoNumber randomNumList : randomLottoNumber) {
            int winningCount = getWinningCount(randomNumList);
            boolean isBonus = isBonus(randomNumList, winningCount);
            Winner grade = Winner.getWinner(winningCount, isBonus);
            randomNumList.winner = grade;
            updateNumOfPrize(randomNumList);
            updatedWinningPrize(randomNumList);

        }
    }

    private int getWinningCount(RandomLottoNumber randomNum) {
        int count = 0;
        List<Integer> randomNumList = randomNum.getRandomNum();
        for (Integer randomDigit : randomNumList) {
            List<Integer> winningNumList = winningNumber.getNumbers();
            if (winningNumList.contains(randomDigit)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean isBonus(RandomLottoNumber randomNum, int winningCount) {
        List<Integer> randomNumList = randomNum.getRandomNum();
        if (winningCount == 5 && randomNumList.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private void updateNumOfPrize(RandomLottoNumber randomList) {
        Winner winningInfo = randomList.winner;
        int winningCount = winningInfo.getCount();
        boolean isBonusNum = winningInfo.isBonusNum();

        update1stPrize(winningCount);
        update2ndPrize(winningCount, isBonusNum);
        update3rdPrize(winningCount, isBonusNum);
        update4thPrize(winningCount);
        update5thPrize(winningCount);
    }

    private void update1stPrize(int winningCount) {
        if (winningCount==6) {
            this.numOf1stPrize += 1;
        }
    }

    private void update2ndPrize(int winningCount, boolean isBonusNum) {
        if (winningCount==5 && isBonusNum) {
            this.numOf2ndPrize += 1;
        }
    }

    private void update3rdPrize(int winningCount, boolean isBonusNum) {
        if (winningCount==5 && !isBonusNum) {
            this.numOf3rdPrize += 1;
        }
    }

    private void update4thPrize(int winningCount) {
        if (winningCount==4) {
            this.numOf4thPrize += 1;
        }
    }

    private void update5thPrize(int winningCount) {
        if (winningCount==3) {
            this.numOf5thPrize += 1;
        }
    }

    private void updatedWinningPrize(RandomLottoNumber randomList) {
        Winner winningInfo = randomList.winner;
        this.accumulatedWinningPrize += winningInfo.getPrize();
    }

    public void returnResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " +numOf5thPrize+"개");
        System.out.println("4개 일치 (50,000원) - " +numOf4thPrize+"개");
        System.out.println("5개 일치 (1,500,000원) - " +numOf3rdPrize+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +numOf2ndPrize+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " +numOf1stPrize+"개");
        System.out.println("총 수익률은 "+getProfitRatio()+"%입니다.");
    }

    private double getProfitRatio() {
        int purchaseAmount = Integer.valueOf(inputPurchaseAmount);
        double profitRatio = ((double) accumulatedWinningPrize / (double) purchaseAmount) * 100;
        return Math.round(profitRatio*10)/10.0;
    }

    private void isDuplicate(String input) throws IllegalArgumentException {
        List<Integer> winningNumbList = winningNumber.getNumbers();
        Integer bonusNum = Integer.valueOf(input);
        if (winningNumbList.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복될 수 없습니다.");
        }
    }
}