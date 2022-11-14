package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    FAIL(0, false, 0L, 0),
    FIFTH(3, false, 5_000L, 5),
    FOURTH(4, false, 50_000L, 4),
    THIRD(5, false, 1_500_000L, 3),
    SECOND(5, true, 30_000_000L, 2),
    FIRST(6, false, 2_000_000_000L, 1);

    private final int count;
    private final boolean bonus;
    private final Long reward;
    private final int ranking;

    Rank(int count, boolean bonus, Long reward, int ranking) {
        this.count = count;
        this.bonus = bonus;
        this.reward = reward;
        this.ranking = ranking;
    }

    public static Rank winningCondition(List<Integer> winning, List<Integer> user){
        int cnt = match(winning, user);
        boolean flag = isBonusPossible(winning.get(winning.size() - 1), user);
        Rank rank = FAIL;

        if(cnt == Rank.FIFTH.getCount()){
            rank = FIFTH;
        }
        if(cnt == Rank.FOURTH.getCount()){
            rank = FOURTH;
        }
        if(cnt == Rank.THIRD.getCount() && flag == Rank.THIRD.isBonus()){
            rank = THIRD;
        }
        if(cnt == Rank.SECOND.getCount() && flag == Rank.SECOND.isBonus()){
            rank = SECOND;
        }
        if(cnt == Rank.FIRST.getCount()){
            rank = FIRST;
        }

        return rank;
    }

    public static int match(List<Integer> winning, List<Integer> user){
        int cnt = 0;
        for (int i = 0; i < winning.size()-1; i++) {
            cnt += compare(winning.get(i), user);
        }

        return cnt;
    }

    public static boolean isBonusPossible(int n, List<Integer> user){
        boolean flag = false;
        for (int i = 0; i < user.size(); i++) {
            if(n == user.get(i)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static int compare(int n, List<Integer> user){
        int cnt = 0;
        for (int i = 0; i < user.size(); i++) {
            if(n == user.get(i)){
                cnt++;
            }
        }
        return cnt;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonus() {
        return bonus;
    }

    public Long getReward() {
        return reward;
    }

    public int getRanking() {
        return ranking;
    }
}
