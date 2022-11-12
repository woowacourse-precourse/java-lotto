package lotto;

import java.util.List;

public class BonusNumberInputController extends InputController {

    public void validate(Object input) {

        validateNumber((String) input);
        validateRange((String) input);
        validateDuplicate((String) input);

    }

    public void validateNumber(String input) {

        try {
            Integer.parseInt(input);

        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해주세요.");
        }
    }

    public void validateRange(String input) {

        int bonusNumber = Integer.parseInt(input);

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해주세요.");
        }
    }

    public void validateDuplicate(String input) {

        int bonusNumber = Integer.parseInt(input);

        List<Integer> winNumber = new LottoMachine().getWinNumber().getLotto();

        if (winNumber.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함되어 있지 않아야 합니다.");
    }
}
