package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

    @DisplayName("Lotto와 Player를 비교해서 같은 수의 개수를 반환 - 3개 일치")
    @Test
    void correctCountByMatchingThree() {
        // given
        Lotto lotto = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);

        // when
        Judgement judgement = new Judgement();
        int result = judgement.correctCount(lotto, player);

        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("Lotto와 Player를 비교해서 같은 수의 개수를 반환 - 4개 일치")
    @Test
    void correctCountByMatchingFour() {
        // given
        Lotto lotto = new Lotto(List.of(1, 3, 5, 6, 22, 45));
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);

        // when
        Judgement judgement = new Judgement();
        int result = judgement.correctCount(lotto, player);

        // then
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("Lotto와 Player를 비교해서 같은 수의 개수를 반환 - 5개 일치")
    @Test
    void correctCountByMatchingFive() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 14));
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);

        // when
        Judgement judgement = new Judgement();
        int result = judgement.correctCount(lotto, player);

        // then
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("Lotto와 Player를 비교해서 같은 수의 개수를 반환 - 6개 일치")
    @Test
    void correctCountByMatchingSix() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);

        // when
        Judgement judgement = new Judgement();
        int result = judgement.correctCount(lotto, player);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("Lotto와 Player를 비교해서 같은 수의 개수를 반환 - 0개 일치")
    @Test
    void correctCountByNoneMatch() {
        // given
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);

        // when
        Judgement judgement = new Judgement();
        int result = judgement.correctCount(lotto, player);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("Lotto와 Player를 비교해서 같은 수의 개수를 반환 - 1개 일치")
    @Test
    void correctCountByMatchingOne() {
        // given
        Lotto lotto = new Lotto(List.of(5, 21, 23, 41, 42, 43));
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);

        // when
        Judgement judgement = new Judgement();
        int result = judgement.correctCount(lotto, player);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("Lotto와 Player를 비교해서 같은 수의 개수를 반환 - 2개 일치")
    @Test
    void correctCountByMatchingTwo() {
        // given
        Lotto lotto = new Lotto(List.of(5, 6, 23, 41, 42, 43));
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);

        // when
        Judgement judgement = new Judgement();
        int result = judgement.correctCount(lotto, player);

        // then
        assertThat(result).isEqualTo(2);
    }
}