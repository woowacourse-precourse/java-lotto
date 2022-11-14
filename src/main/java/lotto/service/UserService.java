package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.view.OutputView;

public class UserService {
    public static User getUser() {
        int amount = getAmount();
        int count = amount / 1000;
        List<Lotto> lottos = getlottos(count);

        OutputView.printTotalAmount(amount);
        OutputView.printLottoNumbers(lottos);

        return new User(amount, lottos);
    }

    private static int getAmount() throws IllegalArgumentException {
        OutputView.printAmountInput();
        return Integer.parseInt(Console.readLine());
    }

    private static List<Lotto> getlottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoService.getLottoNumbers());
        }
        return lottos;
    }
}
