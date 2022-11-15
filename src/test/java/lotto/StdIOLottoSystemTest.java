package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StdIOLottoSystemTest {
    private LottoMetadata metadata;
    private LottoSystem system;

    @BeforeEach
    void beforeEach() {
        metadata = new LottoMetadata.Builder().build();
        system = new StdIOLottoSystem(metadata);

    }

    @AfterEach
    void afterEach() {
        System.setIn(System.in);
    }

    @DisplayName("구입 금액을 입력값과 메서드의 반환값이 같다.")
    @Test
    void askFeeFromUser() {
        String input = "12000";
        final byte[] inBuf = input.getBytes();
        OutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));
        System.setIn(new ByteArrayInputStream(inBuf));

        system.askFeeFromUser();

        assertThat(outBuf.toString().trim()).isEqualTo("구입금액을 입력해 주세요.");
        assertThat(((StdIOLottoSystem)system).getPayment()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("지불금액이 로또 가격으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void remainderIsNotZero() {
        Integer payment = 12300;
        assertThatThrownBy(() -> system.purchaseMultipleLotto(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행된 로또 수는 지불한 금액 나누기 로또 가격과 같다.")
    @Test
    void purchaseMultiple() {
        Integer payment = 12000;

        List<Lotto> lottos = system.purchaseMultipleLotto(payment);

        assertThat(lottos.size()).isEqualTo(payment / metadata.getPriceOfLotto());
    }

    @DisplayName("발행된 로또는 잘 출력되어야한다.")
    @Test
    void printTest() {
        Integer payment = 12000;
        assertRandomUniqueNumbersInRangeTest(
                ()-> {
                    OutputStream outBuf = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(outBuf));
                    List<Lotto> lottos = system.purchaseMultipleLotto(payment);
                    system.showMultipleLotto(lottos);
                    String output = outBuf.toString().trim();
                    assertThat(output).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 4, 6, 13, 15]",
                            "[3, 14, 21, 22, 25, 45]",
                            "[9, 10, 11, 22, 33, 44]",
                            "[1, 2, 3, 4, 5, 6]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 13, 4, 15, 6),
                List.of(21, 3, 25, 14, 22, 45),
                List.of(44, 33, 22, 11, 10, 9),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("당첨 번호의 입력 숫자와 당첨 번호로 만들어진 로또의 숫자는 같다.")
    @Test
    void setNumbers() {
        String input = "1,2,3,4,5,36\n7";
        final byte[] inBuf = input.getBytes();
        OutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));
        System.setIn(new ByteArrayInputStream(inBuf));

        system.setNumbersByUser();

        assertThat(outBuf.toString().trim()).contains(
                "당첨 번호를 입력해 주세요.",
                "보너스 번호를 입력해 주세요."
        );
        assertThat(((StdIOLottoSystem)system).getWinningNumber().getNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 36));
    }

    @DisplayName("당첨 번호의 입력 숫자가 형식에 맞지 않으면 예외가 발생한다.")
    @Test
    void setNumbersNotMatchFormat() {
        String input = "1,2,3,4,5,,6\n7";
        final byte[] inBuf = input.getBytes();
        OutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));
        System.setIn(new ByteArrayInputStream(inBuf));

        assertThatThrownBy(system::setNumbersByUser)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 형식에 맞지않습니다. 숫자와 구분자만 올 수 있습니다.");
    }

    @DisplayName("당첨 번호의 입력 숫자에 숫자와 구분자 이외의 문자가 있으면 예외가 발생한다.")
    @Test
    void setNumbersIncludedOtherChar() {
        String input = "1,2,3,4,5,a\n7123";
        final byte[] inBuf = input.getBytes();
        OutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));
        System.setIn(new ByteArrayInputStream(inBuf));

        assertThatThrownBy(system::setNumbersByUser)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 형식에 맞지않습니다. 숫자와 구분자만 올 수 있습니다.");
    }

    @DisplayName("당첨 번호의 입력 숫자가 범위 밖에 있으면 예외가 발생한다.")
    @Test
    void setNumbersOutOfRange() {
        String input = "1,2,3,4,57,6\n70";
        final byte[] inBuf = input.getBytes();
        OutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));
        System.setIn(new ByteArrayInputStream(inBuf));

        Integer startNumber = metadata.getStartNumber();
        Integer endNumber = metadata.getEndNumber();

        assertThatThrownBy(system::setNumbersByUser)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] " + startNumber + "~" + endNumber + "인 수만 입력할 수 있습니다.");
    }

    @DisplayName("보너스 번호의 입력 숫자가 범위 밖에 있으면 예외가 발생한다.")
    @Test
    void setNumbersBonusOutOfRange() {
        String input = "1,2,3,4,5,6\n72";
        final byte[] inBuf = input.getBytes();
        OutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));
        System.setIn(new ByteArrayInputStream(inBuf));

        Integer startNumber = metadata.getStartNumber();
        Integer endNumber = metadata.getEndNumber();

        assertThatThrownBy(system::setNumbersByUser)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] " + startNumber + "~" + endNumber + "인 수만 입력할 수 있습니다.");
    }

    @DisplayName("보너스 번호의 입력 숫자가 수가 아니면 예외가 발생한다.")
    @Test
    void setNumbersBonusNotNumber() {
        String input = "1,2,3,4,5,6\na";
        final byte[] inBuf = input.getBytes();
        OutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));
        System.setIn(new ByteArrayInputStream(inBuf));

        assertThatThrownBy(system::setNumbersByUser)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 올 수 있습니다.");
    }

    @DisplayName("보너스 번호의 입력 숫자가 당첨 번호와 겹치면 예외가 발생한다.")
    @Test
    void setNumbersBonusNotContain() {
        String input = "1,2,3,4,5,6\n3";
        final byte[] inBuf = input.getBytes();
//        OutputStream outBuf = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outBuf));
        System.setIn(new ByteArrayInputStream(inBuf));

        assertThatThrownBy(system::setNumbersByUser)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 볼은 당첨 번호에 포함되어서는 안됩니다.");
    }

    @DisplayName("결과를 반환한다.")
    @Test
    void announceResult() {
        String input = "1,2,3,4,5,6\n3";
        final byte[] inBuf = input.getBytes();
        OutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));
        System.setIn(new ByteArrayInputStream(inBuf));

        assertThatThrownBy(system::setNumbersByUser)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 볼은 당첨 번호에 포함되어서는 안됩니다.");
    }
}