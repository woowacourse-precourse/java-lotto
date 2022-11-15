package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domian.Lotto;
import lotto.exception.UserInputLottoInfoException;
import lotto.view.InputView;
import lotto.view.OutputView;


public class UserInputWinningNumberService {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    UserInputLottoInfoException userInputLottoInfoException = new UserInputLottoInfoException();

    public void checkThisWinningNumberIsValid(String[] winningNumbers) {
        userInputLottoInfoException.validate(winningNumbers, "로또 번호의 개수는 6개 입니다.");
        for (String s : winningNumbers) {
            userInputLottoInfoException.checkInputIsEmpty(s,"로또 당첨 번호 입력 중 null 값이 존재합니다.");
            userInputLottoInfoException.verifyExistBlank(s,"로또 당첨 번호 입력 중 공백이 있습니다.");
            userInputLottoInfoException.isInputValueOnlyNumber(s, "로또 당첨 번호는 숫자만 가능합니다.");
            userInputLottoInfoException.checkLottoNumberRange(s, "1 ~ 45 사이의 숫자만 입력가능합니다.");
        }
        userInputLottoInfoException.isExistSameNumber(winningNumbers, "중복된 숫자가 존재합니다.");
    }
}
