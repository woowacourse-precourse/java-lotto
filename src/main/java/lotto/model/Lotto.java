package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSizeNumbers(numbers);
        checkNullNumbers(numbers);
        checkDuplicateNumber(numbers);
        checkSortedNumbers(numbers);
    }

    private void checkNullNumbers(final List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSizeNumbers(final List<Integer> numbers) {
        if (numbers.size() != LottoEnum.TOTAL_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSortedNumbers(final List<Integer> numbers) {
        int beforeNumber = numbers.get(0);
        for (final Integer number : numbers) {
            if (beforeNumber <= number) {
                beforeNumber = number;
                continue;
            }
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(final List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (numbers.lastIndexOf(number) == i) {
                continue;
            }
            throw new IllegalArgumentException();
        }
    }

    public RANKING matchLottoWithLuckyNumber(Lotto luckyLotto, int luckyNumber) {
        int countBall = createCountBallByMatchNumber(luckyLotto);
        if (numbers.contains(luckyNumber)) {
            if (countBall == RANKING.FIRST.getCountBall()) {
                throw new IllegalArgumentException();
            }
            return getRankingByCountBallIncludeLuckyNumber(countBall);
        }
        return getRankingByCountBall(countBall);
    }

    private int createCountBallByMatchNumber(Lotto luckyLotto) {
        int count = 0;
        for (final Integer number : this.numbers) {
            if (luckyLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private RANKING getRankingByCountBallIncludeLuckyNumber(int countBall) {
        if (countBall == RANKING.SECOND.getCountBall()) {
            return RANKING.SECOND;
        }
        if (countBall == RANKING.FORTH.getCountBall()) {
            return RANKING.THIRD;
        }
        if (countBall == RANKING.FIFTH.getCountBall()) {
            return RANKING.FORTH;
        }
        if (countBall == RANKING.NONE.getCountBall()) {
            return RANKING.FIFTH;
        }
        return RANKING.NONE;
    }

    private RANKING getRankingByCountBall(int countBall) {
        if (countBall == RANKING.FIRST.getCountBall()) {
            return RANKING.FIRST;
        }
        if (countBall == RANKING.THIRD.getCountBall()) {
            return RANKING.THIRD;
        }
        if (countBall == RANKING.FORTH.getCountBall()) {
            return RANKING.FORTH;
        }
        if (countBall == RANKING.FIFTH.getCountBall()) {
            return RANKING.FIFTH;
        }
        return RANKING.NONE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
