package lotto.user.repository;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.lottery.domain.Lotto;
import lotto.lottery.repository.LottoRepository;
import lotto.user.domain.User;
import lotto.user.validate.ValidateUser;

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
        int ticketAmount = inputMoney / UNIT_MONEY;
        user.setTicketAmount(ticketAmount);
        user.setpurchaseAmount(ticketAmount * UNIT_MONEY);
    }

    public static int inputNumbers() {
        String userInputs = Console.readLine();
        if (!checkMoney(userInputs)) {
            return 0;
        }
        if (!checkMoney2(userInputs)) {
            return 0;
        }
        return Integer.parseInt(userInputs);
    }

    private static boolean checkMoney(String userInput) {
        try {
            ValidateUser.validateOnlyNumber(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }
    private static boolean checkMoney2(String userInput) {
        try {
            ValidateUser.validateMinAmount(Integer.parseInt(userInput));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }

}