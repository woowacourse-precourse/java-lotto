package lotto.view;

import lotto.model.Lottos;
import lotto.model.enums.GameMessage;

public class OutputView {
    public static void showTicketAmount(int ticketAmount) {
        System.out.println(ticketAmount+GameMessage.PURCHASE_MESSAGE.getMessage());
    }

    public void showDrawNumber(Lottos lottos) {
        lottos.getLottos();
    }
}
