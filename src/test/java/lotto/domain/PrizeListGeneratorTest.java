package lotto.domain;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static lotto.prizestandards.PrizeStandards.*;

class PrizeListGeneratorTest {
    private PrizeListGenerator prizeListGenerator;

    private List<Lotto> lottoMaker() {
        List<Integer> lottoNumbers = new ArrayList<Integer>(List.of(1,3,5,14,22,45));
        List<Integer> lottoNumbers2 = new ArrayList<Integer>(List.of(1,2,3,4,5,45));
        List<Integer> lottoNumbers3 = new ArrayList<Integer>(List.of(10,11,12,13,14,45));
        Lotto lotto  = new Lotto(lottoNumbers);
        Lotto lotto2 = new Lotto(lottoNumbers2);
        Lotto lotto3 = new Lotto(lottoNumbers3);

        List<Lotto> lottoList = new ArrayList<Lotto>(List.of(lotto, lotto2, lotto3));

        return lottoList;
    }


    @BeforeEach
    void setUp() throws FileNotFoundException {
        /* 두 줄의 입력을 Mock 하기 위해서 FileInputStream 사용 */
        FileInputStream in = new FileInputStream("src/test/java/lotto/domain/WinningNumberInputs");
        System.setIn(in);

        prizeListGenerator = new PrizeListGenerator();
    }

    @AfterEach
    void tearDown() {
        this.prizeListGenerator = null;
    }

    @Test
    void iterateLotteriesForStatistic() {
        List<Lotto> lottoList = lottoMaker();

        prizeListGenerator.iterateLotteriesForStatistic(lottoList);

        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(prizeListGenerator.returnWinnerResult().get(THREEMATCH)).isEqualTo(1),
                () -> Assertions.assertThat(prizeListGenerator.returnWinnerResult().get(FOURMATCH)).isEqualTo(0),
                () ->Assertions.assertThat(prizeListGenerator.returnWinnerResult().get(FIVEMATCH)).isEqualTo(1),
                () -> Assertions.assertThat(prizeListGenerator.returnWinnerResult().get(FIVEBONUS)).isEqualTo(0),
                () -> Assertions.assertThat(prizeListGenerator.returnWinnerResult().get(SIXMATCH)).isEqualTo(0),
                () -> Assertions.assertThat(prizeListGenerator.returnWinnerResult().get(UNDERPRIZE)).isEqualTo(1)
        );
    }
}