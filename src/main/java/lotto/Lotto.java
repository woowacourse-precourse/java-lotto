package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public Lotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
        else if(!validateRange(numbers) || bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR]  로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean validateRange(List<Integer> numbers){
        for(Integer number : numbers){
            if(number < 1 || number > 45){
                return false;
            }
        }
        return true;
    }

    private LottoRanking caculateRanking(){

    }
}
