package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 당첨번호_영어입력_예외테스트() {
        assertSimpleTest(() -> {
            run("5000", "ab");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_영어숫자_혼합입력_예외테스트() {
        assertSimpleTest(() -> {
            run("5000", "1,a,b");
            assertThat(output()).contains(ERROR_MESSAGE + " 당첨 번호는 구분자로 구분된 숫자로 입력되어야합니다.");
        });
    }

    @Test
    void 당첨번호_숫자_6개_미입력_예외테스트() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5");
            assertThat(output()).contains("[ERROR] 1장의 로또에서 6개의 번호가 생성되지 않았습니다.");
        });
    }

    @Test
    void 당첨번호_숫자_중복_예외테스트() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5,5");
            assertThat(output()).contains("[ERROR] 1장의 로또에서 6개의 번호가 중복되지 않아야합니다.");
        });
    }

    @Test
    void 당첨번호_숫자_범위_예외테스트() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,55,6");
            assertThat(output()).contains("[ERROR] 로또의 숫자는 1 ~ 45 사이의 숫자여야합니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
