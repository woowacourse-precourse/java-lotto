package lotto;

import java.util.List;
import java.util.Objects;

public class Domain {
    void checkWinning(Computer[] computers, int[] list, int[] numbers) {
        for (Computer computer : computers) {
            int index = checkWinningCount(computer.getNumbers(), numbers);
            list[index]++;
        }
    }

    int checkWinningCount(List<Integer> computers, int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (computers.contains(number)) count++;
        }
        if (Objects.equals(count, 6)) return 7;
        if (Objects.equals(count, 5) && computers.contains(numbers[6])) return 6;
        return count;
    }

    Long checkWinningMoney(int[] list) {
        long result = 0;
        result += list[7] * 2000000000L;
        result += list[6] * 30000000L;
        result += list[5] * 1500000L;
        result += list[4] * 50000L;
        result += list[3] * 5000L;
        return result;
    }
}
