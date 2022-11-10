package lotto;

import lotto.check.BonusCheck;
import lotto.check.MoneyCheck;
import lotto.check.WinningNumberCheck;
import lotto.domain.Lotto;
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
        view = new View();
        try {
            read();
            result = new Result();
            result.getCount(user.getMyLottoNumbers(), lotto, bonus);
            result.calc(user);
            view.printResult(result);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] "+e.getMessage());
        }
    }

    private void read(){
        MoneyCheck moneyInputChecker = new MoneyCheck();
        WinningNumberCheck winningNumberInputChecker = new WinningNumberCheck();
        BonusCheck bonusCheck = new BonusCheck();
        String moneyInput = readLine();
        user = new User(moneyInputChecker.check(moneyInput));
        view.printUserLottos(user);
        List<String> numbers = view.printLottos();
        lotto = new Lotto(winningNumberInputChecker.check(numbers.get(0)));
        bonus = bonusCheck.check(numbers.get(1),lotto);
    }
}
