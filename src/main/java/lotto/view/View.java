package lotto.view;

import lotto.constant.LottoMoney;
import lotto.constant.LottoPhrases;
import lotto.view.converter.ConvertMoney;
import lotto.view.converter.ConvertPlayerNumbers;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.LottoPhrases.*;
import static lotto.constant.Result.*;

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

    public void winningDetails(Map<String, Integer> lottoReward) {
        System.out.println(THREE_MATCH.getValue() + lottoReward.get(LottoMoney.FIFTH.getReward())+COUNT.getValue());
        System.out.println(FOUR_MATCH.getValue() + lottoReward.get(LottoMoney.FOURTH.getReward())+COUNT.getValue());
        System.out.println(FIVE_MATCH.getValue() + lottoReward.get(LottoMoney.THIRD.getReward())+COUNT.getValue());
        System.out.println(FIVE_BONUS_MATCH.getValue() + lottoReward.get(LottoMoney.SECOND.getReward())+COUNT.getValue());
        System.out.println(SIX_MATCH.getValue() + lottoReward.get(LottoMoney.FIRST.getReward())+COUNT.getValue());
    }

    public void showProfitRate(String profitRate) {
        System.out.println(PROFIT_RATE.getValue()+profitRate+IS.getValue());
    }
}

