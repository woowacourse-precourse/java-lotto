package lotto.domain;

import lotto.constant.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.constant.Score.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoScoreTest {

    @DisplayName("로또 3개일 때 정상적으로 작동되는지 테스트")
    @Test
    void updateThreeLottoScore() {
        //given
        Map<Score, Integer> scoreStore = LottoScore.setInitialSetting();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 7;

        //when
        LottoScore.update(lottoNumbers, 3, bonusNumber);
        Integer count = scoreStore.get(THREE);

        //then
        assertThat(count).isSameAs(1);
    }

    @DisplayName("로또 4개일 때 정상적으로 작동되는지 테스트")
    @Test
    void updateFourLottoScore() {
        //given
        Map<Score, Integer> scoreStore = LottoScore.setInitialSetting();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 7;

        //when
        LottoScore.update(lottoNumbers, 4, bonusNumber);
        Integer count = scoreStore.get(FOUR);

        //then
        assertThat(count).isSameAs(1);
    }

    @DisplayName("로또 5개일 때 정상적으로 작동되는지 테스트")
    @Test
    void updateFiveLottoScore() {
        //given
        Map<Score, Integer> scoreStore = LottoScore.setInitialSetting();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        LottoScore.update(lottoNumbers, 5, bonusNumber);
        Integer count = scoreStore.get(FIVE);

        //then
        assertThat(count).isSameAs(1);
    }

    @DisplayName("로또 5개 + 보너스 숫자일 때 정상적으로 작동되는지 테스트")
    @Test
    void updateFiveBonusLottoScore() {
        //given
        Map<Score, Integer> scoreStore = LottoScore.setInitialSetting();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 7;

        //when
        LottoScore.update(lottoNumbers, 5, bonusNumber);
        Integer count = scoreStore.get(FIVE_BONUS);

        //then
        assertThat(count).isSameAs(1);
    }

    @DisplayName("로또 6개일 때 정상적으로 작동되는지 테스트")
    @Test
    void updateSixLottoScore() {
        //given
        Map<Score, Integer> scoreStore = LottoScore.setInitialSetting();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 7;

        //when
        LottoScore.update(lottoNumbers, 6, bonusNumber);
        Integer count = scoreStore.get(SIX);

        //then
        assertThat(count).isSameAs(1);
    }
}