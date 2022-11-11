package lotto.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_UPPER_BOUND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private static final int LOTTO_PRICE = 1000;
    private static final String INVALID_AMOUNT_MESSAGE = "[ERROR] 로또를 구매할 수 없습니다.";

    public LottoTicket sell(Integer amount) {
        validate(amount);
        return generateQuickPickNumbers(amount / LOTTO_PRICE);
    }

    private void validate(Integer amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_MESSAGE);
        }
    }

    private LottoTicket generateQuickPickNumbers(Integer count) {
        List<List<Integer>> quickPickNumbers = new ArrayList<>();
        while (quickPickNumbers.size() < count) {
            quickPickNumbers.add(quickPick());
        }
        return toLottoTicket(quickPickNumbers);
    }

    private List<Integer> quickPick() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND, LOTTO_NUMBERS_SIZE)
                .stream()
                .sorted()
                .collect(toList());
    }

    private LottoTicket toLottoTicket(List<List<Integer>> quickPickNumbers) {
        return quickPickNumbers.stream()
                .map(Lotto::new)
                .collect(collectingAndThen(toList(), LottoTicket::new));
    }
}
