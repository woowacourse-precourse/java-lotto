package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AscendingSorterTest {

    @Test
    void sortAscendingOrder() {
        AscendingSorter ascendingSorter = new AscendingSorter();
        List<List<Integer>> listA = new ArrayList<>();
        List<List<Integer>> listB = new ArrayList<>();
        listA.add(new ArrayList<>(List.of(5, 3, 2, 4, 1)));
        listA.add(new ArrayList<>(List.of(4, 3, 2, 1, 5)));
        listB.add(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        listB.add(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        assertThat(ascendingSorter.sortAscendingOrder(listA)).isEqualTo(listB);
    }
}