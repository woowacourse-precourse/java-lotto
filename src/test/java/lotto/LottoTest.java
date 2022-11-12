package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("로또 번호를 생성하여 개수 테스트, 중복 테스트를 진행한다.")
    @Test
    void createLottoRandomByDuplicatedNumber() {

        MakeLottoNumber makeLottoNumber = new MakeLottoNumber();
        Lotto lotto = new Lotto(makeLottoNumber.returnLottoNumber());
    }

    @DisplayName("input 값이 숫자가 아니면 예외처리")
    @Test
    void isCashInt() {
        String input = "ABBD";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Cash cash = new Cash();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cash.Input();
        });
    }

    @DisplayName("1000원 단위로 입력되지 않으면 예외처리")
    @Test
    void isCashCheck() {
        String input = "7999";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Cash cash = new Cash();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cash.Input();
        });
    }
}
