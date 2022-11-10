package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {

    public List<List<Integer>> lottoRandomNumber(Integer number){   //사용자 입력값을 받는 것
            List<List<Integer>> numberResult = new ArrayList<>();


        for(int i = 0; i < number; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numberResult.add(numbers);

//            for(int j = 0; j < numbers.size(); j++) {


                System.out.println(numbers);

        }
        return numberResult;
    }
}
