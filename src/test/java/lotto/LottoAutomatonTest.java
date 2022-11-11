package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAutomatonTest {
    private LottoAutomaton lottoAutomaton;
    private List<Integer> numbers;

    @BeforeEach
    void beforeEach() {
        lottoAutomaton = new LottoAutomaton(numbers);
    }

    @DisplayName("로또 개수 테스트")
    @Test
    void getCountTest() {
        // given
        String amount = "10000";

        // when
        int count = lottoAutomaton.getCount(amount);

        // then
        assertThat(count).isEqualTo(10);
    }

    @DisplayName("로또 자동 발행 테스트")
    @Test
    void createNumbersTest() {
        // when
        numbers = lottoAutomaton.createNumbers();

        // then
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).hasSize(6);
    }

    @DisplayName("로또 번호 오름차순 정렬 테스트")
    @Test
    void ascendingTest() {
        // given
        numbers = lottoAutomaton.createNumbers();

        // when
        lottoAutomaton.ascending(numbers);

        // then
        assertThat(numbers).isSorted();
    }
}