package data;

import java.util.List;

public enum ResultData {
    RESULT("당첨 통계"),
    LINE("---"),
    FIFTH("3개 일치 ("),
    FOURTH("4개 일치 ("),
    THIRD("5개 일치 ("),
    SECOND("5개 일치, 보너스 볼 일치 ("),
    FIRST("6개 일치 ("),
    CLOSE("원 ) - "),
    PROFIT_RATE("총 수익률은 "),
    PROFIT_RATE_CLOSE("%입니다.");

    String resultData;
    ResultData(String resultData){
        this.resultData = resultData;
    }

    public void printWinningResult(int[] winningRanking){

    }
}
