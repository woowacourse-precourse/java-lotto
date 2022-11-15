package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningTest {

    @Test
    @DisplayName("당첨 번호를 입력할 수 있다.")
    void 당첨_번호를_입력할_수_있다() {
        // given
        setInput("1,2,3,4,5,6");
        Winning winning = new Winning();

        // when
        winning.inputNumbers();

        // then
        List<Integer> result = winning.getWinningNumbers();
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호에 구분자(,)를 넣지 않으면 예외가 발생한다.")
    void 당첨_번호에_구분자를_넣지_않으면_예외가_발생한다() {
        setInput("123456");
        Winning winning = new Winning();

        assertThatThrownBy(() -> winning.inputNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자를 입력하면 예외가 발생한다.")
    void 당첨_번호에_중복된_숫자를_입력하면_예외가_발생한다() {
        setInput("1,1,1,2,3,4");
        Winning winning = new Winning();

        assertThatThrownBy(() -> winning.inputNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6자리가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 당첨_번호가_6자리가_아니면_예외가_발생한다(String input) {
        setInput(input);
        Winning winning = new Winning();

        assertThatThrownBy(() -> winning.inputNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 문자가 섞이면 예외가 발생한다.")
    void 당첨_번호에_문자가_섞이면_예외가_발생한다() {
        setInput("1,1,1,2,3,a");
        Winning winning = new Winning();

        assertThatThrownBy(() -> winning.inputNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 로또 범위를 벗어나면 예외가 발생한다.")
    void 당첨_번호가_로또_범위를_벗어나면_예외가_발생한다() {
        setInput("0,1,10,20,30,50");
        Winning winning = new Winning();

        assertThatThrownBy(() -> winning.inputNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호를 입력할 수 있다.")
    void 보너스_번호를_입력할_수_있다() {
        // given
        setInput("7");
        Winning winning = new Winning();

        // when
        winning.inputBonusNumber();

        // then
        int result = winning.getBonusNumber();
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호에 여러 개의 숫자를 입력하면 예외가 발생한다.")
    void 보너스_번호에_여러_개의_숫자를_입력하면_예외가_발생한다() {
        setInput("7,8");
        Winning winning = new Winning();

        assertThatThrownBy(() -> winning.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        String winningNumbers = "1,2,3,4,5,6"; // 당첨 번호
        String bonusNumber = "6"; // 보너스 번호
        Winning winning = new Winning();
        setInput(winningNumbers);
        winning.inputNumbers();
        setInput(bonusNumber);

        assertThatThrownBy(() -> winning.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호를 가져올 수 있다.")
    void 당첨_번호를_가져올_수_있다() {
        // given
        setInput("1,10,20,30,40,45");
        Winning winning = new Winning();
        winning.inputNumbers();

        // when
        List<Integer> result = winning.getWinningNumbers();

        // then
        assertThat(result).containsExactly(1, 10, 20, 30, 40, 45);
    }

    @Test
    @DisplayName("보너스 번호를 가져올 수 있다.")
    void 보너스_번호를_가져올_수_있다() {
        // given
        setInput("45");
        Winning winning = new Winning();
        winning.inputBonusNumber();

        // when
        int result = winning.getBonusNumber();

        // then
        assertThat(result).isEqualTo(45);
    }

    private void setInput(String... inputs) {
        final byte[] buf = String.join("\n", inputs).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}