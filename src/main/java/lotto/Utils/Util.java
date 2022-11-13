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

    public static List<Integer> getList(String s) {
        List<Integer> result = new ArrayList<>();
        List<String> temporary = Arrays.asList(s.split(","));
        for (int i =0; i<temporary.size(); i++){
            result.add(Integer.parseInt(temporary.get(i)));
        }
        return result;
    }

    public static boolean checkRange(List<Integer> input){
        if(Collections.max(input) <= 45 && Collections.min(input) >=1){
            return true;
        }
        return false;
    }

}
