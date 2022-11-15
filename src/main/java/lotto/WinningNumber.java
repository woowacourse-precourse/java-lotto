package lotto;

import OutputView.PrintMsg;
import camp.nextstep.edu.missionutils.Console;

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
        PrintMsg.winningMsg();
        String inputValue = Console.readLine().trim();
        List<Integer> winningLottoNumbers = new ArrayList<>();
        for (String numberValue : inputValue.split(",")) {
            winningLottoNumbers.add(Integer.parseInt(numberValue));
        }
        return new Lotto(winningLottoNumbers);
    }

    private int setBonusNumber() {
        PrintMsg.bonusMsg();
        String bonusNumber = Console.readLine();
        return isValidBonusNumber(Integer.parseInt(bonusNumber), winningLotto);
    }

    private int isValidBonusNumber(int bonusNumber, List<Integer> winningLotto) throws IllegalArgumentException {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 보너스 번호입니다.");
        }
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 보너스 번호입니다.");
        }
        return bonusNumber;
    }
}
