package lotto;

import lotto.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    Numbers numbers = new Numbers();

    @DisplayName("입력한 숫자만큼 리스트 크기가 만들어지는지 확인")
    @Test
    void createLotto() {
        int actualNumber = 6;
        List<List<Integer>> list = numbers.publishNumbers(actualNumber);

        assertThat(list.size()).isEqualTo(6);

        for(List<Integer> i : list) {
            System.out.println(i.toString());
        }
    }
}
