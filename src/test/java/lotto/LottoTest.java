package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    // 아래에 추가 테스트 작성 가능

    @DisplayName("입력받은 금액 만큼 로또번호를 생성.")
    @Test
    void CreateLottoNumInputMoney(){
        User user = new User();
        List<List<Integer>> AutoLotto = new ArrayList<>();
        AutoLotto = user.Count(8000);
        assert(AutoLotto.size() == 8);
    }

    @DisplayName("입력받은 금액이 1000단위가아니면 오류")
    @Test
    void CheckMoney(){
        User user = new User();
        assertThatThrownBy(() ->  user.Count(8500))
                .isInstanceOf(IllegalArgumentException.class);

    }
    

}
