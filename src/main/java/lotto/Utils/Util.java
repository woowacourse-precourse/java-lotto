package lotto.Utils;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Util {

    public static List<Integer> generateRandomNum(int start, int end, int count){
        return pickUniqueNumbersInRange(start, end, count);
    }

    public static String getInput(){
        return Console.readLine();
    }

    public static int getInt(String s) {
        return Integer.parseInt(s);
    }

}
