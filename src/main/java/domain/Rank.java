package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    FAIL(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int count;
    private final boolean bonus;
    private final int reward;

    Rank(int count, boolean bonus, int reward) {
        this.count = count;
        this.bonus = bonus;
        this.reward = reward;
    }

    public static Rank winningCondition(List<Integer> winning, List<Integer> user){
        int cnt = match(winning, user);
        System.out.println(cnt);
        boolean flag = isBonusPossible(winning.get(winning.size() - 1), user);
        System.out.println(flag);
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

    public int getReward() {
        return reward;
    }
}
