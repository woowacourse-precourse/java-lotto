package lotto.controller.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoPurchaseDto {

    private static final int LOTTO_BASIC_AMOUNT = 1000;
    private final int purchaseNumbers;
    private final List<Lotto> lottos;

    public LottoPurchaseDto(int paymentAmount) {
        this.purchaseNumbers = validDivision(paymentAmount);
        this.lottos = new ArrayList<>();
    }

    private int validDivision(int paymentAmount) {
        if (paymentAmount % LOTTO_BASIC_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 지불금액이 1000으로 나누어 떨어지지 않습니다.");
        }
        return paymentAmount/LOTTO_BASIC_AMOUNT;
    }
}
