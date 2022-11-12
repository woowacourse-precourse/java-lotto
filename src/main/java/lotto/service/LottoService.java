package lotto.service;

import lotto.controller.dto.LottoPurchaseDto;
import lotto.controller.dto.PaymentAmountDto;

public class LottoService {

    public LottoPurchaseDto purchaseLotto(PaymentAmountDto dto) {
        int paymentAmount = dto.getPaymentAmount();
        return new LottoPurchaseDto(paymentAmount);
    }
}
