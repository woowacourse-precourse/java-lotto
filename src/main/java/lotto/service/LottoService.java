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

    /**
     * 해당 로또의 당첨 내역을 얻어 더한다.
     *
     * @param bonusNumber 보너스 번호
     * @param lottery     로또 1개
     */
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

    /**
     * 1부터 45의 랜덤 6개의 번호를 가져온다.
     *
     * @return 1부터 45의 랜덤 6개의 숫자들
     */
    private List<Integer> setLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLottoNumbers() {
        return lotto;
    }

    /**
     * 로또의 수량만큼 로또를 설정한다.
     *
     * @param quantity 로또의 수량
     */
    public void setLotto(int quantity) {
        while (quantity != 0) {
            lotto.add(new Lotto(setLottoNumbers()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList())));
            quantity--;
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

    /**
     * 수익률을 가져온다.
     *
     * @param lottoQuantity 로또 수량
     * @return 수익률
     */
    public String getReturn(int lottoQuantity) {
        double totalPrizeMoney = 0L;
        totalPrizeMoney += (long) FIRST_PLACE.getQuantity() * FIRST_PLACE_PRIZE.getPrizeMoney();
        totalPrizeMoney += (long) SECOND_PLACE.getQuantity() * SECOND_PLACE_PRIZE.getPrizeMoney();
        totalPrizeMoney += (long) THIRD_PLACE.getQuantity() * THIRD_PLACE_PRIZE.getPrizeMoney();
        totalPrizeMoney += (long) FOURTH_PLACE.getQuantity() * FOURTH_PLACE_PRIZE.getPrizeMoney();
        totalPrizeMoney += (long) FIFTH_PLACE.getQuantity() * FIFTH_PLACE_PRIZE.getPrizeMoney();
        return String.format("%,.1f", (totalPrizeMoney / (lottoQuantity * LOTTERY_PRICE)) * 100) + "%";
    }
}
