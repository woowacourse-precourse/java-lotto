package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        return new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    }
}
