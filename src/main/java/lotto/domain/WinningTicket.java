package lotto.domain;

import java.util.List;

public class WinningTicket {
    private static final String RANGE_EXCEED_MESSAGE = "[ERROR] 숫자는 1 ~ 45로 입력할 수 있습니다.";
    private List<Integer> winnings;
    private int bonusNumber;

    public WinningTicket(List<Integer> winnings, int bonusNumber) {
        try {
            validateNumberRange(winnings);
            this.winnings = winnings;
            this.bonusNumber = bonusNumber;
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validateNumberRange(List<Integer> winnings) throws IllegalArgumentException {
        winnings.forEach(this::checkRange);
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
}
