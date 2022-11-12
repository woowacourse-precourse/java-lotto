package lotto.controller;

import lotto.input.InputPurchaseAmount;
import lotto.model.PurchaseAmount;
import lotto.model.Ticket;
import lotto.view.TicketView;

public class PurchaseController {
    public static Ticket run() {
        PurchaseAmount purchaseAmount = InputPurchaseAmount.input();
        Ticket ticket = new Ticket(purchaseAmount);
        TicketView.outPut(ticket);
        return ticket;
    }
}
