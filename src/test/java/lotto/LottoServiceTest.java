package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.UserLottoInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    private LottoService lottoService;
    private UserLottoInfo userLottoInfo;

    @BeforeEach
    void setUp() {
        userLottoInfo = new UserLottoInfo();
        lottoService = new LottoService(userLottoInfo);
    }

    @Nested
    @DisplayName("구입 금액 입력 테스트")
    class InputFeature {

        @Test
        @DisplayName("숫자 형식 아니면 예외 발생")
        void inputNonNumeric() {
            String input = "abc01";
            assertThatThrownBy(() -> {
                lottoService.inputLottoPrice(input);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 형식의 금액을 입력하셨습니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"1234", "7890", "2500", "10001"})
        @DisplayName("1000의 배수가 아니면 예외 발생")
        void inputNonMultiplesof1000(String input) {
            assertThatThrownBy(() -> {
                lottoService.inputLottoPrice(input);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 형식의 금액을 입력하셨습니다.");
        }

        @ParameterizedTest
        @CsvSource(value = {"10000:10000", "14000:14000", "8000:8000"}, delimiter = ':')
        @DisplayName("정상 입력 시, Lotto 정보 저장")
        void validInput(String input, Integer expected) {
            lottoService.storeLottoPrice(lottoService.inputLottoPrice(input));
            assertThat(userLottoInfo.getLottoPrice()).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("사용자 로또 생성 관련 테스트")
    class UsersLottoFeature{

        @Test
        @DisplayName("특정 금액에 맞게 로또 리스트 생성됐는지 확인")
        void publishLottos(){
            userLottoInfo.setLottoPrice(8000);
            lottoService.publishLottos();
            assertThat(userLottoInfo.getUserLotto().size()).isEqualTo(8);
        }
    }
}