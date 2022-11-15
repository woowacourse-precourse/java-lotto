package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratorTest {

    @DisplayName("발행된 로또 숫자는 곧바로 정렬되므로 정렬 전후가 같다.")
    @Test
    void createLottoByUnderRangeNumber() {
        Generator generator = new Generator();
        List<Integer> beforeSorted = generator.createLottoNumbers();
        List<Integer> afterSorted = beforeSorted.stream().sorted().collect(Collectors.toList());
        assertEquals(beforeSorted, afterSorted);

    }
}
