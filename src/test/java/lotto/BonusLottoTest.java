package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.model.resources.BonusLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BonusLottoTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 클래스가_잘_돌아가는지_테스트() {
        String result = "7";
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        BonusLotto bonusLotto = BonusLotto.of(result, lotto);
        Assertions.assertThat(bonusLotto.getBonusNum()).isEqualTo(Integer.parseInt(result));
    }

    @Test
    void 보너스로또_클래스_터뜨리기_중복() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스로또_클래스_터뜨리기_범위() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "99");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스로또_클래스_터뜨리기_콤마() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", ",");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스로또_클래스_터뜨리기_한글() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,7,6","우테코");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스로또_클래스_터뜨리기_영어() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,7,6","r");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}