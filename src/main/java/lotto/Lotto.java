package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.PayMoneyException;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static int moneyOfQuantity(int pay) throws PayMoneyException {
        if (pay % PRICE != 0) {
            throw new PayMoneyException("지불한 돈이 0으로 나누어 떨어지지 않습니다.");
        }

        return getQuantity(pay);
    }

    private static int getQuantity(int pay) {
        return pay / PRICE;
    }

    public static List<Lotto> createLottoNumbers(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < quantity; count++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }

        return lottos;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public WinningNumberCount winningLottoNumberCount(WinningLottoNumber winningLottoNumber) {
        int winningCount = getWinningNumberCount(winningLottoNumber);
        boolean isMatchBonusNumber = isMatchBonusNumber(winningLottoNumber);
        return WinningNumberCount.of(winningCount, isMatchBonusNumber);
    }

    private boolean isMatchBonusNumber(WinningLottoNumber winningLottoNumber) {
        return numbers.stream()
                .anyMatch(number -> number == winningLottoNumber.getBonusNumber());
    }

    private int getWinningNumberCount(WinningLottoNumber winningLottoNumber) {
        return (int) numbers.stream()
                .filter(number -> winningLottoNumber.getWinningNumbers().contains(number))
                .count();
    }
}
