package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.UserInterfaceMessage;
import org.junit.jupiter.api.Test;

class LottoInputDrawNumberServiceTest {
    @Test
    void 잘못된_당첨_번호_형식() {
        String DrawNumber = "1, 2, 3, a, 5";
        assertThatThrownBy(() -> LottoInputDrawNumberService.getInstance().saveDrawNumber(DrawNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(UserInterfaceMessage.ERROR_NUMBER_INCLUSIVE.getValue(),
                        LottoNumberInclusive.START.getValue(), LottoNumberInclusive.END.getValue()));
    }

    @Test
    void 당첨_번호_개수_잘못_입력() {
        String DrawNumber = "1, 2, 3, 4, 5, 6, 7";
        assertThatThrownBy(() -> LottoInputDrawNumberService.getInstance().saveDrawNumber(DrawNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInterfaceMessage.ERROR_PREFIX.getValue()
                        + String.format(UserInterfaceMessage.REQUEST_INPUT_PRICE_INFO.getValue(),
                        LottoNumberInclusive.START.getValue(), LottoNumberInclusive.END.getValue()));
    }

    @Test
    void 당첨_번호_입력_개수_체크() {
        String DrawNumber = "1, 2, 3, 4, 5, 6";
        LottoInputDrawNumberService lottoInputDrawNumberService = LottoInputDrawNumberService.getInstance();
        lottoInputDrawNumberService.saveDrawNumber(DrawNumber);
        assertThat(lottoInputDrawNumberService.getLottoDrawNumber().size()).isEqualTo(
                Arrays.stream(DrawNumber.replace(" ","")
                        .split(",")).count());
    }

}