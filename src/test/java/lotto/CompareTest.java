package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareTest {
    @Test
    void compareClassTest1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lotto = Arrays.asList(1, 3, 5, 7, 9, 12);
        int bonus = 2;
        Compare compare = new Compare(numbers, lotto, bonus);
        assertEquals(compare.sameNumberCnt, 3);
        assertEquals(compare.isBonusSame, true);
    }

    @Test
    void compareClassTest2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lotto = Arrays.asList(7, 8, 9, 10, 11, 12);
        int bonus = 13;
        Compare compare = new Compare(numbers, lotto, bonus);
        assertEquals(compare.sameNumberCnt, 0);
        assertEquals(compare.isBonusSame, false);
    }

}