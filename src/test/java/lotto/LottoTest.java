package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;

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
    void createLottoNumber_로또번호리턴() {
        List<List<Integer>> returnValue = new LottoGenerator().createLottos(10000);
        for (int i = 0; i < returnValue.size(); i++) {
            System.out.println(returnValue.get(i));
        }
    }

    // 로또 번호 갯수가 5자리
    // 로또 번호가 45를 넘어감
    // 사용자가 입력하는 모든 값에서 공백이 들어갈 경우

    @DisplayName("로또 번호의 개수가 6개 이하일 경우 예외가 발생한다.")
    @Test
    void createLottoByLowSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
