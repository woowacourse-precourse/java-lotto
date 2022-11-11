package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class UtilTest {

    @Test
    @DisplayName("숫자열인지 아닌지 판별한다.")
    void 숫자열_판별_테스트(){
        final String numberic = "123";
        assertThat(Util.isNumberic(numberic)).isTrue();

        final String minusNumberic = "-123";
        assertThat(Util.isNumberic(numberic)).isTrue();

        final String string = "123a";
        assertThat(Util.isNumberic(string)).isFalse();
    }

    @Test
    @DisplayName("1000으로 딱 나누어 떨어지는지 확인")
    void 나누어_떨어지는지_테스트(){
        final String canDividedBuyThousand = "3000";
        assertThat(Util.isDividedBuyThousand(canDividedBuyThousand))
                .isTrue();

        final String cantDividedBuyThousand = "4321";
        assertThat(Util.isDividedBuyThousand(cantDividedBuyThousand))
                .isFalse();
    }

    @Test
    @DisplayName("문자열에서 특정 문자의 갯수 확인")
    void 문자열에서_특정_문자_갯수_테스트(){

        final String fiveComma = "1,2,a,4,5,";
        assertThat(Util.countChar(fiveComma, ','))
                .isEqualTo(5);

        final String zeroComma = "1234";
        assertThat(Util.countChar(zeroComma, ','))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("문자열을 리스트로 잘 나누는지 확인")
    void 문자열을_리스트로_나눴는지_테스트(){

        final String numberic = "1,2,3,4";
        assertThat(Util.splitInteger(numberic, ","))
                .isEqualTo(List.of(1, 2, 3, 4));
    }


}