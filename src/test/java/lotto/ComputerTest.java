package lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ComputerTest {
    private static Collection<Arguments> param1() {
        return Arrays.asList(
            Arguments.of("1등이 한번 등장",
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 0, 0, 0, 0)),
            Arguments.of("1등이 2번 등장",
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(2, 0, 0, 0, 0)),
            Arguments.of("1,5등 한번씩 등장",
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(1, 2, 3, 24, 25, 26))),
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 0, 0, 0, 1)),
            Arguments.of("2,3등 빼고 한번씩 등장",
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(1, 2, 3, 24, 25, 26)),
                    new Lotto(Arrays.asList(1, 2, 3, 4, 25, 26))),
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 0, 0, 1, 1)),
            Arguments.of("2등 빼고 한번씩 등장",
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(1, 2, 3, 24, 25, 26)),
                    new Lotto(Arrays.asList(1, 2, 3, 4, 25, 26)),
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 26))),
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 0, 1, 1, 1)),
            Arguments.of("1등부터 5등까지 한번씩 등장",
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(1, 2, 3, 24, 25, 26)),
                    new Lotto(Arrays.asList(1, 2, 3, 4, 25, 26)),
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 26)),
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))),
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 1, 1, 1, 1)),
            Arguments.of("보너스만 맞춘건 노카운팅",
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(21, 22, 23, 24, 25, 7))),
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 0, 0, 0, 0)),
            Arguments.of("보너스 한개와 당첨 숫자 1개를 맞춘건 노카운팅",
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(21, 22, 23, 24, 5, 7))),
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 0, 0, 0, 0)),
            Arguments.of("보너스 한개와 당첨 숫자 2개를 맞춘건 노카운팅",
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(21, 22, 23, 4, 5, 7))),
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 0, 0, 0, 0)),
            Arguments.of("보너스 한개와 당첨 숫자 2개를 맞춘건 노카운팅, 여러개 존재",
                Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(21, 22, 23, 4, 5, 7)),
                    new Lotto(Arrays.asList(21, 22, 23, 4, 5, 7)),
                    new Lotto(Arrays.asList(21, 22, 23, 4, 5, 7))
                ),
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 0, 0, 0, 0))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    @DisplayName("구매한 로또 목록, 당첨 번호, 보너스 번호를 받아 결과를 리턴하는지 테스트")
    void test1(String description, List<Lotto> lottos, List<Integer> win, int bonus,
        List<Integer> result) {
        Computer computer = new Computer();
        computer.init();
        List<Integer> a = computer.getResult(lottos, win, bonus);
        IntStream.range(0, 5).forEach(i -> Assertions.assertEquals(result.get(i), a.get(i)));
    }
}
