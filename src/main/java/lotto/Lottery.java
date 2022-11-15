package lotto;

import java.util.*;

public class Lottery {
    public void start() {
        Buyer buyer = new Buyer();
        buyer.buyLotteyTickets();

        WinningNumber winningNumber = Generator.getWinningNumber();

        Drawing drawing = new Drawing(buyer, winningNumber);
        drawing.getResult();
    }


}
