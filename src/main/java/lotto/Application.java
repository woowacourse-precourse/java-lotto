package lotto;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        lottoManager.inputAmount();
        lottoManager.inputWinningNumbers();
        lottoManager.inputBonusNumber();
        lottoManager.compare();
        lottoManager.calcYield();
        lottoManager.printResult();
    }
}
