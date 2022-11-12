package lotto;

public class Application {
    public static void main(String[] args) {
        LottoConsole lottoConsole = new LottoConsole();
        LottoGame lottoGame = new LottoGame(lottoConsole.getParchaseAmount());
        lottoConsole.printLottos(lottoGame.getLottos());
        lottoGame.play(lottoConsole.getWinningLottoNumbers(), lottoConsole.getBonusLottoNumber());
        lottoConsole.printResult(lottoGame.getLottoResult());
    }
}
