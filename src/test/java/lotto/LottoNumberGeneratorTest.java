package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

// 100번 정도 실행해서 문제 없으면 정상으로 간주
public class LottoNumberGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("임의로 생성된 로또 번호는 6개의 숫자이다")
    public void canGenerateLottoNumbersOfSizeOf6() {
        final var sut = new LottoNumberGenerator();

        final List<Integer> numbers = sut.numbers();

        // 6자리 숫자 필요
        assertEquals(6, numbers.size());
    }

    @RepeatedTest(100)
    @DisplayName("임의로 생성된 로또 번호는 1-45 사이의 숫자이다")
    public void canGenerateLottoNumbersBetween1to45() {
        final var sut = new LottoNumberGenerator();

        final List<Integer> numbers = sut.numbers();

        // 숫자 범위 1-45
        assertTrue(numbers.get(0) > 0 && numbers.get(0) < 46);
        assertTrue(numbers.get(1) > 0 && numbers.get(1) < 46);
        assertTrue(numbers.get(2) > 0 && numbers.get(2) < 46);
        assertTrue(numbers.get(3) > 0 && numbers.get(3) < 46);
        assertTrue(numbers.get(4) > 0 && numbers.get(4) < 46);
        assertTrue(numbers.get(5) > 0 && numbers.get(5) < 46);
    }

    @RepeatedTest(100)
    @DisplayName("임의로 생성된 로또 번호는 중복이 없고 오름차순 정렬된 숫자이다")
    public void canGenerateLottoNumbersOfNoDuplicatesAndSortedAscending() {
        final var sut = new LottoNumberGenerator();

        final List<Integer> numbers = sut.numbers();

        // 중복 없음
        // 오름차순
        assertTrue(numbers.get(0) < numbers.get(1));
        assertTrue(numbers.get(1) < numbers.get(2));
        assertTrue(numbers.get(2) < numbers.get(3));
        assertTrue(numbers.get(3) < numbers.get(4));
        assertTrue(numbers.get(4) < numbers.get(5));
    }
}
