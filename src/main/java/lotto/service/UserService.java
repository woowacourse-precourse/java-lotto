package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.CheckException;
import lotto.view.OutputView;

public class UserService {
    public static int getAmount() throws IllegalArgumentException {
        OutputView.printAmountInput();
        return Integer.parseInt(Console.readLine());
    }

    public static List<Lotto> getlottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoService.getLottoNumbers());
        }
        return lottos;
    }
}
