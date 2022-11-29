package lotto.domain;

import lotto.domain.vo.LottoTicketResult;
import lotto.utils.ConsoleLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;
import static lotto.utils.Constant.ERROR_PREFIX;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;
    private static final boolean MATCH_BONUS = true;
    private static final String ERROR_MESSAGE = ERROR_PREFIX + "보너스 번호에 중복 된 숫자가 포함되어있습니다.";

    public WinningLotto(String numbers, String bonusNumber) {
        List<Integer> refineNumbers = refineNumbers(numbers);
        int bonus = parseInt(bonusNumber);
        validate(refineNumbers, bonus);
        this.numbers = refineNumbers;
        this.bonusNumber = bonus;
    }

    private List<Integer> refineNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted()
                .collect(toList());
    }

    public List<LottoTicketResult> confirmWinning(List<Lotto> lottos) {
        List<LottoTicketResult> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int count = matchesCount(lotto);
            result.add(confirmSecondWinning(lotto, count));
        }
        return result;
    }

    private int matchesCount(Lotto lotto) {
        AtomicInteger count = new AtomicInteger();
        numbers.forEach(number -> {
            if (lotto.getNumbers().contains(number)) {
                count.getAndIncrement();
            }
        });
        return count.get();
    }

    private LottoTicketResult confirmSecondWinning(Lotto lotto, int count) {
        if (count == 5 && lotto.getNumbers().contains(bonusNumber)) {
            return new LottoTicketResult(count, MATCH_BONUS);
        }
        return new LottoTicketResult(count, !MATCH_BONUS);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            ConsoleLog.getInstance().println(ERROR_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
