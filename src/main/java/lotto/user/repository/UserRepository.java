package lotto.user.repository;

import java.util.List;
import lotto.lottery.domain.Lotto;
import lotto.lottery.repository.LottoRepository;
import lotto.user.domain.User;

public class UserRepository {
    private static final List<Integer> LOTTO_NUMBER = List.of(1, 2, 3, 4, 5, 6);
    private static final int UNIT_MONEY = 1000; // 단위 100원

    public static void createUserLottos(User user, int lottoTicketAmpunt) {
        for (int i = 0; i < lottoTicketAmpunt; i++) {
            Lotto lotto = new Lotto(LOTTO_NUMBER);
            lotto.setNumbers(LottoRepository.generateLotto());
            user.setLottos(lotto.getNumbers());
        }
    }

    public static void buylottos(User user) {
        int inputMoney = user.getInputMoney();
        int ticketAmount = inputMoney/UNIT_MONEY ;
        user.setTicketAmount(ticketAmount);
        user.setpurchaseAmount(ticketAmount*UNIT_MONEY);
    }

}