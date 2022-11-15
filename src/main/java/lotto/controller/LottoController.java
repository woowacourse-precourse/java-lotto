package lotto.controller;

import lotto.model.LottoAmount;
import lotto.model.LottoTicket;
import lotto.model.LottoTickets;
import lotto.view.Input;

import java.util.HashSet;
import java.util.Set;

public class LottoController {
    public void start() {
        int purchaseAmount = Input.inputPurchaseAmount();
        LottoAmount Amount = new LottoAmount(purchaseAmount);
        int quantity = Amount.quantityOfLotto(purchaseAmount);
        LottoTickets tickets = new LottoTickets(collectUniqueLottoTickets(quantity));
    }

    private Set<LottoTicket> collectUniqueLottoTickets(int numberOfTickets) {
        Set<LottoTicket> existentTicket = new HashSet<>();
        int numberOfGeneratedTickets = 0;
        while (numberOfGeneratedTickets < numberOfTickets) {
            LottoTicket generatedTicket = new LottoTicket();
            if (existentTicket.contains(generatedTicket))
                continue;
            existentTicket.add(generatedTicket);
            numberOfGeneratedTickets++;
        }
        return existentTicket;
    }
}
