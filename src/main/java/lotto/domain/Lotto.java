package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;

enum Rank {
    ONE(2000000000), TWO(30000000), THREE(1500000), FOUR(50000), FIVE(5000);
    private int money;

    Rank(int money) {
        this.money = money;
    }
}

public class Lotto {
    private final List<Integer> numbers;
    private static String numberRangeErrorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static String numberRepeatErrorMessage = "[ERROR] 반복되는 번호가 있습니다.";
    private static String patten = "^[1-45]";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void duplicatedValidate(List<String> numbers){
        for(String item : numbers){
            if(Pattern.matches(patten, item)){
                System.out.println(numberRepeatErrorMessage);
                throw new IllegalArgumentException();
            }
        }
    }
    private void rangeValidate(List<String> numbers){

    }
    static List<Integer> compare(List<Integer> numbers) {
        return null;
    }
}
