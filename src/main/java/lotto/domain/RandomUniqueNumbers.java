package lotto.domain;

import java.util.List;

public interface RandomUniqueNumbers {
    List<Integer> pickUniquesInRange(int startInclusive, int endInclusive, int count);
}
