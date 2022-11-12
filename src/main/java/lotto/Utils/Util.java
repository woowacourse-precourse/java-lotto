package lotto.Utils;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Util {

    public static List<Integer> generateRandomNum(int start, int end, int count){
        List<Integer> lotto = pickUniqueNumbersInRange(start, end, count);
        Collections.sort(lotto);
        return lotto;
    }

    public static String getInput(){
        return Console.readLine();
    }

    public static int getInt(String s) {
        return Integer.parseInt(s);
    }

}
