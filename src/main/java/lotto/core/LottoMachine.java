package lotto.core;

public class LottoMachine {

    private final LottoMachineBuilder lottoMachineBuilder;

    public LottoMachine(LottoMachineBuilder lottoMachineBuilder) {
        this.lottoMachineBuilder = lottoMachineBuilder;
    }

    public void start() {
        try {
            LottoFactory factory = new LottoFactory();

            lottoMachineBuilder.init(factory)
                    .purchaseLotteries()
                    .setWinningLotto()
                    .showResult();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
