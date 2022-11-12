package domain;

import vo.LottoInfo;

import java.util.HashSet;
import java.util.List;

public class Validator {
    private static final String MONEY_NUMBER_ERROR = "[ERROR] 로또 구입 금액은 숫자로 입력 가능합니다.";
    private static final String MONEY_UNIT_ERROR = "[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다.";

    private static final String WINNING_NUMBER_COMMA_ERROR = "[ERROR] 로또 번호 6개를 ,로 구분하여 입력하여야 합니다.";
    private static final String WINNING_NUMBER_SIZE_ERROR = "[ERROR] 로또 번호 6개를 입력하셔야 합니다.";
    private static final String WINNING_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String WINNING_NUMBER_REFERENCE_ERROR = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

    private static final String BONUS_NUMBER_RANGE_ERROR = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String BONUS_NUMBER_REFERENCE_ERROR = "[ERROR] 보너스 번호는 로또 번호와 겹치지 않아야 합니다.";


    public void validateMoneyNumber(String userMoney) {
        if (!userMoney.matches("[0-9]+")) {
            throw new IllegalArgumentException(MONEY_NUMBER_ERROR);
        }
    }

    public void validateMoneyUnit(String userMoney) {
        int totalMoney = Integer.parseInt(userMoney);
        if (totalMoney % LottoInfo.PRICE != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR);
        }
    }

    public void validateWinningNumberComma(String winningNumbers) {
        String validateWinningNumbers = winningNumbers.replaceAll("[0-9]", "");
        if (!(validateWinningNumbers.length() == 5 && validateWinningNumbers.contains(","))) {
            throw new IllegalArgumentException(WINNING_NUMBER_COMMA_ERROR);
        }
    }

    public void validateWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoInfo.LOTTO_LENGTH) {
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROR);
        }
    }

    public void validateWinningNumberRange(List<Integer> winningNumbers) {
        for (int i = 0; i < winningNumbers.size(); i++) {
            int number = winningNumbers.get(i);
            if (!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException(WINNING_NUMBER_RANGE_ERROR);
            }
        }
    }

    public void validateWinningNumberReference(List<Integer> winningNumbers) {

        int size = new HashSet<Integer>(winningNumbers).size();

        if (size != winningNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_REFERENCE_ERROR);
        }
    }

    public void validateBonusNumberRange(String bonusNumber) {

        if (!bonusNumber.matches("(^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$)")) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR);
        }
    }

    public void validateReference(List<Integer> winningNumbers, String bonusNumber) {

        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(BONUS_NUMBER_REFERENCE_ERROR);
        }
    }

}
