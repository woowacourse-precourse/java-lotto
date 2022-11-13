package lotto.domain;

import java.util.List;

public interface PickNumbers {
    List<Integer> pickUniquesInRange(int startInclusive, int endInclusive, int count);
}
