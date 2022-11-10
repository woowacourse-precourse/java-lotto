package lotto.domain;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.AbstractMasterDetailListProcessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

enum Rank {
    ONE("6개 일치 (2,000,000,000원) - "),
    TWO("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THREE("5개 일치 (1,500,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    FIVE("3개 일치 (5,000원) - "),
    LOSE("");
    private String message;

    Rank(String message) {
        this.message = message;
    }
}
public class Lotto {
    private final List<Integer> numbers;
    private static String validateMessage = "[ERROR] 6자리를 초과하였습니다.";
    private static String numberRepeatErrorMessage = "[ERROR] 반복되는 번호가 있습니다.";
    private static String numberRangeErrorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static String pattern = "^[1-45]";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicatedValidate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(validateMessage);
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void duplicatedValidate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        List<Integer> newNumbers = new ArrayList<Integer>(set);
        if(newNumbers.size() < 6){
            System.out.println(numberRepeatErrorMessage);
            throw new IllegalArgumentException();
        }
    }
    private void rangeValidate(List<Integer> numbers){
        for(int item : numbers){
            if(Pattern.matches(pattern, Integer.toString(item))){
                System.out.println(numberRangeErrorMessage);
                throw new IllegalArgumentException();
            }
        }
    }
}
