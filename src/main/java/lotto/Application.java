package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import lotto.controller.UserOutput;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.controller.UserInput;
import lotto.controller.LottoCalculator;

import lotto.controller.ManageLotto;

public class Application {
    public static void main(String[] args) {
        ManageLotto manageLotto = new ManageLotto();

        manageLotto.numberOfLotto(UserInput.writeBudget());
        UserOutput.viewLottos(manageLotto);

        WinningNumber answer = new WinningNumber(UserInput.writeWinningNumber());
        answer.setBonusNumber(UserInput.writeBonusNumber(answer.getWinningNumber()));

        UserOutput.viewLottoResult(manageLotto, answer);
    }
}
