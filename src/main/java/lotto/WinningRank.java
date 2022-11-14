package lotto;

import java.text.DecimalFormat;

public enum WinningRank {
    BANG(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int rightNumCnt;
    private final int reward;

    WinningRank(int rightNumCnt, int reward){
        this.rightNumCnt = rightNumCnt;
        this.reward = reward;
    }

    public static WinningRank checkRank(int rightNumCnt, boolean isContainBonus){
        if(rightNumCnt<3) return BANG;
        if(SECOND.rightNumCnt == rightNumCnt && isContainBonus) return SECOND;
        for(WinningRank rank : values()){
            if(rank.rightNumCnt == rightNumCnt && rank !=SECOND) return rank;
        }

        System.out.println("[ERROR] 일치하는 번호의 개수를 찾을 수 없습니다.");
        throw new IllegalArgumentException();
    }

    public int getRightNumCnt(){
        return rightNumCnt;
    }

    public int getReward(){
        return reward;
    }

    public String getRewardDecimalFormat(){
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(getReward());
    }
}
