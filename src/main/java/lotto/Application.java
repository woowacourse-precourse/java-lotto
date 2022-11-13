package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Application {

    public List<Integer> Lotto_number(){

    List<Integer> Lotto_numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    Collections.sort(Lotto_numbers);
    return Lotto_numbers;    
    }

    public static void main(String[] args) {


        // TODO: 프로그램 구현
    }
}
