package lotto.domain;

public class LottoController {
    private final LottoGenerator lottoGenerator;
    private final WinningNumbersGenerator winningNumbersGenerator;

    public LottoController(LottoGenerator lottoGenerator,
                           WinningNumbersGenerator winningNumbersGenerator) {
        this.lottoGenerator = lottoGenerator;
        this.winningNumbersGenerator = winningNumbersGenerator;
    }

    public void run() throws IllegalArgumentException {
        LottoCompare comparing = new LottoCompare(lottoGenerator.generate(),
                winningNumbersGenerator.generate());
        comparing.compare();
    }
}
