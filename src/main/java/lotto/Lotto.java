package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    // 매개 변수 없는 생성자 추가 불가
    // 인스턴스 변수 추가 불가
    // 패키지 변경은 가능
    private final List<Integer> numbers; //private 변경 불가
    private int bonusNumber;

    private int cash;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicated(numbers);
        checkRangeOfNumbers(numbers);
        isDuplicated(numbers);
        this.numbers = numbers;

    }
    public Lotto(List<Integer> numbers, int bonusNumber){
        isBonusNumberDuplicated(numbers,bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력값은 총 6개가 되어야 합니다.");
        }
    }


    private void checkRangeOfNumbers(List<Integer> numbers){
        if(Collections.max(numbers)>45 || Collections.min(numbers)<1){
            throw new IllegalArgumentException("[ERROR] 입력값의 범위는 1부터 45입니다.");
        }
    }

    private void isDuplicated(List<Integer> numbers) {
        List<Integer> newNumbers = new ArrayList<>();
        for(int numberIndex=0; numberIndex<5; numberIndex++){
            newNumbers.add(numbers.get(numberIndex));
            if(newNumbers.contains(numbers.get(numberIndex+1))){
                throw new IllegalArgumentException("[ERROR] 중복되는 수가 있습니다.");
            }
        }
    }

    private void isBonusNumberDuplicated(List<Integer> numbers, int bonusNumber){
        for(int numberIndex=0; numberIndex<6; numberIndex++){
            if(numbers.contains(bonusNumber)){
                throw new IllegalArgumentException("[ERROR] 보너스 번호가 중복됩니다.");
            }
        }
    }

    private void isNumber(List<Integer> numbers){

    }
}
