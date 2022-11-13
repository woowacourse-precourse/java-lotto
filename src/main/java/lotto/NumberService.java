package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberService {

    public static List<Integer> GenerateNumbers(){
        List<Integer> result = new ArrayList<>();
        while (result.size() < 7){
            int number = Randoms.pickNumberInRange(1, 45);

            if (!result.contains(number)){
                result.add(number);
            }
        }
        return result;
    }
}
