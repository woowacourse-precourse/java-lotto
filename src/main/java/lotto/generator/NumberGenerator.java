package lotto.generator;

import java.util.List;

public interface NumberGenerator {
    List<Integer> generate(int min, int max, int size);
}
