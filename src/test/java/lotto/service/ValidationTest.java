package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

import static lotto.service.Validation.*;

class ValidationTest {

    @ParameterizedTest
    @DisplayName("범위 검증 테스트")
    @CsvSource(
            value = {
                    "1:2:3",
                    "1:1:1",
                    "1:2:2"
            }, delimiter = ':'
    )
    void test1(final int lower, final double x, final int upper) {
        assert isInRange(lower, x, upper);
    }

    @ParameterizedTest
    @DisplayName("이상 검증 테스트")
    @CsvSource(
            value = {
                    "1:2",
                    "0:0",
                    "-1:0"
            }, delimiter = ':'
    )
    void test2(final int lower, final double x) {
        assert isUp(lower, x);
    }

    @ParameterizedTest
    @DisplayName("1000의 배수 검증 테스트")
    @CsvSource(
            value = {
                    "1000",
                    "1000000000",
                    "0",
                    "-1000"
            }, delimiter=':'
    )
    void test3(final int x) {
        assert isMultiplesOf1000(x);
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 맞는지 테스트")
    @MethodSource("createLotto")
    void test4(final List<Integer> input) {
        assert isLotto(input);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 아닌거 테스트")
    @MethodSource("createNoneLotto")
    void test5(final List<Integer> input) {
        assert !isLotto(input);
    }

    static Stream<List<Integer>> createLotto() {
        return Stream.of(
                List.of(1,2,3,4,5,6),
                List.of(2,3,4,5,6,7)
        );
    }

    static Stream<List<Integer>> createNoneLotto(){
        return Stream.of(
                List.of(0,1,2,3,4,5),
                List.of(-1,2,-7,3,0),
                List.of(45,32,15,3,28,46)
        );
    }
}