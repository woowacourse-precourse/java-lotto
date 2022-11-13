package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(String numbers, String bonusNumber) {
        List<Integer> refineNumbers = refineNumbers(numbers);
        int bonus = Integer.parseInt(bonusNumber);
        validate(refineNumbers, bonus);
        this.numbers = refineNumbers;
        this.bonusNumber = bonus;
    }

    private List<Integer> refineNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }

    public ArrayList<LottoTicketResult> confirmWinning(List<Lotto> lottos) {
        ArrayList<LottoTicketResult> result = new ArrayList<>();
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
            return new LottoTicketResult(count, true);
        }
        return new LottoTicketResult(count, false);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호에 중복 된 숫자가 포함되어있습니다.");
        }
    }
}
