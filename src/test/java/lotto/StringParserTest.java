package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.LinkedList;
import java.util.List;
import lotto.utils.StringParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringParserTest {

    @DisplayName("로또는 콤마로 구별되어 List로 파싱된다.")
    @Test
    void 파싱_테스트() {
        String input = "1,2,3";
        assertThat(StringParser.stringToIntegerList(input))
                .containsExactly(1, 2, 3);

    }
}
