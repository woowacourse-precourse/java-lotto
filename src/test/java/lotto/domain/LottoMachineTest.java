package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("LottoMachineTest 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoMachineTest {

    @Test
    void 생성자는_로또당첨번호와_보너스번호를_입력받는다() {
        LottoMachine lottoMachine = new LottoMachine(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7));
        assertThat(lottoMachine).isInstanceOf(LottoMachine.class);
    }

    @Test
    void check_메서드는_lottoTicket을_입력받아_lottoTicket의_check_메서드를_호출한다() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusNumber);
        LottoTicket lottoTicket = mock(LottoTicket.class);

        lottoMachine.check(lottoTicket);

        verify(lottoTicket, only()).check(winningNumbers, bonusNumber);
    }
}
