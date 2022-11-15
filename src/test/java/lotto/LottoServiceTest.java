package lotto;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.util.ArgumentExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/15
 */
public class LottoServiceTest {
    @DisplayName("구매 금액이 로또 구매금액으로 나누어 떨어지 않는 경우, 예외가 발생한다.")
    @Test
    void divideLottoPriceByNotMultipleLottoPrice() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toPurchaseAmount("9100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_PURCHASE_AMOUNT_UNCONFORMABLE_VALUE.getMessage());
    }

    @DisplayName("구매 금액이 정수가 아닌 경우, 예외가 발생한다.")
    @Test
    void divideLottoPriceByNotInteger() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toPurchaseAmount("900a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_NOT_INTEGER.getMessage());
    }

    @DisplayName("구매 금액이 로또 구매금액으로 나누어 떨어지는 경우 정상 동작한다.")
    @Test
    void  divideLottoPrice() {
        LottoService lottoService = new LottoService();
        assertThat(lottoService.toPurchaseAmount("9000")).isEqualTo(9);
    }

    @DisplayName("로또 당첨 번호가 정수가 아닌경우, 예외가 발생한다.")
    @Test
    void toLottoByNotInteger() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toLotto("a,b,c,d,e,f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_LOTTO_UNCONFORMABLE_FROM.getMessage());
    }

    @DisplayName("로또 당첨 번호가 올바르지 않은 형식인 경우, 예외가 발생한다.")
    @Test
    void toLottoByUnconformableForm() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toLotto("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_LOTTO_UNCONFORMABLE_FROM.getMessage());
    }

    @DisplayName("로또 당첨 번호의 길이가 로또 번호 개수와 다른 경우, 예외가 발생한다.")
    @Test
    void toLottoByOutOfLength() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toLotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_LOTTO_UNCONFORMABLE_LENGTH.getMessage());
    }

    @DisplayName("로또 당첨 번호에 중복이 존재하는 경우, 예외가 발생한다.")
    @Test
    void toLottoByOverLap() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toLotto("1,2,3,4,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_LOTTO_NUMBER_OVERLAP.getMessage());
    }

    @DisplayName("로또 당첨 번호가 알맞은 번호인 경우, 정상 동작한다.")
    @Test
    void  toLotto() {
        LottoService lottoService = new LottoService();
        assertThat(lottoService.toLotto("1,2,3,4,5,6"))
                .usingRecursiveComparison().isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));    // usingRecursiveComparison, 내부의 필드들을 모두 비교한다.(재귀) 내부 필드 값만 같다면, 오브젝트가 달라도 테스트 통과
    }

    @DisplayName("보너스 번호가 로또 번호의 범위를 벗어나는 경우, 예외가 발생한다.")
    @Test
    void  toBonusNumberByOutOfRange() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toBonusNumber("46", new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_LOTTO_UNCONFORMABLE_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 정수형이 아닌 경우, 예외가 발생한다.")
    @Test
    void  toBonusNumberByNotInteger() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toBonusNumber("a", new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_NOT_INTEGER.getMessage());
    }

    @DisplayName("보너스 번호가 당첨번호와 중복되는 경우, 예외가 발생한다.")
    @Test
    void  toBonusNumberByOverlap() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toBonusNumber("6", new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_LOTTO_NUMBER_OVERLAP.getMessage());
    }

    @DisplayName("보너스 번호가 알맞은 번호인 경우, 정상 동작한다.")
    @Test
    void  toBonusNumber() {
        LottoService lottoService = new LottoService();
        assertThat(lottoService.toBonusNumber("7", new Lotto(List.of(1,2,3,4,5,6)))).isEqualTo(7);

    }
}
