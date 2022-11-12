package lotto.domain;

import static lotto.utils.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.utils.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.utils.LottoConstant.RIGHT_LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;

import java.util.List;

public class LottoGenerator {
    public void generateRandomLotto(LottoBuyer lottoBuyer) {
        int lottoAmount = lottoBuyer.getTotalLottoTickets();

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, RIGHT_LOTTO_SIZE);
            lottoBuyer.addLottoTicket(new Lotto(numbers));
        }
    }
}
