package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;
    private static final String REGEX="^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        NotDuplicate(numbers);
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요");
        }
    }

    private void NotDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<Integer>(numbers);
        if(set.size()!=numbers.size()){
            throw new IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력해주세요");
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++){
            if(!Integer.toString(numbers.get(i)).matches(REGEX)){
                throw new IllegalArgumentException("[ERROR] 1~45까지의 숫자를 입력해주세요");
            }
        }
    }
}