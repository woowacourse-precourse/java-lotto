package lotto.view;

import lotto.error.ErrorMsg;

public enum RankingMsg {

    FIRST("6개 일치 (2,000,000,000원) - ",1),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ",2),
    THIRD("5개 일치 (1,500,000원) - ",3),
    FOURTH("4개 일치 (50,000원) - ",4),
    FIFTH("3개 일치 (5,000원) - ",5);

    private final String msg;
    private final int rank;

    RankingMsg(String msg, int rank) {
        this.msg = msg;
        this.rank = rank;
    }

    public String getMsg() {
        return msg;
    }

    public int getRank() {
        return rank;
    }

    public static String rank(int rank, int count) {
        for(RankingMsg rankingMsg : RankingMsg.values()){
            if (rankingMsg.getRank() == rank){
                return rankingMsg.getMsg() +String.valueOf(count) +"개";
            }
        }
        throw new IllegalArgumentException(ErrorMsg.INPUT_ERROR.toString());
    }
}
