package lotto;

import java.util.ArrayList;
import lotto.Domain.Lotto;
import lotto.Domain.User;
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

    @DisplayName("머니가 1000원으로 나누어떨어지지 않으면 예외가 발생한다")
    @Test
    void createUserMoneyByNot1000()
    {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(()->new User(List.of(lotto),100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 가진 로도 리스트를 출력해준다")
    @Test
    void printLottosList()
    {
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        User lottos = new User(List.of(lotto1,lotto2,lotto3),1000);
        assertThat(lottos.printLottosList()).usingRecursiveComparison().isEqualTo(new User(List.of(lotto1,lotto2,lotto3),1000));
    }
    // 아래에 추가 테스트 작성 가능
}
