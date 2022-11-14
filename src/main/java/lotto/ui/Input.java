package lotto.ui;

import lotto.lib.StringToIntDataStructure;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static int scanPurchaseAmount(){
        String money = readLine();
        return StringToIntDataStructure.convertStringToInteger(money);
    }
    public static List<Integer> scanWinningLotto(){
        String winningLotto = readLine();
        return StringToIntDataStructure.splitStringByComma(winningLotto);
    }
}
