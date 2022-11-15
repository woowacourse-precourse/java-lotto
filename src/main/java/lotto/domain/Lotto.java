package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.LottoNumberValidation;
import lotto.dto.WinningLottoNumberDto;
import lotto.dto.WinningNumberCountDto;
import lotto.exception.PayMoneyException;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidation lottoNumberValidation = new LottoNumberValidation(numbers);
        this.numbers = numbers;
    }

    public static int moneyOfQuantity(int pay) throws PayMoneyException {
        int lottoPrice = 1000;
        if (pay % lottoPrice != 0) {
            throw new PayMoneyException("지불한 돈이 0으로 나누어 떨어지지 않습니다.");
        }

        return getQuantity(pay, lottoPrice);
    }

    private static int getQuantity(int pay, int price) {
        return pay / price;
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

    public WinningNumberCountDto winningLottoNumberCount(WinningLottoNumberDto winningLottoNumber) {
        int winningCount = getWinningNumberCount(winningLottoNumber);
        boolean isMatchBonusNumber = isMatchBonusNumber(winningLottoNumber);
        return WinningNumberCountDto.of(winningCount, isMatchBonusNumber);
    }

    private int getWinningNumberCount(WinningLottoNumberDto winningLottoNumber) {
        return (int) numbers.stream()
                .filter(number -> winningLottoNumber.getWinningNumbers().contains(number))
                .count();
    }

    private boolean isMatchBonusNumber(WinningLottoNumberDto winningLottoNumber) {
        return numbers.stream()
                .anyMatch(number -> number == winningLottoNumber.getBonusNumber());
    }
}
