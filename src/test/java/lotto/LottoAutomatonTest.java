package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAutomatonTest {
    private Lotto lotto;
    private LottoAutomaton automaton;
    private List<Integer> numbers;

    @BeforeEach
    void beforeEach() {
        automaton = new LottoAutomaton();
        lotto = new Lotto(automaton.createNumbers());
    }

    @DisplayName("로또 개수 테스트")
    @Test
    void getCountTest() {
        // given
        String amount = "10000";

        // when
        int count = automaton.getCount(amount);

        // then
        assertThat(count).isEqualTo(10);
    }

    @DisplayName("로또 자동 발행 테스트")
    @Test
    void createNumbersTest() {
        // when
        numbers = automaton.getNumbers();

        // then
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).hasSize(6);
    }

    @DisplayName("로또 번호 오름차순 정렬 테스트")
    @Test
    void ascendingTest() {
        // given
        numbers = automaton.getNumbers();
        lotto = new Lotto(numbers);
        // when
        lotto.ascending(numbers);

        // then
        assertThat(numbers).isSorted();
    }
}