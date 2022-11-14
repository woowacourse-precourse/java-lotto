package lotto;

import lotto.check.BonusCheck;
import lotto.check.MoneyCheck;
import lotto.check.WinningNumberCheck;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.User;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class LottoController {
    private User user;
    private Lotto lotto;
    private Integer bonus;
    private Result result;
    private View view;

    public LottoController() {
        try {
            init();
            read();
            result.compare(user.getMyLottoNumbers(), lotto, bonus);
            result.calc(user);
            view.printResult(result);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        }
    }

    private void init() {
        view = new View();
        result = new Result();
    }

    private void read() {
        view.printStart();
        String moneyInput = readLine();
        user = new User(MoneyCheck.check(moneyInput));
        view.printUserLottos(user);
        view.printLottos();
        String winningNumber = readLine();
        List<Integer> winningNumbers = WinningNumberCheck.check(winningNumber);
        lotto = new Lotto(winningNumbers);
        view.printBonus();
        String bonusNumber = readLine();
        bonus =  BonusCheck.check(bonusNumber,lotto);
    }
}
