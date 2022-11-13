package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> distinctNumbers = new HashSet<>(lottoNumbers);

        if (distinctNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 중복되지 않게 6자리가 필요합니다.");
        }

        for (Integer lottoNumber : lottoNumbers) {
            if(!isNumberInLottoNumRange(lottoNumber)){
                throw new IllegalArgumentException("[ERROR] 번호는 1~45 까지 가능합니다.");
            }
        }
    }

    private boolean isNumberInLottoNumRange(Integer number) {
        return  1 <= number && number <= 45;
    }

    public void validateUserInput(String userInput) {
        String verifiedUserInput = verifyUserInputIsDigit(userInput);
        verifyUserInputIsMultipleOf1000(verifiedUserInput);
    }


    public List<Integer> validateWinningSixNumber(List<Integer> winningNums) {
        validateLottoNumbers(winningNums);
        return winningNums;
    }

    public int validateBonusNumber(List<Integer> userSelectLottoNums, List<Integer> bonusNumber) {
        if (bonusNumber.size() != 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개만 입력이 가능합니다.");
        }

        Integer bonusEachNum = bonusNumber.get(0);

        if(!isNumberInLottoNumRange(bonusEachNum)){
            throw new IllegalArgumentException("[ERROR] 번호는 1~45 까지 가능합니다.");
        }

        if (userSelectLottoNums.contains(bonusEachNum)){
            throw new IllegalArgumentException("[ERROR] 먼저 입력하신 당첨 번호와 중복됩니다.");
        }

        return bonusEachNum;
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
