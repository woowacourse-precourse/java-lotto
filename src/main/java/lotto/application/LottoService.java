package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.LottoConstant;
import lotto.domain.Result;
import lotto.domain.WinNumbers;

public class LottoService {

    private static LottoService instance;

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (instance == null) {
            instance = new LottoService();
        }
        return LottoService.instance;
    }

    public List<Lotto> sellLotto(long amount) {
        validateAmount(amount);

        long sellableLotto = amount / LottoConstant.PRICE.getValue();

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < sellableLotto; i++) {
            List<Integer> numbers = createRandomNumbers();
            Lotto lotto = new Lotto(numbers);

            lottos.add(lotto);
        }
        return lottos;
    }

    private void validateAmount(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1,000 단위로만 입력 가능합니다.");
        }
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_NUMBER.getValue(),
                LottoConstant.MAX_NUMBER.getValue(),
                LottoConstant.NUMBERS_SIZE.getValue())
            .stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
    }

    public List<Result> compareLottos(WinNumbers winNumbers, List<Lotto> lottos) {
        return lottos
            .stream()
            .map(lotto -> compareLotto(winNumbers, lotto))
            .collect(Collectors.toList());
    }

    private Result compareLotto(WinNumbers winNumbers, Lotto lotto) {
        int matchCount = getMatchCount(winNumbers, lotto);
        boolean hasBonusNumber = hasBonusNumber(winNumbers, lotto);

        return Result.create(matchCount, hasBonusNumber);
    }

    private int getMatchCount(WinNumbers winNumbers, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return (int) numbers
            .stream()
            .filter(number -> winNumbers.getNumbers().contains(number))
            .count();
    }

    private boolean hasBonusNumber(WinNumbers winNumbers, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(winNumbers.getBonusNumber());
    }
}
