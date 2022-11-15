package lotto;

import java.util.List;

import java.util.ArrayList;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRemoveDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateRemoveDuplicateNumbers(List<Integer> numbers) {
        List<Integer> tempNum = new ArrayList<>();
        numbers.forEach(num -> {
            if (tempNum.contains(num))
                throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하였습니다.");
            tempNum.add(num);
        });
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public LottoRanking compare(List<Integer> winnigLotto, int bonusNum) {
        int matches = getMatchingSize(winnigLotto);
        LottoRanking ranking = LottoRanking.NONE;
        ranking = ranking.getPrize(matches);
        if (matches == 5 && !numbers.contains(bonusNum))
            return LottoRanking.THIRD;
        return ranking;
    }

    private int getMatchingSize(List<Integer> winnigLotto) {
        int matches = 0;
        for (int index = 0; index < 6; index++) {
            if (winnigLotto.contains(numbers.get(index)))
                matches++;
        }
        return matches;
    }

    // TODO: 추가 기능 구현
}
