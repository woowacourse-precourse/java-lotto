package lotto.veiw;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorCode;
import lotto.domain.Compare;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;

public class InputHandler {

    Compare compare;
    Lotto lotto;

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            compare = new Compare(new Money(stringToInt(readLine())));
        } catch (Exception e) {
            throw e;
        }
    }

    public void inputLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            lotto = new Lotto(stringToList(readLine()));
            compare.setLotto(lotto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            BonusNumber bonusNumber = new BonusNumber(lotto, stringToInt(readLine()));
            compare.setBonusNumber(bonusNumber);
        } catch (Exception e) {
            throw e;
        }
    }

    private List<Integer> stringToList(String readLine) {
        List<String> inputs = List.of(readLine.split(","));
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String input : inputs) {
            try {
                lottoNumbers.add(Integer.valueOf(input));
            } catch (Exception e) {
                throw ErrorCode.NOT_NUMBER.getException();
            }
        }
        return lottoNumbers;
    }

    private int stringToInt(String input) {
        int inputNumber;
        try {
            inputNumber = Integer.valueOf(input);
        } catch (Exception e) {
            throw ErrorCode.NOT_NUMBER.getException();
        }
        return inputNumber;
    }
}
