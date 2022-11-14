package lotto.domain;

public class LottoMachine {

    private static final LottoNumberGenerator numberGenerator = new LottoNumberGenerator();

    private LottoMachine() {
    }

    public static Lottos issueLottos(Money money) {
        Lottos lottos = new Lottos();
        long count = money.countPurchasable(Lotto.PRICE);

        for (long number = 0; number < count; number++) {
            lottos.add(issueLotto());
        }
        return lottos;
    }

    private static Lotto issueLotto() {
        return new Lotto(numberGenerator.generate());
    }
}
