package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import utills.Invalidator;
import winning.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static WinningNumber inputWinningNumber() {
        Lotto winningLotto = Input.inputWinningLotto();
        int bonusNumber = Input.inputBonus(winningLotto);
        return new WinningNumber(winningLotto, bonusNumber);
    }

    private static Lotto inputWinningLotto() {
        Output.winningMsg();
        String inputValue = Console.readLine().trim();
        List<Integer> winningLottoNumbers = new ArrayList<>();
        for (String numberValue : inputValue.split(",")) {
            winningLottoNumbers.add(Integer.parseInt(numberValue));
        }
        return new Lotto(winningLottoNumbers);
    }

    private static int inputBonus(Lotto winningLotto) {
        Output.bonusMsg();
        String bonusNumber = Console.readLine();
        return Invalidator.isValidBonusNumber(Integer.parseInt(bonusNumber), winningLotto.getLottoNumber());
    }
}
