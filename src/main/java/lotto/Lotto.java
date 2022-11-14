package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers, int bonusNumber) {
        List<Integer> totalNumbers = new ArrayList<>(numbers);
        totalNumbers.add(bonusNumber);
        validate(totalNumbers);
        this.numbers = totalNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자와 한 개의 보너스 숫자를 입력해주세요.");
        }
        else if(!validateRange(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        else if(!validateDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private boolean validateDuplication(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }

    private boolean validateRange(List<Integer> numbers){
        for(Integer number : numbers){
            if(number < 1 || number > 45){
                return false;
            }
        }
        return true;
    }

    public LottoRanking caculateRanking(List<Integer> userNumbers){
        return LottoRanking.caculateRanking(this.numbers.subList(0,6), this.numbers.get(6), userNumbers);
    }
}
