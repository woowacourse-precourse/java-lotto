package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
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
    void 로또_발행() {
        List<Integer> answer = Lotto.getLottoNumbers();
        long count = answer.stream().distinct().count();
        assertThat(count).isEqualTo(6L);
    }

    @Test
    void 사용자의_구매횟수만큼_로또숫자_발행() {
        List<List<Integer>> result = Lotto.getPurchaseLottoList(5);
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    void 숫자_포함_여부_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int n = 1;
        int k = 7;
        assertThat(lotto.isContainNumber(n)).isEqualTo(ContainStatus.Contain);
        assertThat(lotto.isContainNumber(k)).isEqualTo(ContainStatus.NotContain);
    }

    @Test
    void 당첨갯수_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> user = List.of(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getMatchingNumber(user)).isEqualTo(6);
    }

    @Test
    void 당첨배열_인덱스_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Input input = new Input(7);
        List<List<Integer>> user = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 11, 12, 13, 14),
                List.of(1, 11, 12, 13, 14, 15),
                List.of(11, 12, 13, 14, 15, 16)
        );
        List<Integer> answer = List.of(3, 4, 2, 1, 0, -1, -1, -1);

        for (int i = 0; i <user.size() ; i++) {
            assertThat(lotto.getWinningIndex(user.get(i), input)).isEqualTo(answer.get(i));
        }

//    }
//    @Test
//    void 당첨_배열_생성() {
//        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
//        List<List<Integer>> user = List.of(
//                List.of(1, 2, 3, 4, 5, 6),
//                List.of(1, 2, 3, 4, 5, 7),
//                List.of(1, 2, 3, 4, 5, 7),
//                List.of(1, 2, 3, 4, 8, 9),
//                List.of(1, 2, 3, 10, 11, 12),
//                List.of(1, 2, 11, 12, 13, 14),
//                List.of(1, 11, 12, 13, 14, 15),
//                List.of(11, 12, 13, 14, 15, 16)
//        );
//        List<Integer> bonus = List.of(10, 6, 23, 11, 10, 10, 15, 15);
//        int[] answer = new int[]{1, 1, 1, 1, 1};
//        assertThat(lotto.getWinningArray(user,bonus)).isEqualTo()

    }
}
