package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest {

    @Test
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    void 구입_금액이_1000으로_나누어_떨어지지_않을_경우_예외가_발생한다() {
        List<Integer> testNumbers = Arrays.asList(2500, 145, 1, 4556, -1000);
        InputValidator inputValidator = new InputValidator();
        for (Integer testNumber : testNumbers) {
            assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(testNumber)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 번호는 1에서 45사이의 숫자만 가져야 한다.")
    void 로또_번호는_1에서_45사이의_숫자만_가져야_한다() {
        List<List<Integer>> testLotto = Arrays.asList(Arrays.asList(1, 2, 3, 4, 46), Arrays.asList(0, 1, 2, 3, 4, 5));
        InputValidator inputValidator = new InputValidator();
        for (List<Integer> numbers : testLotto) {
            assertThatThrownBy(() -> inputValidator.validateLotto(numbers)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우 예외가 발생한다.")
    void 로또_번호가_6개가_아닐_경우_예외가_발생한다() {
        List<List<Integer>> testLotto = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        InputValidator inputValidator = new InputValidator();
        for (List<Integer> numbers : testLotto) {
            assertThatThrownBy(() -> inputValidator.validateLotto(numbers)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 번호가 중복일 경우 예외가 발생한다.")
    void 로또_번호가_중복일_경우_예외가_발생한다() {
        List<List<Integer>> testLotto = Arrays.asList(Arrays.asList(1, 2, 2, 4, 5, 6), Arrays.asList(1, 1, 1, 1, 1, 1));
        InputValidator inputValidator = new InputValidator();
        for (List<Integer> numbers : testLotto) {
            assertThatThrownBy(() -> inputValidator.validateLotto(numbers)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 구매 후 출력")
    void 로또_구매_후_출력(){
        User user = new User();
        NumberGenerator numberGenerator = new NumberGenerator();
        int numOfLotto = user.getNumberOfAvailableLotto(8000);
        for(int i=0; i<8; i++){
            List<Integer> numbers = numberGenerator.generateSixRandomNumbers();
            Lotto lotto = new Lotto(numbers);
            user.buyLotto(lotto);
        }
        user.showWholeLotto();
    }

}
