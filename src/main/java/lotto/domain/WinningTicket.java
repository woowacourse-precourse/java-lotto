package lotto.domain;

import java.util.List;
import static lotto.Message.*;

public class WinningTicket {
    private static final int MAX_SIZE = 6;
    private static final int START = 1;
    private static final int END = 45;
    private final List<Integer> winnings;
    private final int bonusNumber;

    public WinningTicket(List<Integer> winnings, int bonusNumber) throws IllegalArgumentException {
        validateNumberRange(winnings);
        validateLength(winnings);
        validateOverlap(winnings);
        checkRange(bonusNumber);
        validateBonusNumberOverlap(winnings, bonusNumber);
        this.winnings = winnings;
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberRange(List<Integer> winnings) throws IllegalArgumentException {
        winnings.forEach(this::checkRange);
    }

    private void validateLength(List<Integer> winnings) throws IllegalArgumentException {
        if(winnings.size() != MAX_SIZE) {
            throw new IllegalArgumentException(LENGTH_MESSAGE.getValue());
        }
    }

    private void validateOverlap(List<Integer> winnings) throws IllegalArgumentException {
        if(getDistinctLength(winnings) != MAX_SIZE) {
            throw new IllegalArgumentException(OVERLAP_MESSAGE.getValue());
        }
    }

    private int getDistinctLength(List<Integer> winnings) {
        return (int)winnings.stream().distinct().count();
    }

    private void validateBonusNumberOverlap(List<Integer> winnings, int bonusNumber) throws IllegalArgumentException {
        if(winnings.contains(bonusNumber)) {
            throw new IllegalArgumentException(OVERLAP_BONUS_NUMBER_MESSAGE.getValue());
        }
    }

    private void checkRange(int num) throws IllegalArgumentException {
        try {
            if(num < START || num > END) {
                throw new IllegalArgumentException(RANGE_EXCEED_MESSAGE.getValue());
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
