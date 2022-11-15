package lotto.utils.enums;

import java.text.DecimalFormat;

public enum Rank {
    FIVE(3, false, 5000),
    FOUR(4, false, 50000),
    THREE(5, false, 1500000),
    TWO(5, true, 30000000),
    ONE(6, false, 2000000000),
    ;

    private final int matchNumber;
    private final boolean matchBonusNumber;
    private final int reward;
    private int count;

    Rank(int matchNumber, boolean matchBonusNumber, int reward) {
        this.matchNumber = matchNumber;
        this.matchBonusNumber = matchBonusNumber;
        this.reward = reward;
        this.count = 0;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean getMatchBonusNumber() {
        return matchBonusNumber;
    }

    public int getReward() {
        return reward;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void countUp() {
        this.count++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        //  일치하는 숫자 개수
        stringBuilder.append(countMatchNumber());
        stringBuilder.append(countBonusNumber());
        //  상금
        stringBuilder.append(countReward());
        //  개수
        stringBuilder.append(countRank());
        return stringBuilder.toString();
    }

    private String countMatchNumber() {
        int matchNumber = this.matchNumber;
        return String.format("%d개 일치", matchNumber);
    }

    private String countBonusNumber() {
        boolean matchBonusNumber = this.matchBonusNumber;
        if (matchBonusNumber) {
            return ", 보너스 볼 일치 ";
        }
        return " ";
    }

    private String countReward() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        int reward = this.reward;
        return String.format("(%s원) - ", formatter.format(reward));
    }

    private String countRank() {
        int countRank = this.count;
        return String.format("%d개", countRank);
    }

    public static Rank findRank(int matchNumber, boolean matchBonusNumber){
        for(Rank rank : Rank.values()){
            if(rank.getMatchNumber() == matchNumber && rank.getMatchBonusNumber() == matchBonusNumber){
                return rank;
            }
        }
        return null;
    }
}