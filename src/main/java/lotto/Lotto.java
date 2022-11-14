package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateNumber(numbers);
        numberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6자리의 번호로만 이루어져야합니다.");
        }
    }

    // TODO: 추가 기능 구현

    public int sameNumberCheck(List<Integer> winningLottoNumber){
        int count = 0;
        for(int i = 0; i < 6; i++){
            if(winningLottoNumber.contains(numbers.get(i))){
                count++;
            }
        }
        return count;
    }

    public void duplicateNumber(List<Integer> numbers){
        long distinctCount = numbers.stream().distinct().count();
        if(distinctCount != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public void numberRange(List<Integer> numbers){
        long rangeCount = numbers.stream().filter(number -> number > 0 && number < 46).count();
        if(rangeCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public boolean bonusBallCheck(int bonus){
        if(bonus > 0 && bonus < 46) {
            return numbers.contains(bonus);
        }
        throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1부터 45 사이의 숫자여야 합니다.");
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
