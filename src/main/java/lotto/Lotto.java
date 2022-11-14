package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            System.out.println("[Error]당첨번호는 6자리이여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbersSet.size()){
            System.out.println("[Error]중복되지 않은 숫자를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        if(Collections.min(numbers) < 1 || Collections.max(numbers) > 45 ) {
            System.out.println("[Error]1~45 범위의 값을 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> match(List<List<Integer>> lotto) {
        List<Integer> cnt = new ArrayList<>();
        List<Integer> each_lotto = new ArrayList<>();
        List<Integer> same = new ArrayList<>();
        int i = 0;
        int cnt_each = 0;
        while(cnt.size() != lotto.size()) {
            each_lotto = lotto.get(i);
            same= each_lotto.stream()
                            .filter(num -> this.numbers.stream().anyMatch(Predicate.isEqual(num)))
                            .collect(Collectors.toList());
            cnt.add(same.size());
            i++;
        }
        return cnt;
    }

    public List<Boolean> match_bonus(List<List<Integer>> lotto, int bonus_number) {
        List<Boolean> bonus_check = new ArrayList<>();
        List<Integer> each_lotto = new ArrayList<>();
        int i = 0;
        while(bonus_check.size() != lotto.size()) {
            each_lotto = lotto.get(i);
            bonus_check.add(each_lotto.contains(bonus_number));
            i++;
        }
        return bonus_check;
    }

}
