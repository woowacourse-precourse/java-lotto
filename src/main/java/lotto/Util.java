package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Util {
    static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
