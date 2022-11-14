package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGameServiceTest {

    private LottoGameService lottoGameService;

    @BeforeEach
    void init() {
        this.lottoGameService = new LottoGameService();
    }

    @DisplayName("구입 금액에 맞춰 구매 가능한 로또 갯수를 반환한다.")
    @Test
    void buyLottoTickets() {
        int expect = 8;
        String purchaseAmount = "8000";
        int actual = lottoGameService.buyLottoTickets(purchaseAmount);
        assertThat(expect).isEqualTo(actual);
    }

    @DisplayName("구입 금액이 숫자가 아니라면 예외가 발생한다.")
    @CsvSource({"가나", "sdg", "1가3"})
    @ParameterizedTest
    void buyLottoTicketsNotNumber(String input) {
        assertThatThrownBy(() -> lottoGameService.buyLottoTickets(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 비어있다면 예외가 발생한다.")
    @Test
    void buyLottoTicketsIsEmpty() {
        assertThatThrownBy(() -> lottoGameService.buyLottoTickets(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000단위로 나누어 떨어지지 않는다면 예외가 발생한다.")
    @CsvSource({"1200", "123", "1000001"})
    @ParameterizedTest
    void buyLottoTicketsDivide1000Won(String input) {
        assertThatThrownBy(() -> lottoGameService.buyLottoTickets(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 6자리이며 ','를 구분해 나눈다.")
    @Test
    void pickWinningNumbers() {
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        String input = "1,2,3,4,5,6";
        Lotto actual = lottoGameService.pickWinningNumbers(input);
        assertThat(expect).isEqualTo(actual.getNumbers());
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @CsvSource({"가,나,다,라,마,바,사", "1,2,3,4,가", "1가3,gkgk"})
    @ParameterizedTest
    void pickWinningNumbersNotNumber(String input) {
        assertThatThrownBy(() -> lottoGameService.pickWinningNumbers(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @CsvSource({"가나", "abs"})
    @ParameterizedTest
    void pickBonusNumberNotNumber(String input) {
        assertThatThrownBy(() -> lottoGameService.pickBonusNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호 숫자와 겹치면 예외가 발생한다.")
    @CsvSource({"1", "2", "3", "4", "5", "6"})
    @ParameterizedTest
    void pickBonusNumberOverlap(String input) {
        lottoGameService.pickWinningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoGameService.pickBonusNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @CsvSource({"-1", "46", "100"})
    @ParameterizedTest
    void pickBonusNumberOutRange(String input) {
        assertThatThrownBy(() -> lottoGameService.pickBonusNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
