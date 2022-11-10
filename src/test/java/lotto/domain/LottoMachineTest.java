package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
        LottoMachine lottoMachine = new LottoMachine(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoMachine).isInstanceOf(LottoMachine.class);
    }
}
