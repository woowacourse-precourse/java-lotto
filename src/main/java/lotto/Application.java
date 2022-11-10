package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Output.askBuy();
            Output.answerBuy();

            Output.printLotto();

            Output.askPrizeNum();
            Output.askBonusNum();

            Output.printLottoStat();
            Output.printLottoRate();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
