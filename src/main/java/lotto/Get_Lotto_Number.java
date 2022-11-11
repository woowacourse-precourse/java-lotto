package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Get_Lotto_Number {
    List<Integer> temp = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();

    public List<Integer> GetLotto(List<Integer> numbers){
        temp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.addAll(temp);
        System.out.println(numbers);
        return numbers;
    }
}
