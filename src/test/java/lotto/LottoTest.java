package lotto;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.presentation.LottoController;
import lotto.domain.lotto.verifier.InputNumberVerifier;
import lotto.domain.user.domain.User;
import lotto.domain.user.presentation.UserController;
import lotto.domain.user.service.UserService;
import lotto.global.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("로또 구입 가격을 1000원 단위로 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputLottoBuyPriceOnlyUnit1000() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.add(lotto);
        assertThatThrownBy(() -> new User(1100, lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자가 1~45 범위 밖의 숫자이면 예외가 발생한다.")
    @Test
    void isNumberFrom1To45() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자의 개수가 1개가 아니면 예외가 발생한다.")
    @Test
    void bonusNumberOnly1() {
        assertThatThrownBy(() -> InputNumberVerifier.bonusNumberVerifier(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "7,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("뽑은 당첨 번호와 중복되는 수를 뽑으면 예외가 발생한다.")
    @Test
    void dontDuplicatePrizeNumber() {
        assertThatThrownBy(() -> InputNumberVerifier.bonusNumberVerifier(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 1~45 범위 밖의 숫자이면 예외가 발생한다.")
    @Test
    void isBonusNumberFrom1To45() {
        assertThatThrownBy(() -> InputNumberVerifier.bonusNumberVerifier(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원을 투자하고 숫자 4개 일치시 수익률은 50000.00%이다.")
    @Test
    void isBenefit5000Percent() {
        // given
        LottoController lottoController = new LottoController();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lotto prizeLotto = new Lotto(List.of(1, 2, 3, 4, 21, 22));
        int bonusNumber = 44;

        // when
        Double benefit = lottoController.compareNumbers(lottos, prizeLotto, bonusNumber);

        // then
        assertEquals(benefit, 50000.00);
    }

    @DisplayName("로또 숫자 입력시 오름차순 정렬이 되야한다.")
    @Test
    void test() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1));

        // when
        List<Integer> orderByAscNumbers = Util.orderByDescForList(numbers);

        // then
        assertEquals(orderByAscNumbers, List.of(1, 2, 3, 4, 5, 6));
    }
}
