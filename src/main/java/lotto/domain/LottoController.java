package lotto.domain;

public class LottoController {
    private static LottoGenerator lottoGenerator;
    private static WinningNumbers winningNumbers;

    private LottoController(LottoGenerator generator, WinningNumbers numbers) {
        lottoGenerator = new LottoGenerator();
        winningNumbers = new WinningNumbers();
    }

    public static void run() {
//        issueLottos();
//        extractWinningNumbers();
        LottoCompare.compare(lottoGenerator.getLottoContainer(), winningNumbers);
    }

    private static void issueLottos() {

    }

    private static void extractWinningNumbers() {
    }
}
