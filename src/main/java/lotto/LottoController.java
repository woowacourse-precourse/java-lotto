package lotto;

import lotto.domain.*;


public class LottoController {

    private final String perPrizeStringFormat = "%s - %d개";
    private final String returnRateStringFormat = "총 수익률은 %,.1f%%입니다.";
    private final LottoMachine lottoMachine;
    private final Person person;

    public LottoController(LottoMachine lottoMachine, Person person) {
        this.lottoMachine = lottoMachine;
        this.person = person;
    }

    public void runLotto() {
        person.buyLottos(lottoMachine);
        WinningLotto winningLotto = WinningLotto.getInstance();
        person.setLottoResult();
        printAggretagedResult();
    }

    private void printAggretagedResult() {
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
