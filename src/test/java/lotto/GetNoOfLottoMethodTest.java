package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Application.noOfLottos;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GetNoOfLottoMethodTest extends NsTest {
    ArrayList<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void getNoOfLotto_메소드_테스트1() {
        assertSimpleTest(() -> {
            run("20000");
            assertThat(noOfLottos).isEqualTo(20);
        });
    }

    @Test
    void getNoOfLotto_메소드_테스트2() {
        assertSimpleTest(() -> {
            run("1000");
            assertThat(noOfLottos).isEqualTo(1);
        });
    }

    @Test
    void getNoOfLotto_메소드_테스트3() {
        assertSimpleTest(() -> {
            run("2000000000");
            assertThat(noOfLottos).isEqualTo(2000000);
        });
    }

    @Test
    void getNoOfLotto_메소드_예외_테스트1() {
            assertThatThrownBy(() -> {
                assertSimpleTest(() -> run("*"));
            })
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Test
    void getNoOfLotto_메소드_예외_테스트2() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1234567890123456789"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @Test
    void getNoOfLotto_메소드_예외_테스트3() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("123456789012345678"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @Test
    void getNoOfLotto_메소드_예외_테스트4() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("2000000001"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @Test
    void getNoOfLotto_메소드_예외_테스트5() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1999999999"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
    }

    @Test
    void getNoOfLotto_메소드_예외_테스트6() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("0"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 이상의 값을 입력해 주세요.");
    }

    @Test
    void getNoOfLotto_메소드_예외_테스트7() {
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