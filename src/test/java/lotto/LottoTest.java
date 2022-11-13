package lotto;

import lotto.reward.Lotto;
import lotto.reward.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.Console;
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

    @DisplayName("로또 번호 입력 성공한 경우")
    @Test
    void createLottoSucceedInput() {
        Console console = System.console();

    }

    //로또 랜덤 숫자 6개를 확인한다.
    @DisplayName("로또 자동 출력 번호 테스트하기")
    @Test
    void checkLottoSize(){
        assertThat(new Lotto(new RandomNumbers()).getLottoSixNumbers()).hasSize(6);
    }
    // 아래에 추가 테스트 작성 가능
}
