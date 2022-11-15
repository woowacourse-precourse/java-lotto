package lotto;

public class Lottery {
    public void start() {
        Buyer buyer = new Buyer();
        buyer.buyLottoTickets();

        WinningNumber winningNumber = Generator.getWinningNumber();

        Drawing drawing = new Drawing(buyer, winningNumber);

        Result result = drawing.getResult();

        result.showHistory();
    }
}
