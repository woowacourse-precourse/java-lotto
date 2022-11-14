package lotto.domain;

import java.util.List;

public class Result {

    private final String ERROR_CODE = "[ERROR] ";
    private final List<Integer> numbers;

    private int bonus;

    public Result(List<Integer> numbers) {
        //validateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        validateBonus(bonus);
        this.bonus = bonus;
    }

//    private void validateNumbers(List<Integer> numbers) {
//        if(numbers.size() != 6) {
//            throw new IllegalArgumentException(ERROR_CODE + "당첨 번호는 6개만 입력해야 합니다.");
//        }
//        if(numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
//            throw new IllegalArgumentException(ERROR_CODE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
//        }
//        if(numbers.stream().distinct().count() != 6) {
//            throw new IllegalArgumentException(ERROR_CODE + "입력된 당첨 번호 중에 중복되는 번호가 존재 합니다.");
//        }
//    }

    private void validateBonus(int bonus) {
        if(bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(ERROR_CODE + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if(numbers.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_CODE + "보너스 번호가 이미 존재합니다.");
        }
    }
}
