package lotto.domain;

import java.util.Arrays;

public enum WinningType {

    MATCH3(3, "3개 일치 (5,000원) - "),
    MATCH4(4,"4개 일치 (50,000원) - "),
    MATCH5(5,"5개 일치 (1,500,000원) - "),
    MATCH6(6,"6개 일치 (2,000,000,000원) - "),
    MATCH5_BONUS(7, "5개 일치, 보너스 볼 일치 (30,000,000원) - ");

    private final int matchNumber;
    private final String winningMessage;

    WinningType(int matchNumber, String winningMessage){
        this.matchNumber = matchNumber;
        this.winningMessage = winningMessage;
    }

    public static WinningType findByNumber(int matchNumber){
        return Arrays.stream(WinningType.values())
                .filter(winningType -> winningType.matchNumber==matchNumber)
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("[ERROR] matchNumber 잘못입력했음."));
    }

    public String printWinningMessage(int count){
        return this.winningMessage+ count+"개";
    }


}
