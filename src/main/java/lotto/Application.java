package lotto;

import static lotto.CompareLotto.compareLotto;
import static lotto.CompareLotto.printCompareLotto;
import static lotto.Lotto.inputMoney;
import static lotto.Lotto.oneLotto;
import static lotto.Lotto.theNumberOfLotto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        inputMoney(); // import 해서 하는것 vs 클래스. 찍고 하는 것

        theNumberOfLotto();
        System.out.println(Lotto.getHowManyLotto() + "개를 구입했습니다. ");

        Lotto.myLottoNumber();

        Lotto.winnerNumber();

        Lotto.winnerNumberBonus();

        compareLotto();

        printCompareLotto();
    }

}
