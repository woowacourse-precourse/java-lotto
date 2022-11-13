package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.io.ByteArrayInputStream;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 금액_예외_테스트1() {
        assertSimpleTest(() -> {
            runException("1123");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 금액_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("10001");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    Lotto generateRandomLotto() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object ret;
        Class app = Application.class;
        Method method = app.getDeclaredMethod("buyLotto");

        method.setAccessible(true);
        ret = method.invoke(null);
        return (Lotto) ret;
    }

    @Test
    void 랜덤_로또_객체_생성_테스트() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                Lotto lotto = generateRandomLotto();
                lotto.printNumbers();
                assertThat(output()).contains("[1, 2, 3, 4, 5, 6]");
            },
            List.of(1, 2, 3, 4, 5, 6)
        );
    }

    Lotto getWinningNumbers() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object ret;
        Class app = Application.class;
        Method method = app.getDeclaredMethod("getWinningNumbers");

        method.setAccessible(true);
        ret = method.invoke(null);
        return (Lotto) ret;
    }

    void stdInput(String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    void 당첨_번호_입력_테스트() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        stdInput("1,2,3,4,5,6");
        Lotto lotto = getWinningNumbers();
        lotto.printNumbers();
        assertThat(output()).contains("[1, 2, 3, 4, 5, 6]");
    }

    Integer getBonusNumber() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object ret;
        Class app = Application.class;
        Method method = app.getDeclaredMethod("getBonusNumber");

        method.setAccessible(true);
        ret = method.invoke(null);
        return (Integer) ret;
    }


    @Test
    void 보너스_번호_입력_테스트1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        stdInput("3");
        Integer number = getBonusNumber();
        assertThat(number).isEqualTo(3);
    }

    @Test
    void 보너스_번호_입력_테스트2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        stdInput("49");
        assertThatThrownBy(
            () -> {
                try {
                    getBonusNumber();
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                }
            }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_입력_테스트3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        stdInput("0");
        assertThatThrownBy(
            () -> {
                try {
                    getBonusNumber();
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                }
            }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_입력_테스트4() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        stdInput("sssss");
        assertThatThrownBy(
            () -> {
                try {
                    getBonusNumber();
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                }
            }).isInstanceOf(IllegalArgumentException.class);
    }

    void startLottery(List<Lotto> lottoList) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class app = Application.class;
        Class args[] = new Class[1];
        args[0] = List.class;

        Object[] params = new Object[1];
        params[0] = lottoList;

        Method method = app.getDeclaredMethod("startLottery", args);
        method.setAccessible(true);
        method.invoke(null, params);
    }

    @Test
    void 보너스_번호_중복_예외_테스트() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        stdInput("1,2,3,4,5,6", "1");
        assertThatThrownBy(
            () -> {
                try {
                    startLottery(List.of());
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                }
            }).isInstanceOf(IllegalArgumentException.class);
    }

    Integer[] getResult(List<Lotto> lottoList, Lotto winning, Integer bonusNumber) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class app = Application.class;
        Class args[] = new Class[3];
        args[0] = List.class;
        args[1] = Lotto.class;
        args[2] = Integer.class;

        Object[] params = new Object[3];
        params[0] = lottoList;
        params[1] = winning;
        params[2] = bonusNumber;

        Method method = app.getDeclaredMethod("getResult", args);
        method.setAccessible(true);
        return (Integer[]) method.invoke(null, params);
    }

    @Test
    void 추첨_결과_테스트() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Integer[] result = getResult(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(11, 12, 13, 14, 15, 17))
            ), new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        assertThat(result).containsExactly(1, 1, 0, 0, 0, 1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
