package lotto;

import lotto.model.WinningNumber;

import lotto.controller.UserOutput;
import lotto.controller.UserInput;
import lotto.controller.ManageLotto;

public class Application {
    public static void main(String[] args) {
        try {
            ManageLotto manageLotto = new ManageLotto(UserInput.writeBudget());
            UserOutput.viewLotto(manageLotto);

            WinningNumber answer = new WinningNumber(UserInput.writeWinningNumber());
            answer.setBonusNumber(UserInput.writeBonusNumber(answer.getLottoNumbers()));

            UserOutput.viewLottoResult(manageLotto, answer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
