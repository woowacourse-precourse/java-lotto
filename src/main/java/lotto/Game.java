package lotto;

public class Game {

    public void buyLotto() {
        LottoSeller newLotto = new LottoSeller();
        newLotto.getPayAmount();
        newLotto.countTicket(newLotto.payAmount);

        NumberGenerator newNumbers = new NumberGenerator(newLotto.numberOfTickets);
        newNumbers.generateNumbers();
        System.out.println(newNumbers.myLotto);

    }

    public void drawLotto() {
        LottoDrawing lottoDrawing = new LottoDrawing();
        lottoDrawing.getWinningNumber();
        lottoDrawing.getBonusNumber();

        Lotto winningLotto = new Lotto(lottoDrawing.winningNumber);
    }






}
