package lotto.domain;

public class LottoController {
    private static LottoGenerator lottoGenerator;
    private static WinningNumbers winningNumbers;

    private LottoController() {

    }

    public static void run() {
        issueLottos();
        extractWinningNumbers();
    }

    private static void issueLottos() {
        lottoGenerator = new LottoGenerator();

    }

    private static void extractWinningNumbers() {
        winningNumbers = new WinningNumbers();
    }
}
