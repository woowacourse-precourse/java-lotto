package lotto.view;

import lotto.constant.LottoPhrases;
import lotto.view.converter.ConvertMoney;
import lotto.view.converter.ConvertPlayerNumbers;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.LottoMoney.*;
import static lotto.constant.LottoPhrases.*;
import static lotto.constant.Profit.PROFIT;
import static lotto.constant.Result.RESULT;

public class View {
    private final ConvertPlayerNumbers convertPlayerNumbers;
    private final ConvertMoney convertMoney;

    public View() {
        convertPlayerNumbers = new ConvertPlayerNumbers();
        convertMoney = new ConvertMoney();
    }

    public String input() {
        return readLine();
    }

    public int inputMoney() {
        return convertMoney.toNumbers(input());
    }
    public List<Integer> inputLottoNumber() {
        return convertPlayerNumbers.toNumbers(input());
    }
    public int bonusNumber() {
        return convertPlayerNumbers.toBonusNumber(input());
    }

    public void inputMoneyMessage() {
        System.out.println(LottoPhrases.INPUT_MONEY_PHRASES.getMessage());
    }

    public void lotteryCountMessage(int count) {
        System.out.println(count + LOTTO_COUNT_PHRASES.getMessage());
    }
    public void inputLotteryNumbers() {
        System.out.println(INPUT_LOTTERY_NUMBERS.getMessage());
    }
    public void lotteryNumbers(List<List<Integer>> lotteryNumbers) {
        for(List<Integer> lotto : lotteryNumbers) {
            System.out.println(lotto.toString());
        }
    }
    public void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBERS.getMessage());
    }

    public void winningDetails(Map<Integer, Integer> lottoReward) { //

        System.out.println(RESULT.result(3,FIFTH.getReward(),lottoReward.get(FIFTH.getReward())));
        System.out.println(RESULT.result(4,FOURTH.getReward(),lottoReward.get(FOURTH.getReward())));
        System.out.println(RESULT.result(5,THIRD.getReward(),lottoReward.get(THIRD.getReward())));
        System.out.println(RESULT.result(5,SECOND.getReward(),lottoReward.get(SECOND.getReward())));
        System.out.println(RESULT.result(6,FIRST.getReward(),lottoReward.get(FIRST.getReward())));
    }

    public void showProfitRate(String profitRate) {
        System.out.println(PROFIT.profitRate(profitRate));
    }
}

