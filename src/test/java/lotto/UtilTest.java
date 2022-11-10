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


}