package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberWriteServiceTest {

    private MemberWriteService service = new MemberWriteService();

    @Test
    @DisplayName("유효한 데이터를 입력하여 테스트 성공")
    void writePay_success() {
        // given
        String writePay = "8000";
        int expectedPay = 8000;

        // when
        int pay = service.writePay(writePay);

        // then
        assertThat(pay).isEqualTo(expectedPay);
    }

    @Test
    @DisplayName("유효하지 않은 데이터를 입력하여 예외 발생")
    void writePay_throw_IllegalArgumentException() {
        // given
        String writePay = "8000원";

        // when && then
        assertThatThrownBy(() -> service.writePay(writePay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This Lotto Number is Exception !!");
    }


}