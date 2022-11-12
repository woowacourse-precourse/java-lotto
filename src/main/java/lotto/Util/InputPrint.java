package lotto.Util;

import camp.nextstep.edu.missionutils.Console;
import lotto.type.TextType;

public class InputPrint {
    public static String startInput(){
        System.out.println(TextType.START);
        return Console.readLine();
    }

    public static String prizeNumberInput(){
        System.out.println(TextType.LOTTO_PRIZE_NUMBER);
        return Console.readLine();
    }
}
