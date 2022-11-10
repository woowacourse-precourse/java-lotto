package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class IOManagerTest {

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Nested
    @DisplayName("getNumbersFromUser 메서드는")
    class describe_getNumbersFromUser {


        @Nested
        @DisplayName("사용자로부터 숫자 목록을 입력받는데")
        class describe_its_parameter {

            @Test
            @DisplayName("알맞은 입력인 경우 이를 리스트로 반환한다")
            void return_numberList_when_receive_right_input() {
                command("1,2,3,4,5");
                Assertions.assertThat(IoManager.getNumbersFromUser(",").equals(List.of(1, 2, 3, 4, 5)));

                command("1");
                Assertions.assertThat(IoManager.getNumbersFromUser(",").equals(List.of(1, 2, 3, 4, 6)));
            }

            @Test
            @DisplayName("잘못된 입력인 경우 예외를 발생시킨다")
            void throw_Exception_when_input_is_wrong() {
                Assertions.assertThatThrownBy(() -> {
                    command(",12");
                    IoManager.getNumbersFromUser(",");
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    command("");
                    IoManager.getNumbersFromUser(",");
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    command(",3,2");
                    IoManager.getNumbersFromUser(",");
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    command("1,2,a,");
                    IoManager.getNumbersFromUser(",");
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    command("1,,2");
                    IoManager.getNumbersFromUser(",");
                }).isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("getNumberFromUser 메서드는")
    class describe_getNumberFromUser {

        @Nested
        @DisplayName("사용자로부터 숫자를 입력받는데")
        class describe_its_parameter {

            @Test
            @DisplayName("알맞은 입력인 경우 이를 Integer 형태로 반환한다.")
            void return_number_when_receive_right_input() {
                command("1");
                Assertions.assertThat(IoManager.getNumberFromUser().equals(1));

                command("52");
                Assertions.assertThat(IoManager.getNumberFromUser().equals(52));
            }

            @Test
            @DisplayName("잘못된 입력인 경우 예외를 발생시킨다")
            void throw_Exception_when_input_is_wrong() {
                Assertions.assertThatThrownBy(() -> {
                    command(",");
                    IoManager.getNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    command("123,,55");
                    IoManager.getNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    command("");
                    IoManager.getNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    command("a");
                    IoManager.getNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    command("1,,2");
                    IoManager.getNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
