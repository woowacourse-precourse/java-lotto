package lotto.service;

import static lotto.utils.Constant.ZERO;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.utils.RandomNumbersGenerator;

public class LottoIssueService {
    public static LottoTicket createLottoTicket(int lottoCount) {
        isPositiveInteger(lottoCount);
        List<Lotto> lottoTicket = new ArrayList<>();
        for (int issued = ZERO; issued < lottoCount; issued++) {
            lottoTicket.add(new Lotto(issueLotto()));
        }
        return new LottoTicket(lottoTicket);
    }

    private static List<Integer> issueLotto() {
        return RandomNumbersGenerator.randomNumbers();
    }

    private static void isPositiveInteger(int lottoCount) {
        if (lottoCount <= ZERO) {
            throw new IllegalArgumentException("[ERROR] 로또는 1개 이상 발급 가능합니다.");
        }
    }
}
