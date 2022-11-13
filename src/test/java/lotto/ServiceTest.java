package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ServiceTest {

    private Service service;

    @BeforeEach
    void setUp() {
        service = new Service();
    }

    @DisplayName("문자열을 정수로 변경시키는 메서드 테스트 - 성공")
    @Test
    void stringToIntTest_success() {
        assertThat(service.stringToInt("1234")).isEqualTo(1234);
    }

    @DisplayName("문자열을 정수로 변경시키는 메서드 테스트 - 예외")
    @Test
    void stringToIntTest_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> service.stringToInt("1로또234"));
    }

    @DisplayName("1000으로 나눠 값을 반환하는 메서드 - 성공")
    @Test
    void numberOfLotteryTest_success() {
        assertThat(service.numberOfLottery(20000)).isEqualTo(20);
    }

    @DisplayName("1000으로 나눠 값을 반환하는 메서드 - 예외")
    @Test
    void numberOfLotteryTest_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> service.numberOfLottery(20001));
    }
}
