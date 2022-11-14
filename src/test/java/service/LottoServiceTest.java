package service;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import view.OutputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("로또 발행 검사")
    @ParameterizedTest
    @CsvSource(value = {"11000,11", "5000,5", "1000,1"})
    public void 로또_발행_수량_확인(int purchaseAmount, int count) {
        lottoService.publishLotto(purchaseAmount);
        List<Lotto> publishedLotto = lottoService.getPublishedLotto();

        OutputView.noticePublishedLotto(publishedLotto);

        assertThat(publishedLotto.size()).isEqualTo(count);
    }

}
