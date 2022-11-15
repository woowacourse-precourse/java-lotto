package lotto.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoResultTest {
    private UserLottos userLottos;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    void createLottoResult() {
        userLottos = new UserLottos(5000);
        winningLotto = new WinningLotto(List.of(21, 22, 23, 24, 25, 26), 7);
        lottoResult = new LottoResult(userLottos, winningLotto);
    }

    @DisplayName("당첨 맵이 정확한지 테스트")
    @Test
    void setResultMapTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    OutputStream out = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(out));

                    createLottoResult();
                    printResult(lottoResult);
                    assertThat(out.toString()).contains(
                            "FIFTH:1",
                            "FOURTH:1",
                            "THIRD:1",
                            "SECOND:2"
                    );
                },
                List.of(21, 22, 23, 1, 2, 3), //fifth 1
                List.of(21, 22, 23, 24, 1, 2), //fourth 1
                List.of(21, 22, 23, 24, 25, 1), //third 1
                List.of(21, 22, 23, 24, 25, 7), //
                List.of(21, 22, 23, 24, 25, 7) // second 2
        );
        System.setOut(System.out);
    }

    //수익률 계산하기
    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateYieldTest() {
        setResultMapTest();
        System.out.println(lottoResult.getYield());
        AssertionsForClassTypes.assertThat(lottoResult.getYield()).isEqualTo(1231100);
    }

    //서비스 로직
    public void printResult(LottoResult lottoResult) {

        lottoResult.getResultMap().forEach((key, value) -> {
            System.out.println(key.toString() + ":" + value.toString());
        });
    }


}
