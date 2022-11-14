package lotto;

import lotto.domain.WinningType;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    public static final int FIRST_PRIZE = 1;
    public static final int SECOND_PRIZE = 2;
    public static final int THIRD_PRIZE = 3;
    public static final int FOURTH_PRIZE = 4;
    public static final int FIFTH_PRIZE = 5;
    public static final int LOOSE = -1;

    public static final List<Integer> PRIZES = List.of(FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE);
    public static final List<Integer> PRIZE_MONEY = Arrays.stream(WinningType.values())
            .map(WinningType::getMoney)
            .collect(Collectors.toList());
}
