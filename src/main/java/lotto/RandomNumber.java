package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {
    public static void randomNumber (int count, List<List<Integer>> numbers){
        for(int i=0 ; i<count ; i++){
            List<Integer> number = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(number);
            System.out.println(number);
            numbers.add(number);
        }
    }
}
