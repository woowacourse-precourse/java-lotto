package lotto;

import java.util.List;

public class Referee {

    public int correctCount(Lotto input, List<Integer> numbers) {
        int count = 0;

        for(int number : numbers) {
            if(input.getNumbers().contains(number)) {
                count++;
            }
        }

        return count;
    }
}
