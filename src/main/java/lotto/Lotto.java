package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {


        size_validate(numbers);
        this.numbers = numbers;

    }

    private void size_validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자 6개이어야 합니다.");
        }
        Set<Integer> numbers_to_set = new HashSet<Integer>(numbers);
        List<Integer> Deduplicated_Numbers =new ArrayList<Integer>(numbers_to_set);
        if(Deduplicated_Numbers.size() !=6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 숫자 6개이어야 합니다.");
        }

    }




    // TODO: 추가 기능 구현
}
