package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    static final int AVAILABLE_MONEY_UNIT = 1000;

    public static void generate(String payment) {
        validatePayment(Integer.valueOf(payment));
        List<Lotto> lottos = new ArrayList<>();
        for (int lottoNumber = 0; lottoNumber < countNumberOfLotto(Integer.valueOf(payment)); lottoNumber++) {
            lottos.add(new Lotto(pickLottoNumbers()));
        }
    }

    public static void validatePayment(int amount) {
        if (amount % AVAILABLE_MONEY_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static int countNumberOfLotto(int amount) {
        return amount / 1000;
    }

    public static List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void orderNumbers(Lotto lotto) {

    }
}
