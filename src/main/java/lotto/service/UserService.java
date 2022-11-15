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

        OutputView.printTotalCount(count);
        OutputView.printLottoNumbers(lottos);

        return new User(amount, lottos);
    }

    private static int getAmount() throws IllegalArgumentException {
        try {
            OutputView.messageAmountInput();
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.");
        }
    }

    private static List<Lotto> getlottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoService.getLottoNumbers());
        }
        return lottos;
    }
}
