package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningTicket {
    private static final String RANGE_EXCEED_MESSAGE = "[ERROR] 숫자는 1 ~ 45로 입력할 수 있습니다.";
    private static final String LENGTH_MESSAGE = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    private static final String OVERLAP_MESSAGE = "[ERROR] 중복되는 숫자가 존재합니다.";
    private static final String OVERLAP_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 숫자가 당첨번호에 존재합니다.";
    private static final int MAX_SIZE = 6;
    private List<Integer> winnings;
    private int bonusNumber;

    public WinningTicket(List<Integer> winnings, int bonusNumber) {
        try {
            validateNumberRange(winnings);
            validateLength(winnings);
            validateOverlap(winnings);
            validateBonusNumberOverlap(winnings, bonusNumber);
            this.winnings = winnings;
            this.bonusNumber = bonusNumber;
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validateNumberRange(List<Integer> winnings) throws IllegalArgumentException {
        winnings.forEach(this::checkRange);
    }

    public void validateLength(List<Integer> winnings) throws IllegalArgumentException {
        if(winnings.size() != MAX_SIZE) {
            throw new IllegalArgumentException(LENGTH_MESSAGE);
        }
    }

    public void validateOverlap(List<Integer> winnings) throws IllegalArgumentException {
        if(new HashSet<>(winnings).size() != MAX_SIZE) {
            throw new IllegalArgumentException(OVERLAP_MESSAGE);
        }
    }

    public void validateBonusNumberOverlap(List<Integer> winnings, int bonusNumber) throws IllegalArgumentException {
        if(winnings.contains(bonusNumber)) {
            throw new IllegalArgumentException(OVERLAP_BONUS_NUMBER_MESSAGE);
        }
    }

    public void checkRange(int num) throws IllegalArgumentException {
        try {
            if(num < 1 || num > 45) {
                throw new IllegalArgumentException(RANGE_EXCEED_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<Integer> getWinnings() {
        return this.winnings;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
