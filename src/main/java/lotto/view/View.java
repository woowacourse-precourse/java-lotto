package lotto.view;

import lotto.constant.LottoMoney;
import lotto.constant.LottoPhrases;
import lotto.view.converter.ConvertMoney;
import lotto.view.converter.ConvertPlayerNumbers;
import lotto.view.validation.LottoValidation;
import lotto.view.validation.MoneyValidation;
import lotto.view.validation.Validation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.LottoPhrases.*;

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
        System.out.println("3개 일치 (5,000원) - " + lottoReward.get(LottoMoney.FIFTH.getReward())+"개");
        System.out.println("4개 일치 (50,000원) - " + lottoReward.get(LottoMoney.FOURTH.getReward())+"개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoReward.get(LottoMoney.THIRD.getReward())+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoReward.get(LottoMoney.SECOND.getReward())+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoReward.get(LottoMoney.FIRST.getReward())+"개");
    }

    public void showProfitRate(String profitRate) {
        System.out.println("총 수익률은 "+profitRate+"입니다.");
    }
}

