package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckTest extends NsTest {


    @Test
    void 로또_당첨_숫자_개수_테스트_countTmpCounter(){
        Lotto lottoArray = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userInputLottoNumber = new Lotto(List.of(1,2,4,6,9,10));

        int InputResult = Check.countTmpCounter(lottoArray, userInputLottoNumber);

        assertThat(InputResult).isEqualTo(4);
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
