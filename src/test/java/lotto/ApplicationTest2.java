package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationTest2 extends NsTest {
    Application app = new Application();
    private static final String ERROR_MESSAGE = "[ERROR]";

  
    @Test
    public void winningNumberDuplicateTest(){
        assertThrows(IllegalArgumentException.class, () -> {
                    new WinningNumbers("1,2,4,5,6,6");
                }
        );
    }

    @Test
    public void winningNumberNotNumberTest(){
        assertThrows(IllegalArgumentException.class, () -> {
                    new WinningNumbers("1,2,jj,5,6,6");
                }
        );
    }

    @Test
    public void winningNumberNotInRangeTest(){
        assertThrows(IllegalArgumentException.class, () -> {
                    new WinningNumbers("1,2,88,5,7,6");
                }
        );
    }

    @Test
    public void checkLottoIsSorted(){
        Lotto lotto = new Lotto(List.of(5,3,7,10,8,45));
        assertThat(lotto.getSortedLottoNumbers()).containsExactly(3,5,7,8,10,45);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
