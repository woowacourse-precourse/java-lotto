package lotto;

import InputOutput.Print;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Print.errorMessage("당첨번호의 길이가 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    private int getLottoCount(int price){
        validatePrice(price);
        return price/1000;
    }

    private void validatePrice(int price){
        if(price%1000!=0){
            Print.errorMessage("금액이 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
