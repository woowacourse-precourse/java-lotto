package lotto.domain;

import java.util.List;

import static lotto.utils.ScoreUtil.findRankByCorrectLottoCount;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public ScoreInfo getScoreInfoByWinnerLottoCountInfo(Lotto winnerLotto, Integer winnerBonusNumber) {
        Integer numberCount = findCorrectNumberCount(winnerLotto);
        Integer bonusCount = findCorrectBonusCount(winnerBonusNumber);
        return findRankByCorrectLottoCount(numberCount, bonusCount);
    }

    public Integer findCorrectNumberCount(Lotto winnerLotto) {
        return winnerLotto.numbers.stream().filter(numbers::contains).toArray().length;
    }

    public Integer findCorrectBonusCount(Integer bonusNumber) {
        return numbers.stream().filter(bonusNumber::equals).toArray().length;
    }

    public boolean containBonusNumber(Integer bonus) {
        return numbers.contains(bonus);
    }
}
