package lotto.user.repository;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.lottery.domain.Lotto;
import lotto.lottery.repository.LottoRepository;
import lotto.user.domain.User;
import lotto.user.validate.ValidateUser;
import lotto.util.Constant;
import lotto.view.ValidateError;

public class UserRepository {
    private static final List<Integer> LOTTO_NUMBER = List.of(1, 2, 3, 4, 5, 6);

    public static void setUserTicketsToLottery(User user, int lottoTicketAmount) {
        for (int i = Constant.INIT_ZERO; i < lottoTicketAmount; i++) {
            Lotto lotto = new Lotto(LOTTO_NUMBER);
            lotto.setNumbers(LottoRepository.generateLotto());
            user.setLottos(lotto.getNumbers());
        }
    }

    public static void buyLotteryTickets(User user) {
        int inputMoney = user.getInputMoney();
        int ticketAmount = inputMoney / Constant.UNIT_MONEY;
        user.setTicketAmount(ticketAmount);
        user.setpurchaseAmount(ticketAmount * Constant.UNIT_MONEY);
    }

    public static int inputMoney() {
        String userInputs = Console.readLine();
        if (!checkMoneyOnlyNUmber(userInputs)) {
            return Constant.INIT_ZERO;
        }
        if (!canMoneyDivideByUnit(userInputs)) {
            return Constant.INIT_ZERO;
        }
        return Integer.parseInt(userInputs);
    }

    private static boolean checkMoneyOnlyNUmber(String userInput) {
        try {
            ValidateUser.validateOnlyNumber(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            ValidateError.printError(e);
            return false;
        }
    }

    private static boolean canMoneyDivideByUnit(String userInput) {
        try {
            ValidateUser.validateDivideByUnit(Integer.parseInt(userInput));
            return true;
        } catch (IllegalArgumentException e) {
            ValidateError.printError(e);
            return false;
        }
    }

}