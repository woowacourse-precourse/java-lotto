package lotto.controller;

import lotto.domain.*;
import lotto.view.GuidePrint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.view.GuidePrint.*;

public class LottoController {
    public void execute(){
        System.out.println(INPUT_MONEY_MESSAGE);
        Money money = new Money();
        UserLottos userLottos = new UserLottos(money);
        System.out.printf(BUY_MESSAGE, userLottos.getUserLottos().size());
        UserLottosPrint(userLottos);
        System.out.printf(WINNING_NUMBER_INPUT_MESSAGE);
        PrizeLotto prizeLotto = new PrizeLotto();
        System.out.printf(BONUS_NUMBER_INPUT_MESSAGE);
        BonusNumber bonusNumber = new BonusNumber(prizeLotto);
        System.out.printf(WINNING_STATISTICS_MESSAGE);
        CompareNum compareNum = new CompareNum(userLottos, prizeLotto, bonusNumber);
        compareNum.calculateResult();
        int sumProfit = WinningStatisticsPrint(compareNum);
        System.out.printf(YIELD_MESSAGE, (double) sumProfit / (double) money.getMoney() * 100);
    }

    public int WinningStatisticsPrint(CompareNum compareNum){
        int sumProfit = 0;
        for (WinCase winCase : compareNum.getResult().keySet()){
            sumProfit += winCase.getCashPrize() * compareNum.getResult().get(winCase);
            if (winCase.equals(WinCase.FAIL)) continue;
            if (winCase.equals(WinCase.FIVE_WITH_BONUS)){
                System.out.printf(FIVE_BONUS_STATISTICS_MESSAGE,winCase.getEqualCount(),winCase.getCashPrize(),compareNum.getResult().get(winCase));
                continue;
            }
            System.out.printf(EQUAL_STATISTICS_MESSAGE,winCase.getEqualCount(),winCase.getCashPrize(),compareNum.getResult().get(winCase));
        }
        return sumProfit;
    }

    public void UserLottosPrint(UserLottos userLottos){
        for (Lotto lotto : userLottos.getUserLottos()){
            List<Integer> sortNumber = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortNumber);
            System.out.println(sortNumber);
        }
    }
}
