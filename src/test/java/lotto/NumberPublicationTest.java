package lotto;

import lotto.publish.NumberPublication;
import org.assertj.core.api.AssertProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberPublicationTest {

    NumberPublication numberPublication = new NumberPublication();

    @DisplayName("입력한 숫자만큼 리스트 크기가 만들어지는지 확인")
    @Test
    void createLotto() {
        int actualNumber = 6;
        List<List<Integer>> list = numberPublication.publishNumbers(actualNumber);

        assertThat(list.size()).isEqualTo(6);

        for(List<Integer> i : list) {
            System.out.println(i.toString());
        }
    }
}
