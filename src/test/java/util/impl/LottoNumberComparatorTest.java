package util.impl;

import org.junit.jupiter.api.Test;
import util.Comparator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberComparatorTest {

    @Test
    void doIntCompare() {
        Comparator comparator = new LottoNumberComparator();
        assertEquals(comparator.doIntCompare(List.of(1,2,3,4,5,6,7), List.of(4,5,6,7,8,9)), 2);
    }

    @Test
    void doIntCompare2() {
        Comparator comparator = new LottoNumberComparator();
        assertEquals(comparator.doIntCompare(List.of(1,9,8,4,5,6,7), List.of(4,5,6,7,8,9)), 4);
    }

    @Test
    void doIntCompare3() {
        Comparator comparator = new LottoNumberComparator();
        assertEquals(comparator.doIntCompare(List.of(7,9,8,4,5,6,1), List.of(4,5,6,7,8,9)), 5);
    }

}