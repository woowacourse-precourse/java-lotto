package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCompanyTest extends NsTest {
    @DisplayName("로또 번호를 5개만 뽑으면 예외가 발생한다.")
    @Test
    void draw5Numbers() {
        assertThatThrownBy(() -> run("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 7개 뽑으면 예외가 발생한다.")
    @Test
    void draw7Numbers() {
        assertThatThrownBy(() -> run("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 정상적으로 6개 뽑는 경우")
    @Test
    void draw6Numbers() {
        run("1,2,3,4,5,6");
        assertThat(output()).contains("당첨 번호를 입력해 주세요.", "[1, 2, 3, 4, 5, 6]");
    }

    @Override
    protected void runMain() {
        LottoCompany lottoCompany = new LottoCompany();
        Lotto winningLotto = lottoCompany.drawWinningNumbers();
        System.out.print(winningLotto.getNumbers());
    }
}