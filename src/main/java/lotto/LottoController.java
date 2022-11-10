package lotto;

import lotto.check.BonusCheck;
import lotto.check.MoneyCheck;
import lotto.check.WinningNumberCheck;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.User;

import static camp.nextstep.edu.missionutils.Console.*;

public class LottoController {
    private User user;
    private Lotto lotto;
    private Integer bonus;
    private Result result;
    public LottoController() {
        try {
            read();
            result = new Result(user.getMyLottoNumbers(), lotto, bonus);
            result.calc();
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
        String winningNumber = readLine();
        lotto = new Lotto(winningNumberInputChecker.check(winningNumber));
        String bonusNumber = readLine();
        bonus = bonusCheck.check(bonusNumber,lotto);
    }
}
