package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoCompanyTest {
    @Nested
    class DrawWinningNumbersTest extends NsTest {
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
            lottoCompany.drawWinningNumbers();
            System.out.print(lottoCompany.getWinningNumbers().getNumbers());
        }
    }

    @Nested
    class DrawBonusNumber extends NsTest {
        @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
        @Test
        void draw0() {
            assertThatThrownBy(() -> run("1,2,3,4,5,6", "0"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
        @Test
        void draw46() {
            assertThatThrownBy(() -> run("1,2,3,4,5,6", "46"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 번호가 당첨 번호와 중복된 숫자면 예외가 발생한다.")
        @Test
        void drawBonusNumberInWinningNumbers() {
            assertThatThrownBy(() -> run("1,2,3,4,5,6", "1"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Override
        protected void runMain() {
            LottoCompany lottoCompany = new LottoCompany();
            lottoCompany.drawWinningNumbers();
            lottoCompany.drawBonusNumber();
        }
    }
}