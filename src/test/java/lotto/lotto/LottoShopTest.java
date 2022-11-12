package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import lotto.setting.LottoSetting;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LottoShopTest {

    @Test
    void throwExceptionTest_whenPriceIsNotDivided() {
        LottoSetting lottoSetting = mock(LottoSetting.class);

        assertThrows(IllegalArgumentException.class, () -> {
            new LottoShop(1000, lottoSetting).buyLottoCreatedAuto(5100);
        });
    }

    @Test
    void notThrowExceptionTest_whenPriceIsDivided() {
        LottoSetting lottoSetting = mock(LottoSetting.class);

        assertThatCode(() -> {
            new LottoShop(1000, lottoSetting).buyLottoCreatedAuto(5000);
        }).doesNotThrowAnyException();
    }

    @Test
    void buyLottoTest_IsListSizeMatched() {
        LottoSetting lottoSetting = mock(LottoSetting.class);

        List<Lotto> result = new LottoShop(1000, lottoSetting).buyLottoCreatedAuto(5000);

        assertThat(result.size() == 5).isEqualTo(true);
    }
}
