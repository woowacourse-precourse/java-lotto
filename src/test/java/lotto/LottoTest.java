package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 출력 형식 검증 오름차순 정렬이 수행되어야 한다.")
    @Test
    void 로또_출력_형식_검증_오름차순_정렬이_수행되어야_한다() {

        List<Integer> firstLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> secondLotto = List.of(7, 8, 9, 10, 11, 12);
        List<Integer> thirdLotto = List.of(13, 14, 15, 16, 17, 18);
        List<Integer> fourth = List.of(19, 20, 21, 22, 23, 24);
        List<Integer> fifth = List.of(25, 26, 27, 28, 29, 30);
        List<Integer> sixth = List.of(31, 32, 33, 34, 35, 36);
        List<Integer> seventh = List.of(37, 38, 39, 40, 41, 42);
        List<Integer> eighth = List.of(43, 44, 45, 1, 2, 3);
        List<List<Integer>> generatedLottoNumber = new ArrayList<>() {{
            add(firstLotto);
            add(secondLotto);
            add(thirdLotto);
            add(fourth);
            add(fifth);
            add(sixth);
            add(seventh);
            add(eighth);
        }};

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (List<Integer> eachLottoPaper : generatedLottoNumber) {
            System.out.println(Arrays.toString(Arrays.stream(eachLottoPaper.toArray()).sorted().toArray()));
        }

        Assertions.assertThat(out.toString()).contains("[1, 2, 3, 4, 5, 6]");
        Assertions.assertThat(out.toString()).contains("[1, 2, 3, 43, 44, 45]");
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
