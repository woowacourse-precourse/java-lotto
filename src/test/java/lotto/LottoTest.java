package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    /**
     * countSameLottoNumber - 로또와 일치하는 숫자의 개수 반환
     */
    @BeforeAll
    static void init() throws IllegalArgumentException {
        int numberOfLotto = 1;
        ProgramManager.lotto = LottoManager.generateLotto(numberOfLotto);
    }

    @Test
    void countSameLottoNumber_1등_테스트() {
        List<Integer> userPredictLottoNumbers = ProgramManager.lotto.get(0);
        assertThat(LottoManager.Rank.first.getNumberOfSameLottoNumber()).isEqualTo(new Lotto(userPredictLottoNumbers).countSameLottoNumber(ProgramManager.lotto.get(0)));
    }

    @Test
    void countSameLottoNumber_2등_테스트() {
        List<Integer> userPredictLottoNumbers = LottoManager_getLottoRankResultTest.getUserPredictLottoNumbers_modified(2);
        assertThat(LottoManager.Rank.second.getNumberOfSameLottoNumber()).isEqualTo(new Lotto(userPredictLottoNumbers).countSameLottoNumber(ProgramManager.lotto.get(0)));
    }

    @Test
    void countSameLottoNumber_3등_테스트() {
        List<Integer> userPredictLottoNumbers = LottoManager_getLottoRankResultTest.getUserPredictLottoNumbers_modified(3);
        assertThat(LottoManager.Rank.third.getNumberOfSameLottoNumber()).isEqualTo(new Lotto(userPredictLottoNumbers).countSameLottoNumber(ProgramManager.lotto.get(0)));
    }

    @Test
    void countSameLottoNumber_4등_테스트() {
        List<Integer> userPredictLottoNumbers = LottoManager_getLottoRankResultTest.getUserPredictLottoNumbers_modified(4);
        assertThat(LottoManager.Rank.fourth.getNumberOfSameLottoNumber()).isEqualTo(new Lotto(userPredictLottoNumbers).countSameLottoNumber(ProgramManager.lotto.get(0)));
    }

    @Test
    void countSameLottoNumber_5등_테스트() {
        List<Integer> userPredictLottoNumbers = LottoManager_getLottoRankResultTest.getUserPredictLottoNumbers_modified(5);
        assertThat(LottoManager.Rank.fifth.getNumberOfSameLottoNumber()).isEqualTo(new Lotto(userPredictLottoNumbers).countSameLottoNumber(ProgramManager.lotto.get(0)));
    }

}
