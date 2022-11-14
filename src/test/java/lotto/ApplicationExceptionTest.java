package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ApplicationExceptionTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_번호가_숫자가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,asdf,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE + " 올바른 입력이 아닙니다."
            );
        });
    }

    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("asdf");
            assertThat(output()).contains(ERROR_MESSAGE + " 올바른 입력이 아닙니다."
            );
        });
    }

    @Test
    void 보너스_금액이_숫자가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,6", "asdf");
            assertThat(output()).contains(ERROR_MESSAGE + " 올바른 입력이 아닙니다."
            );
        });
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE + " 당첨 번호는 6개여야 합니다."
            );
        });
    }

    @Test
    void 당첨_번호의_중복된_숫자가_있으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE + " 중복된 당첨 번호가 존재합니다.");
        });
    }

    @Test
    void 보너스_번호가_로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE + " 중복된 당첨 번호가 존재합니다.");
        });
    }

    @Test
    void 당첨_번호에_1_45_외의_숫자가_있으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,55");
            assertThat(output()).contains(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            run("1001");
            assertThat(output()).contains(ERROR_MESSAGE + " 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        });
    }

    @Test
    void 구입_금액이_음수인_경우_예외를_발생시킨다() {
        assertSimpleTest(() -> {
            run("-1000");
            assertThat(output()).contains(ERROR_MESSAGE + " 구입 금액은 음수일 수 없습니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
