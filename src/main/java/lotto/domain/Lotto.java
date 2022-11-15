package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private Integer bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
        saveBonusNumber();
    }

    private void saveBonusNumber(){
        numbers.add(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호의 길이가 올바르지 않습니다.");
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 길이가 올바르지 않습니다.");
        }

        if (checkOverLap(numbers)){
            System.out.println("[ERROR] 중복되는 당첨 번호가 발생하였습니다.");
            throw new IllegalArgumentException("[ERROR] 중복되는 당첨 번호가 발생하였습니다.");
        }
    }


    private boolean checkOverLap(List<Integer> numbers){
        Set<Integer> numSet = new HashSet<>(numbers);
        return numSet.size() != numbers.size();
    }

    public List<Integer> getLottoNumber(){
        return this.numbers;
    }

}
