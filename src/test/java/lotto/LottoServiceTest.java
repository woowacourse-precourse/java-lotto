package lotto;

import domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    public void makeLottoService() {
        this.lottoService = new LottoService();
    }

    @Test
    @DisplayName("당첨 로또 숫자가 1에서 45사이가 아니라면 예외가 발생한다.")
    public void makeLottoNotUsingOneToFortyFive() {
        String input = "1,-1,30,26,33,20";
        assertThatThrownBy(() -> lottoService.makeLottoFromInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 숫자가 구분자가 ','이 아니라면 예외가 발생한다.")
    public void makeLottoNotUsingTarget() {
        String input = "1,-1,30,26,33/20";
        assertThatThrownBy(() -> lottoService.makeLottoFromInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 숫자가 서로 유일하지 않다면 예외가 발생한다.")
    public void makeLottoNotUsingUniqueNumber() {
        String input = "1,-1,30,26,33,30";
        assertThatThrownBy(() -> lottoService.makeLottoFromInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}