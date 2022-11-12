package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private  List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void pickNumberForLotto(){
        numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    private void validateDuplicatedNumbers(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size()!=numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void printNums() {
        System.out.println(numbers);
    }
}
