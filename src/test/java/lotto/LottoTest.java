package lotto;

import lotto.caculation.Money;
import lotto.caculation.Purchase;
import lotto.reward.Lotto;
import lotto.reward.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    void checkLottoSize() {
        assertThat(new Lotto(new RandomNumbers()).getLottoSixNumbers()).hasSize(6);
    }

    @Test
    void 로또_숫자_범위_확인() {
        Lotto lotto = new Lotto(new RandomNumbers());
        for (Integer lottoNumber : lotto.getLottoSixNumbers()) {
            assertThat(lottoNumber).isLessThanOrEqualTo(45);
        }
    }

    @Test
    void 당첨_숫자_확인(){
        Lotto lotto = new Lotto(List.of(6,3,4,2,1,5));
        Lotto winningLotto = new Lotto(List.of(4,5,6,7,8,10));

        assertThat(lotto.matchCountNumbers(winningLotto)).isEqualTo(3);
    }

    @Test
    @ParameterizedTest
    @ValueSource(strings = {"1000", "1200", "1990"})
    void 로또_구매_함수_테스트(String number){
        assertThat(new Purchase(new Money(number)).getLottoCount()).isEqualTo(1);
    }
    // 아래에 추가 테스트 작성 가능
}
