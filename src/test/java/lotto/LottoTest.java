package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    // 아래에 추가 테스트 작성 가능
    @Test
    void 로또넘버와_추가넘버_정상_생성되는지_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isOverlappedNumbersAndBonusNumber()).isEqualTo(false);
    }

    @Test
    void 당첨번호_생성_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getLottoNumbers()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 보너스넘버_생성_테스트() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<Integer> numbers = lottoNumberGenerator.generateLottoNumbers();
        int bonusNumber = lottoNumberGenerator.generateBonusNumber(numbers);
        assertThat(numbers.contains(bonusNumber)).isEqualTo(false);
    }


}
