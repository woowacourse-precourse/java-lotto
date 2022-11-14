package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryMachine {
    private static final int AMOUNT_UNIT = 1000;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBER = 6;
    private final List<Lotto> lottos;
    private WinningNumbers winningNumbers;

    public LotteryMachine() {
        lottos = new ArrayList<>();
    }

    public void buyLottos(int amount) {
        validateAmount(amount);
        drawLottos(amount / AMOUNT_UNIT);
    }

    public void putWinningNumbers(List<Integer> numbers, int bonusNumber) {
        winningNumbers = new WinningNumbers(numbers, bonusNumber);
    }

    public WinningStat getWinningStat() {
        WinningStat winningStat = new WinningStat();
        lottos.forEach(x -> winningStat.add(winningNumbers.convertToPrize(x)));
        return winningStat;
    }

    public List<String> getLists() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }

    private void drawLottos(int number) {
        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER)));
        }
    }

    private void validateAmount(int amount) {
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("입력 금액은 "+AMOUNT_UNIT+"단위여야 합니다.");
        }
    }
}
