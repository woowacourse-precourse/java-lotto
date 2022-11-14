package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class Domain {
    void checkWinning(Computer[] computers, EnumMap<Money, Integer> map, Lotto lotto) {
        for (Computer computer : computers) {
            int count = checkWinningCount(computer.getNumbers(), lotto.getNumbers());
            Money money = WinningKey(count);
            map.put(money, map.getOrDefault(money, 0) + 1);
        }
    }

    Money WinningKey(int count) {
        if (Objects.equals(count, 7)) return Money.first;
        else if (Objects.equals(count, 6)) return Money.second;
        else if (Objects.equals(count, 5)) return Money.third;
        else if (Objects.equals(count, 4)) return Money.fourth;
        else if (Objects.equals(count, 3)) return Money.fifth;
        return Money.notThing;
    }

    int checkWinningCount(List<Integer> computers, List<Integer> lottoList) {
        int count = 0;
        for (int i = 0; i < lottoList.size() - 1; i++) {
            if (computers.contains(lottoList.get(i))) count++;
        }
        if (Objects.equals(count, 6)) return 7;
        if (Objects.equals(count, 5) && computers.contains(lottoList.get(6))) return 6;
        return count;
    }

    Long checkWinningMoney(EnumMap<Money, Integer> map) {
        long result = 0;
        for (Money money : map.keySet())
            result += (long) map.getOrDefault(money, 0) * Money.valueOf(String.valueOf(money)).getMoney();
        return result;
    }
}
