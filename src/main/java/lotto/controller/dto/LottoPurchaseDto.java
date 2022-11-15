package lotto.controller.dto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.exception.ErrorMessage.*;
import static lotto.utils.Constant.LOTTO_BASIC_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.ErrorMessage;
import lotto.exception.MyException;

public class LottoPurchaseDto {
    private final List<Lotto> lottos;

    public LottoPurchaseDto(int paymentAmount) {
        this.lottos = purchaseLottos(validDivision(paymentAmount));
    }

    private List<Lotto> purchaseLottos(int purchaseNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (int lottoTicket = 0; lottoTicket < purchaseNumbers; lottoTicket++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(pickUniqueNumbersInRange(1, 45, 6));
    }

    private int validDivision(int paymentAmount) {
        if (paymentAmount % LOTTO_BASIC_AMOUNT != 0) {
            throw new MyException(NOT_DIVISION_PRICE);
        }
        return paymentAmount / LOTTO_BASIC_AMOUNT;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
