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
    private static final int INIT_NUMBER = 0;

    public static void setUserTicketsToLottery(User user, int lottoTicketAmount) {
        for (int i = INIT_NUMBER; i < lottoTicketAmount; i++) {
            Lotto lotto = new Lotto(LOTTO_NUMBER);
            lotto.setNumbers(LottoRepository.generateLotto());
            user.setLottos(lotto.getNumbers());
        }
    }

    public static void buyLotteryTickets(User user) {
        int inputMoney = user.getInputMoney();
        int ticketAmount = inputMoney / UNIT_MONEY;
        user.setTicketAmount(ticketAmount);
        user.setpurchaseAmount(ticketAmount * UNIT_MONEY);
    }

<<<<<<< refs/remotes/origin/chosunghyun18
    public static int inputMoney() {
        String userInputs = Console.readLine();
        if (!checkMoneyOnlyNUmber(userInputs)) {
            return INIT_NUMBER;
        }
        if (!checkMoneyMinAmount(userInputs)) {
            return INIT_NUMBER;
=======
    public static int inputNumbers() {
        String userInputs = Console.readLine();
        if (!checkMoney(userInputs)) {
            return 0;
        }
        if (!checkMoney2(userInputs)) {
            return 0;
>>>>>>> feat(user): add the feature the user input
        }
        return Integer.parseInt(userInputs);
    }

<<<<<<< refs/remotes/origin/chosunghyun18
    private static boolean checkMoneyOnlyNUmber(String userInput) {
=======
    private static boolean checkMoney(String userInput) {
>>>>>>> feat(user): add the feature the user input
        try {
            ValidateUser.validateOnlyNumber(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }
<<<<<<< refs/remotes/origin/chosunghyun18

    private static boolean checkMoneyMinAmount(String userInput) {
=======
    private static boolean checkMoney2(String userInput) {
>>>>>>> feat(user): add the feature the user input
        try {
            ValidateUser.validateMinAmount(Integer.parseInt(userInput));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }

}