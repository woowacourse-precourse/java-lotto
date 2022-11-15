package lotto;

import utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static final List<Lotto> lottos = new ArrayList<>();

    public static List<Lotto> createAutoLottos( int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.from(NumberGenerator.generateSixRandomNumber()));
        }
        return lottos;
    }

    public static WinningNumbers createWinNums(List<Integer> lotteryNumber, int bonusNumber) {
        LottoNumber bonus = LottoNumber.getInstance(bonusNumber);
        return WinningNumbers.of(Lotto.from(NumberGenerator.generateSixRandomNumber()), bonus);
    }
}
