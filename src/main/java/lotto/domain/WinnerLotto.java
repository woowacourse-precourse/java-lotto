package lotto.domain;

import lotto.utils.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.toLottoNumber;
import static lotto.domain.LottoRank.matchRank;

public class WinnerLotto {
    private static final String BONUS_DUPLICATE = "보너스번호가 당첨번호와 중복됩니다.";
    private final Lotto winLotto;
    private final LottoNumber bonus;

    public WinnerLotto(String inputNumbers, String bonus) {
        Validator.isNumbers(inputNumbers);
        Validator.isOneNumber(bonus);
        this.winLotto = toLotto(inputNumbers);
        this.bonus = toLottoNumber(Integer.parseInt(bonus));
        isDuplicate();
    }

    public LottoRank matchAll(Lotto lotto) {
        return matchRank(matchNumbers(lotto), matchBonus(lotto));
    }

    private long matchNumbers(Lotto lotto) {
        return winLotto.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    private boolean matchBonus(Lotto lotto) {
        if (lotto.getNumbers().contains(bonus)) {
            return true;
        }
        return false;
    }

    private void isDuplicate() {
        if (winLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE);
        }
    }

    private Lotto toLotto(String inputNumbers) {
        return new Lotto(of(inputNumbers));
    }

    private List<Integer> of(String inputNumbers) {
        List<String> numbers = Arrays.asList(inputNumbers.split(","));
        return numbers.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

