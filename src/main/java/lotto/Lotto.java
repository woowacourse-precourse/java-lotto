package lotto;

import java.util.ArrayList;
import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        List<Integer> tempNum = new ArrayList<>();

        numbers.stream().forEach(num -> {
            if (tempNum.contains(num))
                throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하였습니다.");
            tempNum.add(num);
        });
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public LottoPrize compare(List<Integer> winnigLotto, int bonusNum) {

        int matches = getMatchingSize(winnigLotto);
        LottoPrize prize = LottoPrize.NONE;
        prize = prize.getPrize(matches);
        if (matches == 5 && !numbers.contains(bonusNum))
            return LottoPrize.THIRD;
        return prize;
    }

    private int getMatchingSize(List<Integer> winnigLotto) {
        int matches = 0;
        for (int index = 0; index < 6; index++) {
            if (winnigLotto.contains(numbers.get(index)))
                matches++;
        }
        return matches;
    }

}
