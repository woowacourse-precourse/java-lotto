package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.support.ErrorMessage.DUPLICATED_NUMBER_ERROR;
import static lotto.support.ErrorMessage.INVALID_NUMBER_COUNT_ERROR;
import static lotto.support.ErrorMessage.NEGATIVE_MONEY_ERROR;
import static lotto.support.ErrorMessage.NOT_DIVIDED_BY_LOTTO_PRICE_ERROR;
import static lotto.support.ErrorMessage.OUT_OF_RANGE_NUMBER_ERROR;
import static lotto.support.ErrorMessage.PARSE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ApplicationExceptionTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_번호가_숫자가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,asdf,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE + " " + PARSE_ERROR_MESSAGE
            );
        });
    }

    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("asdf");
            assertThat(output()).contains(ERROR_MESSAGE + " " + PARSE_ERROR_MESSAGE
            );
        });
    }

    @Test
    void 보너스_금액이_숫자가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,6", "asdf");
            assertThat(output()).contains(ERROR_MESSAGE + " " + PARSE_ERROR_MESSAGE
            );
        });
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE + " " + INVALID_NUMBER_COUNT_ERROR
            );
        });
    }

    @Test
    void 당첨_번호의_중복된_숫자가_있으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE + " " + DUPLICATED_NUMBER_ERROR);
        });
    }

    @Test
    void 보너스_번호가_로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE + " " + DUPLICATED_NUMBER_ERROR);
        });
    }

    @Test
    void 당첨_번호에_1_45_외의_숫자가_있으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,55");
            assertThat(output()).contains(ERROR_MESSAGE + " " + OUT_OF_RANGE_NUMBER_ERROR);
        });
    }

    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            run("1001");
            assertThat(output()).contains(ERROR_MESSAGE + " " + NOT_DIVIDED_BY_LOTTO_PRICE_ERROR);
        });
    }

    @Test
    void 구입_금액이_음수인_경우_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            run("-1000");
            assertThat(output()).contains(ERROR_MESSAGE + " " + NEGATIVE_MONEY_ERROR);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
