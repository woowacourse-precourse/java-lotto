package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45사이의 숫자가 아닐경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0,1,2,3,4,5", "1,2,3,4,5,46","0,5,11,12,32,78"})
    void 로또번호_범위체크(int int1, int int2, int int3, int int4, int int5, int int6) {
        assertThatThrownBy(() -> new Lotto(List.of(int1, int2, int3, int4, int5, int6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 일치 갯수")
    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,6", "1,5,10,12,14,15,2","7,8,9,10,12,15,0"})
    void 로또정답_갯수(int int1, int int2, int int3, int int4, int int5, int int6,int count) {
        List<Integer> answer = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = new ArrayList<>(List.of(int1, int2, int3, int4, int5, int6));
        Lotto lotto = new Lotto(numbers);
        assertThat(count).isEqualTo(lotto.countMatchNumber(answer));
    }

    // 아래에 추가 테스트 작성 가능
}
