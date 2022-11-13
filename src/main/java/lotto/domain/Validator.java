package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> distinctNumbers = new HashSet<>(lottoNumbers);

        if (distinctNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateUserInput(String userInput) {
        String verifiedUserInput = verifyUserInputIsDigit(userInput);
        verifyUserInputIsMultipleOf1000(verifiedUserInput);
    }

    private void verifyUserInputIsMultipleOf1000(String verifiedUserInput) {
        try {
            if (Integer.parseInt(verifiedUserInput) % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력을 해주세요.");
            }
        }catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 2^31-1 까지의 범위만 입력이 가능합니다.");
        }
    }

    private String verifyUserInputIsDigit(String userInput) {
        for (int idx = 0; idx < userInput.length(); idx++) {
            int eachNum = userInput.charAt(idx);

            if (!Character.isDigit(eachNum)) {
                throw new IllegalArgumentException("[ERROR] \"숫자\" 만 입력해주세요 (쉼표도 제외입니다.)");
            }
        }

        return userInput;
    }
}
