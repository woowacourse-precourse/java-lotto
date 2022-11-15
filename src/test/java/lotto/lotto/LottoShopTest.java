package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import lotto.setting.LottoSetting;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LottoShopTest {

    @Test
    void throwExceptionTest_whenPriceIsNotDivided() {
        LottoSetting lottoSetting = mock(LottoSetting.class);

        assertThrows(IllegalArgumentException.class, () -> {
            new LottoShop(1000, lottoSetting).buyLotto(5100);
        });
    }

    @Test
    void notThrowExceptionTest_whenPriceIsDivided() {
        LottoSetting lottoSetting = mock(LottoSetting.class);

        assertThatCode(() -> {
            new LottoShop(1000, lottoSetting).buyLotto(5000);
        }).doesNotThrowAnyException();
    }

    @Test
    void buyLottoTest_IsListSizeMatched() {
        LottoSetting lottoSetting = mock(LottoSetting.class);

        List<Lotto> result = new LottoShop(1000, lottoSetting).buyLotto(5000);

        assertThat(result.size() == 5).isEqualTo(true);
    }

    @Test
    void getLottoInfoTest() {
        Lotto lotto = mock(Lotto.class);
        when(lotto.getNumbers()).thenReturn("[1, 2, 3, 4, 5, 6]");
        List<Lotto> lottos = List.of(lotto, lotto);
        LottoSetting lottoSetting = mock(LottoSetting.class);
        String expect = "\n2개를 구매했습니다.\n" +
                "[1, 2, 3, 4, 5, 6]" +
                "[1, 2, 3, 4, 5, 6]";

        String result = new LottoShop(1000, lottoSetting).getLottoInfo(lottos);
    }
}
