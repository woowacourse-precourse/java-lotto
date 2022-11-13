package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    private static List<Integer> lottoNumberList;

    @Test
    void 로또_랜덤숫자_생성() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumberList = lottoNumbers.setRandomNumbers();

        assertThat(lottoNumberList.size()).isEqualTo(6);
    }
}