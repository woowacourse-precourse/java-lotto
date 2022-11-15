package lotto;

import java.util.ArrayList;
import lotto.Domain.Lotto;
import lotto.Domain.User;
import lotto.Domain.WonLotto;
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

    @DisplayName("사용자가 가진 로또 리스트를 출력해준다")
    @Test
    void printLottosList()
    {
        Lotto lotto1 = new Lotto(List.of(21, 8, 23, 41, 42, 43));
        Lotto lotto4 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        User lottos = new User(List.of(lotto1,lotto2,lotto3),1000);
        assertThat(lottos.printLottosList()).usingRecursiveComparison().isEqualTo(new User(List.of(lotto4,lotto2,lotto3),1000));
    }

    @DisplayName("사용자가 가진 로또 리스트를 정렬한다")
    @Test
    void sortLottosList()
    {
        Lotto lotto1 = new Lotto(List.of(21, 8, 23, 41, 42, 43));
        Lotto lotto4 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        User lottos = new User(List.of(lotto1,lotto2,lotto3),1000);
        assertThat(lottos.lottosSort()).usingRecursiveComparison().isEqualTo(new User(List.of(lotto4,lotto2,lotto3),1000));

    }

    @DisplayName("당첨된 번호 확인")
    @Test
    void checkNumber()
    {
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 9, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto answer = new Lotto(List.of(1,2,3,4,5,6));
        User lottos = new User(List.of(lotto1,lotto2,lotto3),1000);
        WonLotto wonLotto = new WonLotto();
        WonLotto wonLotto2 = new WonLotto();
        wonLotto.addCount(2,1);
        List<WonLotto> tmp = new ArrayList<>();
        wonLotto2.addCount(0,0);
        tmp.add(wonLotto2);
        tmp.add(wonLotto);
        tmp.add(wonLotto2);
        assertThat(lottos.countLotto(answer,9)).usingRecursiveComparison().isEqualTo(tmp);
    }
    // 아래에 추가 테스트 작성 가능
}
