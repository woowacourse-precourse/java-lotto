package lotto;

import lotto.Model.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {
    @Test
    void 로또_자릿수_부족_테스트() {
        String input = "1,2,3,4,7";
        String[] splitInput = input.split(",");

        List<Integer> list = Arrays.stream(splitInput)
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new WinningLotto(list, 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_자릿수_초과_테스트() {
        String input = "1,2,3,4,7,10,12";
        String[] splitInput = input.split(",");

        List<Integer> list = Arrays.stream(splitInput)
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new WinningLotto(list, 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_중복_테스트() {
        String input = "1,2,3,4,7,7";
        String[] splitInput = input.split(",");

        List<Integer> list = Arrays.stream(splitInput)
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new WinningLotto(list, 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_중복_테스트() {
        String input = "1,2,3,4,6,45";
        String[] splitInput = input.split(",");

        List<Integer> list = Arrays.stream(splitInput)
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new WinningLotto(list, 45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자범위_미달_테스트() {
        String input = "1,2,3,4,6,0";
        String[] splitInput = input.split(",");

        List<Integer> list = Arrays.stream(splitInput)
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new WinningLotto(list, 45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자범위_초과_테스트() {
        String input = "1,2,3,4,6,50";
        String[] splitInput = input.split(",");

        List<Integer> list = Arrays.stream(splitInput)
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new WinningLotto(list, 45))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
