package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoWinType.matchGameScoreAndLottoWinType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        ValidateUtils.checkNumberRange(numbers);
        ValidateUtils.checkInputSize(numbers.size(), 6);
        ValidateUtils.checkDuplicatedRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public static List<Lotto> makeLottoNumbers(int change) {
        List<Lotto> lottoNumberList= new ArrayList<>();
        for (int i = 1; i <= change; i++) {
            Lotto lotto = new Lotto(makeRandomLottoNumbers());
            lottoNumberList.add(lotto);
            printLottoNumbers(lotto);
        }
        return lottoNumberList;
    }

    private static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public LottoWinType checkMatchedLotto(List<Integer> winLotto, int bonusLotto) {
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

    private static List<Integer> makeRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
