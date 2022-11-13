package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.ui.LottoConsole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    private LottoService lottoService;
    private LottoConsole lottoConsole;

    @BeforeEach
    void setUp() {
        lottoConsole = new LottoConsole();
        lottoService = new LottoService(lottoConsole);
    }

    @Nested
    @DisplayName("사용자 로또 생성 관련 테스트")
    class UsersLottoFeature{

//        @Test
//        @DisplayName("특정 금액에 맞게 로또 리스트 생성됐는지 확인")
//        void publishLottos(){
//            userLottoInfo.setLottoPrice(8000);
//            lottoService.publishLottos();
//            assertThat(userLottoInfo.getUserLotto().size()).isEqualTo(8);
//        }
    }
}