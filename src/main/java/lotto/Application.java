package lotto;

import lotto.application.in.LottoStarter;

public class Application {

    public static void main(String[] args) {
        ContextFactory contextFactory = new ContextFactory();

        LottoStarter lottoStarter = new LottoStarter(
                contextFactory.getPurchaseMoneyInput(),
                contextFactory.getLottoNumberGenerator(),
                contextFactory.getLottoPrinter(),
                contextFactory.getWinningNumberInput(),
                contextFactory.getBonusNumberInput(),
                contextFactory.getLottoMatcher(),
                contextFactory.getWinningStatistic(),
                contextFactory.getWinningStatisticPrinter(),
                contextFactory.getYieldCalculator(),
                contextFactory.getYieldPrinter());

        try {
            lottoStarter.start();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
