package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningType;
import lotto.util.RandomNumberGenerator;

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

    public int calBuyingCount(int money) {
        return money / 1000;
    }

    public Lottos getLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < number; count++) {
            lottos.add(getNewLotto());
        }
        return new Lottos(lottos);
    }

    public Lotto getNewLotto() {
        List<Integer> lottoNumbers = RandomNumberGenerator.makeRandomNumbers();
        return new Lotto(lottoNumbers);
    }
}
