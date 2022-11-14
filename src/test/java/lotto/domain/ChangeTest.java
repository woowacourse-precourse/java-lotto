package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ChangeTest {
    @DisplayName("입력된 당첨 번호 문자열이 로또 번호로 정상적으로 변환되는지 확인한다.")
    @Test
    void lottoNumberTest_정상동작(){
        List<Integer> input = Change.lottoNumber("1,2,3,4,5,6");
        assertThat(input).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

}