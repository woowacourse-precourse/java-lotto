package lotto.util;

import lotto.enums.IntEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.enums.IntEnum.*;

public class Statistics {
    private final List<Integer> reward = List.of(5000, 50000, 1500000, 2000000000, 30000000);
    private final List<Integer> rank = new ArrayList<>(Collections.nCopies(BONUS_SIZE.getValue(), 0));

}
