package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Result {

    public int countMatchingNumber(List<Integer> winningLottoNumbers, List<Integer> userNumbers) {
        int matchingCount = 0;
        for (int number : winningLottoNumbers) {
            if (userNumbers.contains(number)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }
}
