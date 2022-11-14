package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.LottoIssueService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBoothTest {

    @Test
    void 로또_티켓_발급_테스트() {
        int lottoCount = 10;
        LottoTicket lottoTicket = LottoIssueService.issueLottoTicket(lottoCount);
        assertThat(lottoTicket.getLottoTicket().size()).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("0개 발급 요청시에는 ERROR 처리")
    void 로또_티켓_0개_발급_테스트() {
        int lottoCount = 0;
        assertThatThrownBy(() -> LottoIssueService.issueLottoTicket(lottoCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}