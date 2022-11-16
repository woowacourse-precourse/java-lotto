package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.StringUtil.parseToIntegerList;

public class Lotto {
    private final List <Integer> numbers;

    public Lotto(List <Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List <Integer> numbers) {
        checkNumberRange(numbers);
        checkLength(numbers);
        checkDuplication(numbers);
    }


    // TODO: 추가 기능 구현
    private void checkNumberRange(List<Integer> numbers){
        for(int number : numbers){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("숫자는 1~45 내로 입력해 주세요.");
            }
        }
    }

    private void checkLength(List <Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 복권은 6개의 숫자로 구성되어야 합니다.");
        }
    }

    private void checkDuplication(List <Integer> numbers) {
        Set <Integer> checkDup = new HashSet <>(numbers);

        if (checkDup.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 복권 내 중복된 숫자가 존재합니다.");
        }
    }

    public List <Integer> getNumbers() {
        return this.numbers;
    }

    public int sameNumberCount(WinningNumber winningNumber) {
        return (int) this.numbers.stream().filter(number
                -> winningNumber.getWinningNumbers().getNumbers().contains(number)).count();
    }

    public boolean containBonusNumber(WinningNumber winningNumber) {
        return this.numbers.contains(winningNumber.getBonusNumber());
    }
}
