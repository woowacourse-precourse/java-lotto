package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.RandomNumbersGenerator;

public class LottoBooth {
    public static LottoTicket issueLottoTicket(int lottoCount) {
        isPositiveInteger(lottoCount);
        List<Lotto> lottoTicket = new ArrayList<>();

        for (int issued = 0; issued < lottoCount; issued++) {
            lottoTicket.add(new Lotto(issueLotto()));
        }
        return new LottoTicket(lottoTicket);
    }

    private static List<Integer> issueLotto() {
        List<Integer> lotto = RandomNumbersGenerator.randomNumbers();
        return lotto;
    }

    private static void isPositiveInteger(int lottoCount) {
        if (lottoCount <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1개 이상 발급 가능합니다.");
        }
    }


}
