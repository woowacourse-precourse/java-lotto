package lotto.domain;

public class LottoController {
    LottoGenerator lottoGenerator;

    public LottoController() {

    }

    public void run() {
        lottoGenerator = new LottoGenerator();
    }
}
