package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.view.Input;

public class LottoController {

    public void start() {
        // 금액 입력 받음
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        // 로또 n장 생성 (1장 당 6자리 숫자 랜덤 생성) -> Lotto.java
        LottoTicket lottoTicket = getTickets(purchaseAmount);
        // 당첨 번호 입력 받음

        // 결과 생성

        // 결과 출력
    }

    private PurchaseAmount inputPurchaseAmount() {
        return new PurchaseAmount(Input.getInputPurchaseAmount());
    }

    private int calculateTicketNumber(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getPurchaseAmount() / purchaseAmount.getUNIT_PRICE();
    }

    private LottoTicket getTickets(PurchaseAmount purchaseAmount) {
        int ticketNumber = calculateTicketNumber(purchaseAmount);

        LottoTicket lottoTicket = new LottoTicket(ticketNumber);

        return lottoTicket;
    }
}
