package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

    @Test
    @DisplayName("구매 금액 변환 테스트")
    public void convertTest() throws Exception{
        Integer convertNumber = Convert.costConvert("1234");
        Assertions.assertThat(convertNumber).isEqualTo(1234);
    }
}