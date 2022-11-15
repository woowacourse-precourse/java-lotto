package lotto.view;

import lotto.Lotto;
import lotto.MyLottoList;
import lotto.MyPrize;
import lotto.constant.RankInfo;

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
        AppView.outputLine(RankInfo.FIFTH.getStatement() + myPrize.getRankArr()[5] + "개");
        AppView.outputLine(RankInfo.FOURTH.getStatement() + myPrize.getRankArr()[4] + "개");
        AppView.outputLine(RankInfo.THIRD.getStatement() + myPrize.getRankArr()[3] + "개");
        AppView.outputLine(RankInfo.SECOND.getStatement() + myPrize.getRankArr()[2] + "개");
        AppView.outputLine(RankInfo.FIRST.getStatement() + myPrize.getRankArr()[1] + "개");
    }


    public static void outputProfitRate(long Amount, int money) {
        double profit = (Amount / (double)money) * 100;
        AppView.outputLine("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }
}
