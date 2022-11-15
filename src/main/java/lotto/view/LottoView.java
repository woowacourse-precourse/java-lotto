package lotto.view;

import lotto.Lotto;
import lotto.MyLottoList;
import lotto.MyPrize;
import lotto.constant.RankInfo;
import lotto.controller.LottoController;

import java.util.ArrayList;
import java.util.List;

public class LottoView {
    public static int inputMoney() {
        int money = ValidateView.possibleNumber(AppView.inputLine());
        if(ValidateView.isPossibleMoney(money)) {
            return money;
        }

        return 0;
    }

    public static List<Integer> inputPrizeLotto() {
        String [] arrBeforeChange = AppView.inputLine().split(",");
        List<Integer> inputNum = new ArrayList<>();
        for(String element : arrBeforeChange) {
            inputNum.add(ValidateView.possibleNumber(element));
        }
        return inputNum;
    }

    public static int inputBonusNum() {
        int bonusNum = ValidateView.possibleNumber(AppView.inputLine());
        if(ValidateView.isPossibleBonusNumber(bonusNum)) {
            return bonusNum;
        }

        return 0;
    }

    public static void outputLottoList(MyLottoList myLottoList) {
        for(Lotto lotto : myLottoList.getLotto()) {
            AppView.outputLine(String.valueOf(lotto.getNumbers()));
        }
    }

    public static void outputSynthesisEachRank(MyPrize myPrize) {
        AppView.outputLine(RankInfo.FIFTH.getStatement() + myPrize.getRankArr()[RankInfo.FIFTH.getRank()] + "개");
        AppView.outputLine(RankInfo.FOURTH.getStatement() + myPrize.getRankArr()[RankInfo.FOURTH.getRank()] + "개");
        AppView.outputLine(RankInfo.THIRD.getStatement() + myPrize.getRankArr()[RankInfo.THIRD.getRank()] + "개");
        AppView.outputLine(RankInfo.SECOND.getStatement() + myPrize.getRankArr()[RankInfo.SECOND.getRank()] + "개");
        AppView.outputLine(RankInfo.FIRST.getStatement() + myPrize.getRankArr()[RankInfo.FIRST.getRank()] + "개");
    }


    public static void outputProfitRate(long Amount, int money) {
        String profit = LottoController.calculateProfitRate(Amount, money);
        AppView.outputLine("총 수익률은 " + profit + "%입니다.");
    }
}
