package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum WinningPlace {
    FIRST_PLACE(6,0,2000000000,"6개 일치 (2,000,000,000원) - "),
    SECOND_PLACE(5,1,30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PLACE(5,0,1500000,"5개 일치 (1,500,000원) - "),
    FOURTH_PLACE(4,0,50000,"4개 일치 (50,000원) - "),
    FIFTH_PLACE(3,0,5000,"3개 일치 (5,000원) - "),
    NOT_IN_PLACE(0, 0, 0, "순위 안에 들지 못했습니다.");

    private Integer correspondingNumber;
    private Integer correspondingBonusNumber;
    private Integer winnings;
    private String message;

    public Integer getWinnings() {
        return this.winnings;
    }

    public String getMessage() {
        return this.message;
    }

    public static WinningPlace getPlace(int correspondingNumber, int correspondingBonusNumber) throws Exception {
        Optional<WinningPlace> getWinningPlace = Arrays.stream(values())
                .filter(winningPlace -> winningPlace.correspondingNumber == correspondingNumber)
                .filter(winningPlace -> winningPlace.correspondingBonusNumber == correspondingBonusNumber)
                .findAny();

        if (!getWinningPlace.isPresent()) {
            return NOT_IN_PLACE;
        }

        return getWinningPlace.get();
    }

    WinningPlace(Integer correspondingNumber, Integer correspondingBonusNumber, Integer winnings, String message) {
        this.correspondingNumber = correspondingNumber;
        this.correspondingBonusNumber = correspondingBonusNumber;
        this.winnings = winnings;
        this.message = message;
    }
}
