package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {
    public static List<Lotto> inputAmount() {
        LottoView.inputLottoAmount();
        String amount = Console.readLine();
        int lottoCnt = Validator.validateMoney(amount) / 1000;
        return generateLottoWithCount(lottoCnt);
    }

    public static List<Lotto> generateLottoWithCount(int lottoCnt) {
        LottoView.printLottoCount(lottoCnt);

        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < lottoCnt; cnt++) {
            lottos.add(generateLotto());
        }

        LottoView.printLottoNumbers(lottos);
        return lottos;
    }

    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
