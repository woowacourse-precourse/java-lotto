package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class LottoTest {

    @ParameterizedTest
    @DisplayName("로또를 잘 생성하는지 검증")
    @MethodSource("createNumbers")
    void lottoTest(final List<Integer> numbers) {
        new Lotto(numbers);
    }

    static Stream<List<Integer>> createNumbers() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 3, 5, 7, 9, 11),
                List.of(23, 45, 2, 39, 9, 17)
        );
    }
}