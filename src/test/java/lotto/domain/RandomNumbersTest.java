package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class RandomNumbersTest {

    @Test
    void createRandomNumbers() {
        RandomNumbers randomNumbers = new RandomNumbers();
        //[1, 4, 5 ,11 ,33, 41] -> 1 < 45
        List<Integer> sortedNumbers = randomNumbers.createRandomNumbers();
    }
}