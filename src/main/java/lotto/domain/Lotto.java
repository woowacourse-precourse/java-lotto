package lotto.domain;

import static lotto.domain.LottoWinType.matchGameScoreAndLottoWinType;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Constant;
import lotto.utils.ValidateUtils;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidateUtils.checkDuplicateNumber(numbers);
        ValidateUtils.checkArraySize(numbers.size(), Constant.LOTTO_SIZE);
        ValidateUtils.checkRangeNumber(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static List<Lotto> makeLottoNumbers(int n) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lottos.add(new Lotto(getRandomLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constant.NUMBER_START, Constant.NUMBER_END, Constant.LOTTO_SIZE);
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public LottoWinType findMatchedLotto(List<Integer> winLotto, int bonusLotto) {
        int answerCount = 0;
        int bonusCount = 0;
        for (Integer number : this.getNumbers()) {
            if (winLotto.contains(number)) {
                answerCount++;
            }
            if (number == bonusLotto) {
                bonusCount++;
            }
        }
        return matchGameScoreAndLottoWinType(answerCount, bonusCount);
    }

}

