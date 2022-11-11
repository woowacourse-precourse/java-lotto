package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.LottoComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoComparatorTest {

    private Lotto prizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private int bonusNumber = 10;
    private LottoComparator comparator = new LottoComparator();

    @Test
    @DisplayName("로또 당첨 확인 기능_5등")
    void get_lotto_rank_fifth() {
        List<Integer> mock = List.of(1, 2, 3, 21, 22, 23);
        Lotto lotto = new Lotto(mock);
        Rank result = comparator.forTest_getLottoRank(lotto, prizeLotto, bonusNumber);
        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("로또 당첨 확인 기능_4등")
    void get_lotto_rank_fourth() {
        List<Integer> mock = List.of(1, 2, 3, 4, 22, 23);
        Lotto lotto = new Lotto(mock);
        Rank result = comparator.forTest_getLottoRank(lotto, prizeLotto, bonusNumber);
        assertThat(result).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("로또 당첨 확인 기능_3등")
    void get_lotto_rank_third() {
        List<Integer> mock = List.of(1, 2, 3, 4, 5, 23);
        Lotto lotto = new Lotto(mock);
        Rank result = comparator.forTest_getLottoRank(lotto, prizeLotto, bonusNumber);
        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("로또 당첨 확인 기능_2등")
    void get_lotto_rank_second() {
        List<Integer> mock = List.of(1, 2, 3, 4, 5, 10);
        Lotto lotto = new Lotto(mock);
        Rank result = comparator.forTest_getLottoRank(lotto, prizeLotto, bonusNumber);
        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("로또 당첨 확인 기능_1등")
    void get_lotto_rank_first() {
        List<Integer> mock = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(mock);
        Rank result = comparator.forTest_getLottoRank(lotto, prizeLotto, bonusNumber);
        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("로또 당첨 확인 기능_해당없음")
    void get_lotto_rank_none() {
        List<Integer> mock = List.of(21, 22, 23, 24, 25, 26);
        Lotto lotto = new Lotto(mock);
        Rank result = comparator.forTest_getLottoRank(lotto, prizeLotto, bonusNumber);
        assertThat(result).isEqualTo(Rank.NONE);
    }

}