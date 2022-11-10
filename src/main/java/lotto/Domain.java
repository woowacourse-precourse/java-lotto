package lotto;

import java.util.List;
import java.util.Objects;

public class Domain {
    void checkWinning(Computer[] computers, int[] list, Lotto lotto) {
        for (Computer computer : computers) {
            int index = checkWinningCount(computer.getNumbers(), lotto.getNumbers());
            list[index]++;
        }
    }

    int checkWinningCount(List<Integer> computers, List<Integer> lottoList) {
        int count = 0;
        for (int i = 0 ; i < lottoList.size() -1 ; i++) {
            if (computers.contains(lottoList.get(i))) count++;
        }
        if (Objects.equals(count, 6)) return 7;
        if (Objects.equals(count, 5) && computers.contains(lottoList.get(6))) return 6;
        return count;
    }

    Long checkWinningMoney(int[] list) {
        long result = 0;
        int index = 7;
        for (Money money : Money.values())
            result += (long) list[index--] * money.getMoney();
        return result;
    }
}
