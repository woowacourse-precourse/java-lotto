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

    public Lotto setWinningNumbersInfo() {
        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumbers();
        return setLotto(winningNumbers, bonusNumber);
    }
    public List<Integer> setWinningNumbers() {
        outputView.printWinningNumberQuestion();
        String[] winningNumbers = inputView.inputWinningNumber();
        checkThisWinningNumberIsValid(winningNumbers);
        List<Integer> winningNumberList = new ArrayList<>();
        for (String number : winningNumbers) {
            winningNumberList.add(Integer.parseInt(number));
        }
        return winningNumberList;
    }
    public int setBonusNumbers() {
        outputView.printBonusNumberQuestion();
        String bonusNumber = inputView.inputBonusNumber();
        checkThisBonusNumberIsValid(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
    public void checkThisWinningNumberIsValid(String[] winningNumbers) {
        userInputLottoInfoException.checkArrayLength(winningNumbers, "로또 번호의 개수는 6개 입니다.");
        for (String s : winningNumbers) {
            userInputLottoInfoException.checkInputIsEmpty(s,"로또 당첨 번호 입력 중 null 값이 존재합니다.");
            userInputLottoInfoException.verifyExistBlank(s,"로또 당첨 번호 입력 중 공백이 있습니다.");
            userInputLottoInfoException.isInputValueOnlyNumber(s, "로또 당첨 번호는 숫자만 가능합니다.");
            userInputLottoInfoException.checkLottoNumberRange(s, "1 ~ 45 사이의 숫자만 입력가능합니다.");
        }
        userInputLottoInfoException.isExistSameNumber(winningNumbers, "중복된 숫자가 존재합니다.");
    }
    public void checkThisBonusNumberIsValid(String bonusNumber) {
        userInputLottoInfoException.checkInputIsEmpty(bonusNumber, "입력이 null 입니다. 보너스 번호를 입력해주세요");
        userInputLottoInfoException.verifyExistBlank(bonusNumber, "보너스 번호 입력 중 곰백이 있습니다.");
        userInputLottoInfoException.isInputValueOnlyNumber(bonusNumber, "보너스 번호는 한 개이며, 숫자만 가능합니다.");
        userInputLottoInfoException.checkLottoNumberRange(bonusNumber, "1 ~ 45 사이의 숫자만 입력가능합니다.");
    }

    public Lotto setLotto(List<Integer> winningNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);
        lotto.setBonusNumber(bonusNumber);
        return lotto;
    }
}
