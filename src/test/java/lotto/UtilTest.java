package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class UtilTest {

    @Test
    void 숫자열_판별_테스트(){
        String numberic = "123";
        assertThat(Util.isNumberic(numberic)).isTrue();

        String string = "123a";
        assertThat(Util.isNumberic(string)).isFalse();
    }


}