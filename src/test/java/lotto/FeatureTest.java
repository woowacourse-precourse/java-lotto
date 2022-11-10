package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class FeatureTest {
    @Test
    void 입력을_숫자로_변환() {
        String input = "1400";
        assertThat(Input.getInputToInt(input)).isEqualTo(1400);
    }

    @Test
    void 입력_로또문자열을_리스트로_변환() {
        String input = "1,2,3,4,5,6";
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
        assertThat(Input.getWinningNumber(input)).isEqualTo(answer);
    }

    @Test
    void 로또_발행(){
        List<Integer> answer = Lotto.getLottoNumbers();
        long count = answer.stream().distinct().count();
        assertThat(count).isEqualTo(6L);
    }
    @Test
    void 사용자의_구매횟수만큼_로또숫자_발행(){
        List<List<Integer>> result = Lotto.getPurchaseLottoList(5);
        assertThat(result.size()).isEqualTo(5);
    }


}
