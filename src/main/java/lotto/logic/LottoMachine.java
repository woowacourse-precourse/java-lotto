package lotto.logic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.aspect.PaymentValidator;
import lotto.domain.Lotto;

public class LottoMachine {

    private static final int PRICE = 1_000;

    private static class LottoMachineHolder {
        private static final LottoMachine INSTANCE = new LottoMachine();
    }

    private LottoMachine() {

    }

    public static LottoMachine getInstance() {
        return LottoMachineHolder.INSTANCE;
    }

    public List<Lotto> generateLottos(long payment) throws IllegalArgumentException {
        PaymentValidator.validatePayment(payment, PRICE);
        List<Lotto> lottos = new ArrayList<>();

        for (long i = payment / PRICE; i > 0; i--) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                                       .stream()
                                       .sorted()
                                       .collect(Collectors.toList());

        return new Lotto(numbers);
    }

}
