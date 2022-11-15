package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Application.noOfLottos;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GetNoOfLottoMethodTest extends NsTest {
    ArrayList<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("구매 금액은 20억 이하의 1000의 배수 자연수를 입력한다(1).")
    @Test
    void getNoOfLottoMethodTest1() {
        assertSimpleTest(() -> {
            run("20000");
            assertThat(noOfLottos).isEqualTo(20);
        });
    }

    @DisplayName("구매 금액은 20억 이하의 1000의 배수 자연수를 입력한다(2).")
    @Test
    void getNoOfLottoMethodTest2() {
        assertSimpleTest(() -> {
            run("1000");
            assertThat(noOfLottos).isEqualTo(1);
        });
    }

    @DisplayName("구매 금액은 20억 이하의 1000의 배수 자연수를 입력한다(3).")
    @Test
    void getNoOfLottoMethodTest3() {
        assertSimpleTest(() -> {
            run("2000000000");
            assertThat(noOfLottos).isEqualTo(2000000);
        });
    }

    @DisplayName("구매 금액은 숫자만 입력해야 한다.")
    @Test
    void getNoOfLottoMethodExceptionTest1() {
            assertThatThrownBy(() -> {
                assertSimpleTest(() -> run("*"));
            })
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @DisplayName("구매 금액은 19자리 이상의 숫자를 입력할 수 없다.")
    @Test
    void getNoOfLottoMethodExceptionTest2() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1234567890123456789"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @DisplayName("구매 금액은 20억을 초과하는 숫자를 입력할 수 없다(1).")
    @Test
    void getNoOfLottoMethodExceptionTest3() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("123456789012345678"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @DisplayName("구매 금액은 20억을 초과하는 숫자를 입력할 수 없다(2).")
    @Test
    void getNoOfLottoMethodExceptionTest4() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("2000000001"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @DisplayName("구매 금액은 1000의 배수여야 한다.")
    @Test
    void getNoOfLottoMethodExceptionTest5() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1999999999"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
    }

    @DisplayName("구매 금액은 자연수여야 한다.")
    @Test
    void getNoOfLottoMethodExceptionTest6() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("0"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 이상의 값을 입력해 주세요.");
    }

    @DisplayName("구매 금액은 1000의 배수여야 한다.")
    @Test
    void getNoOfLottoMethodExceptionTest7() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
    }

    @Override
    public void runMain() {
        Application.getNoOfLotto();
    }
}