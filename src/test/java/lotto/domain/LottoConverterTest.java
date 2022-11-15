package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("로또 번호 변환 메서드 테스트")
@TestMethodOrder(OrderAnnotation.class)
class LottoConverterTest {

    private LottoConverter converter;

    @BeforeEach
    void testSetting(){
        converter = new LottoConverter();
    }

    @Order(1)
    @DisplayName("불규칙 순서의 String List Converter")
    @Test
    void convertScanNumbersToWinningNumbersTest() {
        List<String> inputValue = List.of("13", "4", "17", "41", "3", "1");

        assertThat(converter.convertScanNumbersToWinningNumbers(inputValue))
                .isEqualTo(List.of(1, 3, 4, 13, 17, 41));
    }

    @Order(2)
    @DisplayName("랜덤 번호를 로또 객체로 변환")
    @Test
    void convertRandomNumbersToLottoTest() {
        List<Integer> inputValue = List.of(4, 31, 13, 16, 3, 42);
        Lotto convertedLotto = converter.convertRandomNumbersToLotto(inputValue) ;
        Lotto compareLotto = new Lotto(List.of(3, 4, 13, 16, 31, 42));
        assertThat(convertedLotto)
                .isInstanceOf(Lotto.class);
        assertThat(convertedLotto.toString()).isEqualTo(compareLotto.toString());

    }

    @Order(3)
    @DisplayName("보너스 번호 입력값 정수형 값 변환")
    @Test
    void convertBonusTest() {
        assertThat(converter.convertBonus("17")).isEqualTo(17);
    }

    @Order(4)
    @DisplayName("금액 입력값 정수형 값 변환")
    @Test
    void convertMoneyTest() {
        assertThat(converter.convertMoney("1,234,000  ")).isEqualTo(1234000);
    }
}