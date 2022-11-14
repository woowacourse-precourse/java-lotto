package lotto;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            LottoMachine lottoMachine = new LottoMachine();
            LottoContainer lottoContainer = lottoMachine.buy();
            lottoContainer.printLottos();

            lottoMachine.setWinningNumbers();
            Map<LottoResult, Integer> match = lottoContainer.matchAll(lottoMachine.getNormalNumbers(), lottoMachine.getBonusNumber());
            lottoContainer.printResult(match);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
