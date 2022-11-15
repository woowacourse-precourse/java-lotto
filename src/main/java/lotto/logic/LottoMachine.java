package lotto.logic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoInfo;
import lotto.validator.PaymentValidator;
import lotto.domain.Lotto;

public class LottoMachine {

    private static class LottoMachineHolder {
        private static final LottoMachine INSTANCE = new LottoMachine();
    }

    private LottoMachine() {

    }

    public static LottoMachine getInstance() {
        return LottoMachineHolder.INSTANCE;
    }

    public List<Lotto> generateLottos(long payment) throws IllegalArgumentException {
        PaymentValidator.validatePayment(payment, LottoInfo.PRICE.value());
        List<Lotto> lottos = new ArrayList<>();

        for (long i = payment / LottoInfo.PRICE.value(); i > 0; i--) {
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
