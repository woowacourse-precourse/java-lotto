package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static lotto.LottoService.*;
import static org.assertj.core.api.Assertions.assertThat;

class TypeConverterTest {
    @Test
    void 문자_리스트를_정수_리스트로_변환() {
        assertThat(TypeConverter.convertStringListToIntegerList(List.of("1", "2", "3", "4")))
                .isEqualTo(List.of(1, 2, 3, 4));
    }

    @Test
    void 우승_결과_값을_담은_map을_List로_변환() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(FIRST_PRIZE, 1);
        map.put(SECOND_PRIZE, 2);
        map.put(THIRD_PRIZE, 3);
        map.put(FOURTH_PRIZE, 4);
        map.put(FIFTH_PRIZE, 5);

        assertThat(TypeConverter.convertResultMapToResultList(map))
                .containsExactly(5, 4, 3, 2, 1);
    }
}
