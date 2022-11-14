package lotto.Enum;

import java.util.Arrays;

public enum WinningType {

    MATCH3(3, "3개 일치 (5,000원) - ",5_000),
    MATCH4(4,"4개 일치 (50,000원) - ",50_000),
    MATCH5(5,"5개 일치 (1,500,000원) - ",1_500_000),
    MATCH6(6,"6개 일치 (2,000,000,000원) - ",2_000_000_000),
    MATCH5_BONUS(7, "5개 일치, 보너스 볼 일치 (30,000,000원) - ",30_000_000);

    private final int matchNumber;
    private final String winningMessage;
    private final int winningPrice;

    WinningType(int matchNumber, String winningMessage,int winningPrice){
        this.matchNumber = matchNumber;
        this.winningMessage = winningMessage;
        this.winningPrice = winningPrice;
    }

    public static WinningType findByNumber(int matchNumber){
        return Arrays.stream(WinningType.values())
                .filter(winningType -> winningType.matchNumber==matchNumber)
                .findAny()
                .orElseThrow(()->new IllegalArgumentException(ErrorCode.INVALID_INPUT.getMessage()));
    }

    public String printWinningMessage(int count){
        return this.winningMessage+ count+"개";
    }

    public int getWinningPrice(){
        return this.winningPrice;
    }


}
