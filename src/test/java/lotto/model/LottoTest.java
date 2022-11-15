package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.lottoticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("입력한 당첨번호 앞, 또는 뒤에 공백이 포함되어 있다면 공백 제거하고 정상 작동한다.")
    @Test
    void 입력_값_앞_뒤에_공백_넣기() {

        assertThat(new Lotto("  1,2,3,4,5,6  "))
            .isInstanceOf(Lotto.class);
    }

    @DisplayName("숫자가 아니가 예외가 발생한다.")
    @Test
    void 숫자가_아니면_예외처리() {

        assertThatThrownBy(() -> new Lotto("a,2,3,4,5,6"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 1 ~ 45 범위가 아니면 예외가 발생한다.")
    @Test
    void 잘못된_범위의_숫자가_들어온_경우() {

        assertThatThrownBy(() -> new Lotto("46,2,3,4,5,6"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 구분자가 ','가 아니면 예외가 발생한다.: 구분자 ',' 가 여러개 들어온 경우")
    @Test
    void 구분자가_잘못_들어온_경우1() {

        assertThatThrownBy(() -> new Lotto("1,,2,3,4,5,6"))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력 구분자가 ','가 아니면 예외가 발생한다.: 구분자가 ',' 이 아닌 경우")
    @Test
    void 구분자가_잘못_들어온_경우2() {

        assertThatThrownBy(() -> new Lotto("1.2.3.4.5.6"))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력 구분자가 ','가 아니면 예외가 발생한다.: 구분자가 끝에 하나 더 들어온 경우")
    @Test
    void 구분자가_잘못_들어온_경우3() {

        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,"))
            .isInstanceOf(IllegalArgumentException.class);
    }



}
