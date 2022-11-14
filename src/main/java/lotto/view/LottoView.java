package lotto.view;

import lotto.Lotto;
import lotto.MyLottoList;
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

    public static void outputLottoList(MyLottoList myLottoList) {
        for(Lotto lotto : myLottoList.getLotto()) {
            AppView.outputLine(String.valueOf(lotto));
        }
    }

    public static List<Integer> inputPrizeLotto() {
        String [] ArrBeforeChange = AppView.inputLine().split(",");
        List<Integer> inputNum = new ArrayList<>();
        for(String element : ArrBeforeChange) {
            inputNum.add(ValidateView.possibleNumber(element));
        }
        return inputNum;
    }
}
