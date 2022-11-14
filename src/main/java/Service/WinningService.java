package Service;

import domain.BonusNumber;
import domain.WinningNumber;
import view.RequestUser;
import camp.nextstep.edu.missionutils.Console;
import view.SystemMessage;

import java.util.List;

public class WinningService {

    WinningNumber winningNumber;
    BonusNumber bonusNumber;
    SystemMessage systemMessage;

    public void set_winning(){
        getWinningNumbers();
        getBonusNumbers();
    }

    public List<Integer> getWinningNumbers(){
        RequestUser.requestLottoNum();
        String input = Console.readLine();
        List<Integer> winningNumbers = winningNumber.validateWinningNumbers(input);
        systemMessage.winningNumbersMessage(input);

        return winningNumbers;
    }

    public int getBonusNumbers(){
        RequestUser.requestBonusNum();
        String input = Console.readLine();
        int bonus = bonusNumber.getBonusNumber(input);
        systemMessage.bonusNumberMessage(input);

        return bonus;
    }
}
