package lotto.view;

import lotto.Lotto;
import lotto.MyLottoList;
import lotto.MyPrize;
import lotto.PrizeLotto;
import org.junit.jupiter.params.ParameterizedTest;

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
        String [] ArrBeforeChange = AppView.inputLine().split(",");
        List<Integer> inputNum = new ArrayList<>();
        for(String element : ArrBeforeChange) {
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
            AppView.outputLine(String.valueOf(lotto));
        }
    }

    public static void outputSynthesisEachRank(MyPrize myPrize) {
        AppView.outputLine("3개 일치 (5,000원) - " + myPrize.getRankArr()[5] + "개");
        AppView.outputLine("4개 일치 (50,000원) - " + myPrize.getRankArr()[4] + "개");
        AppView.outputLine("5개 일치 (1,500,000원) - " + myPrize.getRankArr()[3] + "개");
        AppView.outputLine("5개 일치, 보너스 볼 일치 (30,000,000원) - " + myPrize.getRankArr()[2] + "개");
        AppView.outputLine("6개 일치 (2,000,000,000원) - " + myPrize.getRankArr()[1] + "개");
    }


    public static void outputProfitRate(long Amount, int money) {
        double profit = (Amount / (double)money) * 100;
        AppView.outputLine("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }
}
