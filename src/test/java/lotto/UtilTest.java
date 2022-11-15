package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilTest {

    @DisplayName("숫자 판별 메서드 테스트 성공 케이스")
    @Test
    void isNumberTest1() {
        String[] str = {"100", "1", "0", "9999", "51647"};

        for (int i = 0; i < str.length; i++) {
            boolean check = Util.isNumber(str[i]);
            assertThat(check).isTrue();
        }
    }

    @DisplayName("숫자 판별 메서드 테스트 실패 케이스")
    @Test
    void isNumberTest2() {
        String[] str = {"love", "2l2", "ok", "test"};

        for (int i = 0; i < str.length; i++) {
            int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> {
                Util.isNumber(str[finalI]);
            });
        }
    }

    @DisplayName("1000으로 나누어지는 숫자인지 메서드 성공 테스트")
    @Test
    void isDivisionByThousandTest1() {
        int[] intArr = {1000,2000,3000,15000,6000,175000};

        for (int i = 0; i < intArr.length; i++) {
            assertThat(Util.isDivisionByThousand(intArr[i])).isTrue();
        }
    }

    @DisplayName("1000으로 나누어지는 숫자인지 메서드 실패 테스트")
    @Test
    void isDivisionByThousandTest2() {

        int[] intArr = {1010,20,3003,15500,6001,999, 0};

        for (int i = 0; i < intArr.length; i++) {
            assertThat(Util.isDivisionByThousand(intArr[i])).isFalse();
        }
    }

}
