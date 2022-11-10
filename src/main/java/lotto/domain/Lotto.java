package lotto.domain;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.AbstractMasterDetailListProcessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

enum Rank {
    ONE(6,0,2000000000,"2,000,000,000원"),
    TWO(5,1,30000000,"30,000,000원"),
    THREE(5,0,1500000,"1,500,000원"),
    FOUR(4,0,50000,"50,000원"),
    FIVE(3,0,5000,"5,000원"),
    LOSE(0,0,0,"0원");
    private int compare;
    private int bonus;
    private int money;
    private String moneyWon;

    Rank(int compare, int bonus, int money, String moneyWon) {
        this.compare = compare;
        this.bonus = bonus;
        this.money = money;
        this.moneyWon = moneyWon;
    }

    public int getCompare() {
        return this.compare;
    }

    public int getBonus() {
        return bonus;
    }

    public int getMoney() {
        return money;
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
