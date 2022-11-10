package lotto.domain.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("결과 EnumMap 초기화 테스트")
    @Test
    void createInitResult(){
        EnumMap<ResultCase, Integer> result = Arrays.stream(ResultCase.values())
                .collect(Collectors.toMap(value -> value, count -> 0, (a, b) -> b,
                        () -> new EnumMap<>(ResultCase.class)));

        assertThat(new LottoResult()).isEqualTo(new LottoResult(result));
    }

}