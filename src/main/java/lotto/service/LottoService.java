package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.service.PrizeMoney.*;
import static lotto.service.WinningHistory.*;

public class LottoService {
    private static final int LOTTERY_PRICE = 1000;
    List<Lotto> lotto = new ArrayList<>();

    private static void addWinningHistory(int bonusNumber, Lotto lottery) {
        if (lottery.getNumbers().isEmpty()) {
            FIFTH_PLACE.addQuantity();
        } else if (lottery.getNumbers().size() == 1) {
            if (lottery.getNumbers().contains(bonusNumber)) {
                SECOND_PLACE.addQuantity();
                return;
            }
            THIRD_PLACE.addQuantity();
        } else if (lottery.getNumbers().size() == 2) {
            FOURTH_PLACE.addQuantity();
        } else if (lottery.getNumbers().size() == 3) {
            FIFTH_PLACE.addQuantity();
        }
    }

    private List<Integer> setLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public void setLotto(int money) {
        while (money != 0) {
            lotto.add(new Lotto(setLottoNumbers()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList())));
            money -= LOTTERY_PRICE;
        }
    }

    public void getWinningHistory(List<Integer> numbers, int bonusNumber) {
        for (Lotto lottery : lotto) {
            lottery.getNumbers().removeAll(numbers);
            if (lottery.getNumbers().size() <= 3) {
                addWinningHistory(bonusNumber, lottery);
            }
        }
    }

    public String getReturn(int money) {
        double totalPrizeMoney = 0L;
        totalPrizeMoney += (long) FIRST_PLACE.getQuantity() * FIRST_PLACE_PRIZE.getPrizeMoney();
        totalPrizeMoney += (long) SECOND_PLACE.getQuantity() * SECOND_PLACE_PRIZE.getPrizeMoney();
        totalPrizeMoney += (long) THIRD_PLACE.getQuantity() * THIRD_PLACE_PRIZE.getPrizeMoney();
        totalPrizeMoney += (long) FOURTH_PLACE.getQuantity() * FOURTH_PLACE_PRIZE.getPrizeMoney();
        totalPrizeMoney += (long) FIFTH_PLACE.getQuantity() * FIFTH_PLACE_PRIZE.getPrizeMoney();
        return String.format("%,.1f", (totalPrizeMoney / money) * 100) + "%";
    }
}
