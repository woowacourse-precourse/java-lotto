package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoCompanyTest {
    @Nested
    class DrawWinningNumbersTest {
        @DisplayName("로또 번호를 5개만 뽑으면 예외가 발생한다.")
        @Test
        void draw5Numbers() {
            assertThatThrownBy(() -> {
                LottoCompany lottoCompany = new LottoCompany();
                lottoCompany.setWinningLotto("1,2,3,4,5");
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호를 7개 뽑으면 예외가 발생한다.")
        @Test
        void draw7Numbers() {
            assertThatThrownBy(() -> {
                LottoCompany lottoCompany = new LottoCompany();
                lottoCompany.setWinningLotto("1,2,3,4,5,6,7");
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호를 정상적으로 6개 뽑는 경우")
        @Test
        void draw6Numbers() {
            LottoCompany lottoCompany = new LottoCompany();
            lottoCompany.setWinningLotto("1,2,3,4,5,6");
            lottoCompany.setBonusNumber("7");
        }
    }

    @Nested
    class DrawBonusNumber {
        @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
        @Test
        void draw0() {
            assertThatThrownBy(() -> {
                LottoCompany lottoCompany = new LottoCompany();
                lottoCompany.setWinningLotto("1,2,3,4,5,6");
                lottoCompany.setBonusNumber("0");
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
        @Test
        void draw46() {
            assertThatThrownBy(() -> {
                LottoCompany lottoCompany = new LottoCompany();
                lottoCompany.setWinningLotto("1,2,3,4,5,6");
                lottoCompany.setBonusNumber("46");
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 번호가 당첨 번호와 중복된 숫자면 예외가 발생한다.")
        @Test
        void drawBonusNumberInWinningNumbers() {
            assertThatThrownBy(() -> {
                LottoCompany lottoCompany = new LottoCompany();
                lottoCompany.setWinningLotto("1,2,3,4,5,6");
                lottoCompany.setBonusNumber("1");
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }
}