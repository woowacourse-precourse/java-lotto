package lotto.ui;

import lotto.lib.StringToIntDataStructure;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static int scanSingleInteger(){
        String number = readLine();
        return StringToIntDataStructure.convertStringToInteger(number);
    }
    public static List<Integer> scanWinningLotto(){
        String winningLotto = readLine();
        return StringToIntDataStructure.splitStringByComma(winningLotto);
    }
}
