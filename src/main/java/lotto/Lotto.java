package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    //로또번호 중복 검사
    private void duplicate(List<Integer> numbers){
        HashSet<Integer> check = new HashSet<>(numbers);
        if(check.size() != numbers.size())
            throw new IllegalArgumentException();
    }

    //로또번호 범위 검사
    private void range(List<Integer> numbers){
        for (int num : numbers) {
            if (num < 1 || num > 45)
                throw new IllegalArgumentException();
        }
    }

    //로또 랭크 반환
    public int checkRank(Lotto winLotto) {
        int lastIndex = winLotto.numbers.size()-1;
        int bonus = winLotto.numbers.get(lastIndex);
        HashSet<Integer> win = new HashSet<>(winLotto.numbers.subList(0,lastIndex));

        int match = 0;
        for(int num:this.numbers){
            if(win.contains(num))
                match++;
        }

        boolean bonusMatch = this.numbers.contains(bonus);

        if(match == 6) return 1;
        else if(match == 5 && bonusMatch) return 2;
        else if(match == 5) return 3;
        else if(match == 4) return 4;
        else if(match == 3) return 5;
        return -1;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
