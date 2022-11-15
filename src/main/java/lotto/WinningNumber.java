package lotto;

import OutputView.Print;
import camp.nextstep.edu.missionutils.Console;
import static Exception.Invalidator.*;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private List<Integer> winningLotto;
    private int bonusNumber;

    public void generator() {
        winningLotto = setWinningLotto().getLottoNumber();
        bonusNumber = setBonusNumber();
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private Lotto setWinningLotto() {
        Print.winningMsg();
        String inputValue = Console.readLine().trim();
        List<Integer> winningLottoNumbers = new ArrayList<>();
        for (String numberValue : inputValue.split(",")) {
            winningLottoNumbers.add(Integer.parseInt(numberValue));
        }
        return new Lotto(winningLottoNumbers);
    }

    private int setBonusNumber() {
        Print.bonusMsg();
        String bonusNumber = Console.readLine();
        return isValidBonusNumber(Integer.parseInt(bonusNumber), winningLotto);
    }
}
