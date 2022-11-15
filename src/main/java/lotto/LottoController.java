package lotto;

import lotto.domain.*;


public class LottoController {

    private static final String perPrizeStringFormat = "%s - %d개";
    private static final String returnRateStringFormat = "총 수익률은 %,.1f%%입니다.";
    private static LottoMachine lottoMachine;
    private static Person person;

    public LottoController(LottoMachine lottoMachine, Person person) {
        this.lottoMachine = lottoMachine;
        this.person = person;
    }

    public void runLotto() {
        person.buyLottos(lottoMachine);
        WinningLotto winningLotto = WinningLotto.getInstance();
        person.setLottoResult();
        printAggregatedResult();
    }

    private void printAggregatedResult() {
        System.out.println("\n당첨 통계\n---");

        for (LottoPrize result : LottoPrize.getValues()) {
            if (result != LottoPrize.NO_PRIZE) {
                System.out.println(String
                        .format(perPrizeStringFormat,
                                result.getPrizeInfo(),
                                person.getLottoResult().get(result))
                );
            }
        }
        System.out.println(String
                .format(returnRateStringFormat, person.getReturnRate()));
    }

}
