package lotto;

import lotto.domain.NumberGenerator;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {
    NumberGenerator generator;
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        generator = new NumberGenerator();
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("로또번호 List를 생성하고 크기는 6이다.")
    void 랜덤으로_로또번호_생성_테스트() {
        assertThat(generator.createDuplicateNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("중복되지 않는 로또번호 List를 생성하고 크기는 6이다.")
    void 랜덤으로_중복되지않는_숫자리스트_생성_테스트() {
        Set<Integer> set = new HashSet<>(generator.createDuplicateNumbers());
        assertThat(set.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 티켓에 숫자가 아닌 값 들어가면 IllegalArgumentException 발생한다.")
    void 당첨티켓_숫자가_아닌값일시_예외발생_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoService.separateInputWinningNumbers("1,3,5,7,9,!"));
    }

    @Test
    @DisplayName("당첨 티켓에 구분 값 , 이 아닌 다른 값 들어가면 IllegalArgumentException 발생한다.")
    void 당첨티켓_구분값_잘못_들어가면_예외발생_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoService.separateInputWinningNumbers("1,3,5,7,9.11"));
    }
}
