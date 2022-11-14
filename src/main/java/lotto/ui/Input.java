package lotto.ui;

import lotto.lib.StringToIntDataStructure;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static int scanMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String number = readLine();
        return StringToIntDataStructure.convertStringToInteger(number);
    }
    public static List<Integer> scanWinningLotto(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningLotto = readLine();
        return StringToIntDataStructure.splitStringByComma(winningLotto);
    }
    public static int scanBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String number = readLine();
        return StringToIntDataStructure.convertStringToInteger(number);
    }
}
