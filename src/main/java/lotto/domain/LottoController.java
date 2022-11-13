package lotto.domain;

public class LottoController {
    private final LottoGenerator lottoGenerator;
    private final WinningNumbersGenerator winningNumbersGenerator;

    // 컨트롤러 생성자를 통해 당첨 번호까지 주입받는 게 보기 좋은 구조인걸까?
    // WinningNumbersGenerator도 만들어야하나?
    public LottoController(LottoGenerator lottoGenerator,
                           WinningNumbersGenerator winningNumbersGenerator) {
        this.lottoGenerator = lottoGenerator;
        this.winningNumbersGenerator = winningNumbersGenerator;
    }

    public void run() {
        lottoGenerator.generate();
//        Output.printLottoHistory(lottoGenerator);
        winningNumbersGenerator.generate();
//        LottoCompare.compare(lottoGenerator, winningNumbers);
    }
}
