package lotto.veiw;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorCode;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;

public class InputHandler {

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            new Money(readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Lotto inputLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            Lotto lotto = new Lotto(inputStrToNumbers(readLine()));
            return lotto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<Integer> inputStrToNumbers(String readLine) {
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

    public BonusNumber inputBonus(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            BonusNumber bonusNumber = new BonusNumber(lotto, readLine());
            return bonusNumber;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
