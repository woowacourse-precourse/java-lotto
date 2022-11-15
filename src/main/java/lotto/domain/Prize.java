package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Prize {
    FIRST(2_000_000_000, 6, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 6 && !containBonusNumber),
    SECOND(30_000_000, 5, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && containBonusNumber),
    THIRD(1_500_000, 5, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && !containBonusNumber),
    FOURTH(50_000, 4, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 4 && !containBonusNumber),
    FIFTH(5_000, 4, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 3 && !containBonusNumber),
    EMPTY(0, 0, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 6 && !containBonusNumber);

    private final int money;
    private final int matchLottoNumber;
    private final BiPredicate<Integer, Boolean> isMatch;

    Prize(final int money, final int matchLottoNumber, final BiPredicate<Integer, Boolean> isMatch) {
        this.money = money;
        this.matchLottoNumber = matchLottoNumber;
        this.isMatch = isMatch;
    }

    public static Prize getPrize(final int matchNumber, final boolean containBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatch.test(matchNumber, containBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }

    public static List<Prize> getWinning() {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize != EMPTY)
                .collect(Collectors.toList());
    }
}
