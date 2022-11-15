package lotto.compareLottoNumber;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validate;

public class GetResultNumber {
    private final Validate validate = new Validate();

    public void validationPrizeNumber(int[] number, String[] prizeNumberFromUser, int numberValidationLoop) {
        if (prizeNumberFromUser.length != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자입니다.");
        }
        if (validate.wrongNumber(Integer.parseInt(prizeNumberFromUser[numberValidationLoop]))) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (validate.duplicateNumber(
                Integer.parseInt(prizeNumberFromUser[numberValidationLoop]), number)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public void getPrizeNumberFromUser(int[] prizeNumber) {
        try {
            String[] prizeNumberFromUser = Console.readLine().split(",");

            for (int numberValidationLoop = 0; numberValidationLoop < prizeNumberFromUser.length;
                 numberValidationLoop++) {
                validationPrizeNumber(prizeNumber, prizeNumberFromUser, numberValidationLoop);

                prizeNumber[numberValidationLoop] = Integer.parseInt(prizeNumberFromUser[numberValidationLoop]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
    }

    public void validationBonusNumber(int[] prizeNumber, int bonusNumber) {
        if (validate.wrongNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (validate.duplicateNumber(bonusNumber, prizeNumber)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public int getBonusNumberFromUser(int[] prizeNumber) {
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());

            validationBonusNumber(prizeNumber, bonusNumber);

            return bonusNumber;

        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
    }

}
