package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void checkLottoNumberRange(List<Integer> numbers){
        for (Integer number : numbers) {
            if(number<1 || number>45){
                throw new IllegalArgumentException("[ERROR] : 로또 번호의 범위를 벗어났습니다.");
            }
        }
    }

    private void checkDuplicatedLottoNumber(List<Integer> numbers){
        Set<Integer> notDuplicatedNumber = getNotDuplicatedNumber(numbers);
        if(numbers.size()==notDuplicatedNumber.size()){
            return;
        }
        throw new IllegalArgumentException("[ERROR] : 로또 번호에 중복 숫자가 없어야 합니다.");
    }

    private static Set<Integer> getNotDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> notDuplicatedNumber = new HashSet<>();
        for (Integer number : numbers) {
            notDuplicatedNumber.add(number);
        }
        return notDuplicatedNumber;
    }


    public List<Integer> getNumbers(){
        return this.numbers;
    }

}
