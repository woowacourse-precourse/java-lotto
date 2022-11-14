package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("사용자의 입출력 기능 중에서")
class UserInterfaceTest {

    private PrintStream standardOut;
    private OutputStream outputStream;

    private InputStream standardIn;

    UserInterface ui = new UserInterface();

    @BeforeEach
    protected final void initiallyAct() {
        standardIn = System.in;
        standardOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    protected final void finallyAct() {
        System.setIn(standardIn);
        System.setOut(standardOut);
        System.out.println(output());
    }

    private String output() {
        return outputStream.toString().trim();
    }

    private void input(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }

    @Nested
    @DisplayName("로또 구매 금액 입력 기능")
    class RequestPurchaseAmount {

        @Test
        @DisplayName("정상 입력에서는 정상 동작을 한다.")
        void normalAct1() {
            input("3000");
            int actual = ui.requestPurchaseAmount();

            assertThat(actual).isEqualTo(3000);
        }

        @Test
        @DisplayName("숫자0 입력은 예외처리한다.")
        void amount_input_is_zero() {
            UserInterface ui = new UserInterface();
            input("0");

            assertThatThrownBy(() -> ui.requestPurchaseAmount())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자+문자 입력은 예외처리한다.")
        void amount_input_is_combined_with_number_and_string() {
            UserInterface ui = new UserInterface();
            input("3000j");

            assertThatThrownBy(() -> ui.requestPurchaseAmount())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("문자 입력은 예외처리한다.")
        void amount_input_is_string() {
            UserInterface ui = new UserInterface();
            input("jadf");

            assertThatThrownBy(() -> ui.requestPurchaseAmount())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("빈 입력은 예외처리한다.")
        void amount_input_is_empty() {
            UserInterface ui = new UserInterface();
            input("");

            assertThatThrownBy(() -> ui.requestPurchaseAmount())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자+문자 입력은 예외처리한다.")
        void amount_input_is_escape_character() {
            UserInterface ui = new UserInterface();
            input(",12");

            assertThatThrownBy(() -> ui.requestPurchaseAmount())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 구매 내역 확인 기능은 정상동작한다.")
    void showingPurchasedLotto_Works() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(8, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 9, 5, 6)));
        lottos.add(new Lotto(List.of(1, 22, 3, 4, 5, 36)));
        lottos.add(new Lotto(List.of(1, 2, 23, 4, 45, 6)));

        ui.showPurchasedResult(lottos);

        assertThat(output()).isEqualTo(
                "6개를 구매했습니다.\n"
                        + "[1, 2, 3, 4, 5, 6]\n"
                        + "[1, 2, 3, 4, 5, 7]\n"
                        + "[8, 2, 3, 4, 5, 6]\n"
                        + "[1, 2, 3, 9, 5, 6]\n"
                        + "[1, 22, 3, 4, 5, 36]\n"
                        + "[1, 2, 23, 4, 45, 6]"
        );
    }

    @Nested
    @DisplayName("당첨 번호 입력 기능")
    class RequestWinningNumbers {

        @Test
        @DisplayName("안내 메시지 정상 출력하고, 유효한 입력을 받아 정상동작한다.")
        void normalAct1() {
            input("1,2,3,4,5,6");

            List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> actual = ui.requestWinningNumbers();

            assertThat(actual).isEqualTo(expected);
            assertThat(output()).isEqualTo("당첨 번호를 입력해 주세요.");
        }

        @Test
        @DisplayName("당첨번호를 6개 미만으로 입력하니 예외처리한다.")
        void winning_numbers_is_short_than_6() {
            invalidInputCheck("1,2,3,4,5");
        }

        @Test
        @DisplayName("당첨번호를 6개 초과해서 입력하니 예외처리한다.")
        void winning_numbers_is_bigger_than_6() {
            invalidInputCheck("1,2,3,4,5,6,7");
        }

        @Test
        @DisplayName("당첨번호에 빈 입력을 주니 예외처리한다.")
        void winning_number_is_empty() {
            invalidInputCheck("");
        }

        @Test
        @DisplayName("당첨번호에 문자 입력을 주니 예외처리한다.")
        void winning_number_is_only_character() {
            invalidInputCheck("-*ㅁㄴㅇㄹ");
        }

        @Test
        @DisplayName("당첨번호에 숫자와 문자 입력을 주니 예외처리한다.")
        void winning_number_is_number_with_character() {
            invalidInputCheck("1,9,8,a,4,10");
        }

        @Test
        @DisplayName("당첨번호를 잘못된 구분자로 입력하니 예외처리한다.")
        void winning_number_is_number_with_wrong_splitter() {
            invalidInputCheck("1.2.3.43.5.6");
        }

        @Test
        @DisplayName("중간 당첨번호를 공백으로 입력하니 예외처리한다.")
        void winning_number_is_number_with_blank() {
            invalidInputCheck("1,2, ,4,5,6");
        }

        @Test
        @DisplayName("중간 당첨번호를 비어있도록 입력하니 예외처리한다.")
        void winning_number_is_number_with_empty() {
            invalidInputCheck("1,2,,4,5,6");
        }

        void invalidInputCheck(String... args) {
            input(args);
            assertThatThrownBy(() -> ui.requestWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("보너스 번호 입력 기능")
    class RequestBonusNumber {

        @Test
        @DisplayName("안내 메시지 정상출력 이후, 유효 입력을 받아 정상동작한다.")
        void normalAction_Works() {
            input("34");

            int expected = 34;
            int actual = ui.requestBonusNumber();

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("문자를 입력하니 예외처리한다.")
        void input_is_character() {
            invalidInputCheck("r");
        }

        @Test
        @DisplayName("빈 입력을 하니 예외처리한다.")
        void input_is_empty() {
            invalidInputCheck("");
        }

        @Test
        @DisplayName("정수 범위를 초과하는 입력을 하니 예외처리한다.")
        void input_is_out_of_integer_range() {
            invalidInputCheck("99999999999999999");
        }

        void invalidInputCheck(String... args) {
            input(args);
            assertThatThrownBy(() -> ui.requestBonusNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 당첨 내역 및 수익률 출력 기능은 정상동작한다.")
    void ShowLottoStatistics() {
        Map<LottoPlace, Integer> records = new HashMap<>();

        records.put(LottoPlace.FIRST, 0);
        records.put(LottoPlace.SECOND, 2);
        records.put(LottoPlace.THIRD, 5);
        records.put(LottoPlace.FORTH, 8);
        records.put(LottoPlace.FIFTH, 10);
        records.put(LottoPlace.NONE, 30);

        ui.showLottoStatistics(records, 37.5);

        assertThat(output()).isEqualTo(
                "당첨 통계\n"
                        + "---\n"
                        + "3개 일치 (5,000원) - 10개\n"
                        + "4개 일치 (50,000원) - 8개\n"
                        + "5개 일치 (1,500,000원) - 5개\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n"
                        + "6개 일치 (2,000,000,000원) - 0개\n"
                        + "총 수익률은 37.5%입니다."
        );
    }
}