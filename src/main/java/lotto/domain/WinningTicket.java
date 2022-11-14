package lotto.domain;

import lotto.Message;

import java.util.HashSet;
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

    public void validateNumberRange(List<Integer> winnings) throws IllegalArgumentException {
        winnings.forEach(this::checkRange);
    }

    public void validateLength(List<Integer> winnings) throws IllegalArgumentException {
        if(winnings.size() != MAX_SIZE) {
            throw new IllegalArgumentException(LENGTH_MESSAGE.getValue());
        }
    }

    public void validateOverlap(List<Integer> winnings) throws IllegalArgumentException {
        if(new HashSet<>(winnings).size() != MAX_SIZE) {
            throw new IllegalArgumentException(OVERLAP_MESSAGE.getValue());
        }
    }

    public void validateBonusNumberOverlap(List<Integer> winnings, int bonusNumber) throws IllegalArgumentException {
        if(winnings.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.OVERLAP_BONUS_NUMBER_MESSAGE.getValue());
        }
    }

    public void checkRange(int num) throws IllegalArgumentException {
        try {
            if(num < START || num > END) {
                throw new IllegalArgumentException(Message.RANGE_EXCEED_MESSAGE.getValue());
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
