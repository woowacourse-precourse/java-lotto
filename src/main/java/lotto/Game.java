package lotto;

public class Game {

    public void gameStart() {
        PurchaseMachine newLotto = new PurchaseMachine();
        newLotto.getPayAmount();
        newLotto.countTicket(newLotto.payAmount);


    }

    public void drawLotto() {
        LottoDrawing lottoDrawing = new LottoDrawing();
        lottoDrawing.getWinningNumber();
        lottoDrawing.getBonusNumber();

        Lotto winningLotto = new Lotto(lottoDrawing.winningNumber);
    }







}
