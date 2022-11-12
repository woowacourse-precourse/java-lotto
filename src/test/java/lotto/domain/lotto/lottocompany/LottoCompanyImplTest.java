package lotto.domain.lotto.lottocompany;

import java.util.List;
import lotto.domain.lotto.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCompanyImplTest {

    @Test
    @DisplayName("로또 회사는 로또 발행 개수만큼 로또를 발행한다.")
    void publishNLottoTest() {
        //given
        LottoCompany lottoCompany = new LottoCompanyImpl(new LottoMachineImpl());
        int publishLottoCount = 5;

        //when
        List<Lotto> publishNLotto = lottoCompany.publishNLotto(publishLottoCount);

        //then
        Assertions.assertThat(publishNLotto.size()).isEqualTo(publishLottoCount);
    }
}
