package lotto.compareLottoNumber;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validate;

public class GetResultNumber {
    private final Validate validate = new Validate();

    public boolean validationPrizeNumber(int[] number, String[] prizeNumberFromUser, int numberValidationLoop) {
        if (prizeNumberFromUser.length != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자입니다.");
        }

        return validate.wrongNumber(Integer.parseInt(prizeNumberFromUser[numberValidationLoop])) ||
                validate.duplicateNumber(
                        Integer.parseInt(prizeNumberFromUser[numberValidationLoop]), number);
    }

    public void getPrizeNumberFromUser(int[] prizeNumber) {
        try {
            String[] prizeNumberFromUser = Console.readLine().split(",");

            for (int numberValidationLoop = 0; numberValidationLoop < prizeNumberFromUser.length; numberValidationLoop++) {
                if (validationPrizeNumber(prizeNumber, prizeNumberFromUser, numberValidationLoop)) {
                    throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                prizeNumber[numberValidationLoop] = Integer.parseInt(prizeNumberFromUser[numberValidationLoop]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
    }

}
