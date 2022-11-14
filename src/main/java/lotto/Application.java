package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoConsole lottoConsole = new LottoConsole();
            LottoGame lottoGame = new LottoGame(lottoConsole.getPurchaseAmount());
            lottoConsole.printBlank();
            lottoConsole.printLottos(lottoGame.getLottos());
            lottoConsole.printBlank();
            lottoGame.play(lottoConsole.getWinningLottoNumbers(), lottoConsole.getBonusLottoNumber());
            lottoConsole.printBlank();
            lottoConsole.printResult(lottoGame.getResult());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
