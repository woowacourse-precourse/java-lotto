package lotto.domain;

import lotto.utils.winning.RankUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void 로또_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void 로또_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 46, 55, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 3개 일치하면 5등을 반환한다.")
    @Test
    void 당첨_번호가_3개_일치하면_5등을_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 14, 15, 16);
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        RankUtil rank = lotto.compare(winningNumbers, 0);

        // then
        assertThat(rank).isEqualTo(RankUtil.FIFTH);
    }

    @DisplayName("당첨 번호가 5개 일치하지만 보너스 번호가 다르다면 3등을 반환한다.")
    @Test
    void 당첨_번호가_5개_일치하지만_보너스_번호가_다르다면_3등을_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 16);
        int bonusNumber = 45;
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        RankUtil rank = lotto.compare(winningNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualTo(RankUtil.THIRD);
    }

    @DisplayName("당첨 번호가 5개 일치하고 보너스 번호도 일치하다면 2등을 반환한다.")
    @Test
    void 당첨_번호가_5개_일치하고_보너스_번호도_일치하다면_2등을_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 45);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 16);
        int bonusNumber = 45;
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        RankUtil rank = lotto.compare(winningNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualTo(RankUtil.SECOND);
    }

    @DisplayName("로또 번호를 오름차순 정렬해서 반환한다.")
    @Test
    void 로또_번호를_오름차순_정렬해서_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(20, 3, 7, 15, 40, 1);
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        List<Integer> sortNumbers = lotto.getSortNumbers();

        // then
        assertThat(sortNumbers).containsExactly(1, 3, 7, 15, 20, 40);
    }

}
