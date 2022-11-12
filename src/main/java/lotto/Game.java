package lotto;

public class Game {

    public void gameStart() {
        LottoSeller newLotto = new LottoSeller();
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
