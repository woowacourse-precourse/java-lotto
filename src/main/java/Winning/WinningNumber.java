package Winning;

import OutputView.Output;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static Exception.Invalidator.isValidBonusNumber;

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
        Output.winningMsg();
        String inputValue = Console.readLine().trim();
        List<Integer> winningLottoNumbers = new ArrayList<>();
        for (String numberValue : inputValue.split(",")) {
            winningLottoNumbers.add(Integer.parseInt(numberValue));
        }
        return new Lotto(winningLottoNumbers);
    }

    private int setBonusNumber() {
        Output.bonusMsg();
        String bonusNumber = Console.readLine();
        return isValidBonusNumber(Integer.parseInt(bonusNumber), winningLotto);
    }
}
