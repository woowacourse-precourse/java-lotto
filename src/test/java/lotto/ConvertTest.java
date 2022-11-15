package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

    @Test
    @DisplayName("구매 금액 변환 테스트")
    public void convertTest() throws Exception{
        Integer convertNumber = Convert.costConvert("1234");
        Assertions.assertThat(convertNumber).isEqualTo(1234);
    }
    @Test
    @DisplayName("당첨 번호 변환 테스트 ")
    public void winningConvert() throws Exception{
        Lotto lotto = Convert.winningConvert("1,2,3,4,5,6");
        Assertions.assertThat(lotto.getNumbers().get(0)).isEqualTo(1);
        Assertions.assertThat(lotto.getNumbers().get(1)).isEqualTo(2);
        Assertions.assertThat(lotto.getNumbers().get(2)).isEqualTo(3);
        Assertions.assertThat(lotto.getNumbers().get(3)).isEqualTo(4);
        Assertions.assertThat(lotto.getNumbers().get(4)).isEqualTo(5);
        Assertions.assertThat(lotto.getNumbers().get(5)).isEqualTo(6);
    }
    @Test
    @DisplayName("보너스 번호 변환 테스트 ")
    public void bonusConvert() throws Exception{
        Assertions.assertThat(Convert.bonusConvert("7",new Lotto(List.of(1,2,3,4,5,6)))).isEqualTo(7);


    }
}