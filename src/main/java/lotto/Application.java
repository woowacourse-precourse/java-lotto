package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        getLottoNumber(numbers);

        Lotto lotto = new Lotto(numbers);

        System.out.println(numbers);
        System.out.println(lotto);

        // TODO: 프로그램 구현
    }

    public static void getLottoNumber(List<Integer> numbers){
        while(numbers.size() < 6){
            int b = Randoms.pickNumberInRange(1,45);
            if(!numbers.contains(b))
                numbers.add(b);
        }
        Collections.sort(numbers);
    }


}
