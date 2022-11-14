package lotto.data;

import static lotto.util.Error.ERROR_DUPLICATED_NUMBERS;
import static lotto.util.Error.ERROR_OUT_OF_MAX_IDX;
import static lotto.util.Error.ERROR_OUT_OF_RANGE_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.util.Rank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        validate(numbers);
        duplicate(numbers);
        range(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }
    public Lotto(List<Integer> numbers, int bonus) {
        numbers = new ArrayList<>(numbers);
        validate(numbers);
        numbers.add(bonus);
        duplicate(numbers);
        range(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            ERROR_OUT_OF_MAX_IDX.generate();
    }

    // TODO: 추가 기능 구현
    //로또번호 중복 검사
    private void duplicate(List<Integer> numbers){
        HashSet<Integer> check = new HashSet<>(numbers);
        if(check.size() != numbers.size())
            ERROR_DUPLICATED_NUMBERS.generate();
    }

    //로또번호 범위 검사
    private void range(List<Integer> numbers){
        for (int num : numbers) {
            if (num < 1 || num > 45)
                ERROR_OUT_OF_RANGE_NUMBER.generate();
        }
    }

    private void range(int number){
        if (number < 1 || number > 45)
            ERROR_OUT_OF_RANGE_NUMBER.generate();
    }

    //로또 랭크 반환
    public Rank checkRankOf(Lotto userLotto) {
        int lastIndex = this.numbers.size()-1;
        int bonus = this.numbers.get(lastIndex);
        HashSet<Integer> win = new HashSet<>(this.numbers.subList(0, lastIndex));

        int match = 0;
        for(int num:userLotto.numbers){
            if(win.contains(num))
                match++;
        }

        boolean bonusMatch = userLotto.numbers.contains(bonus);

        return Rank.getPrize(match, bonusMatch);
    }

    public void addBonus(int number){
        range(number);
        validate(this.numbers);
        numbers.add(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
