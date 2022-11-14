package Service;

import domain.BonusNumber;
import domain.WinningNumber;
import view.RequestUser;
import camp.nextstep.edu.missionutils.Console;

public class WinningService {

    WinningNumber winningNumber;
    BonusNumber bonusNumber;

    public void getWinningNumbers(){
        RequestUser.requestLottoNum();
        String input = Console.readLine();
    }
}
