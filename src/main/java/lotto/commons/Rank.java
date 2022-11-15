package lotto.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST_WIN(2000000000),
    SECOND_WIN(30000000),
    THIRD_WIN(1500000),
    FIRTH_WIN(50000),
    FIFTH_WIN(5000);

    private long money;

    private Rank() {
    }

    private Rank(int money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public List<String> getRankList() {
        List<String> rankList = new ArrayList<>(
                Arrays.asList("FIRST_WIN", "SECOND_WIN", "THIRD_WIN", "FIRTH_WIN", "FIFTH_WIN"));
        return rankList;
    }
}
