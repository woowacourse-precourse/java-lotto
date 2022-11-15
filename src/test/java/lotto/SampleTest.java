package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SampleTest {
    private final Sample sample;

    public SampleTest(){
        this.sample = new Sample();
    }
    @Test
    void stringToIntTest1(){
        assertThatThrownBy(() -> sample.stringToInt("12ab12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringToIntTest2(){
        assertThatThrownBy(() -> sample.stringToInt("123452853740958342000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void stringToIntTest3(){
        assertThatThrownBy(() -> sample.stringToInt("135700"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void getLottosTest1(){
        assertRandomUniqueNumbersInRangeTest(
                () -> assertThat(sample.getLottos(8))
                        .contains(
                        new Lotto(new ArrayList<>(List.of(8, 21, 23, 41, 42, 43))),
                        new Lotto(new ArrayList<>(List.of(3, 5, 11, 16, 32, 38))),
                        new Lotto(new ArrayList<>(List.of(7, 11, 16, 35, 36, 44))),
                        new Lotto(new ArrayList<>(List.of(1, 8, 11, 31, 41, 42))),
                        new Lotto(new ArrayList<>(List.of(13, 14, 16, 38, 42, 45))),
                        new Lotto(new ArrayList<>(List.of(7, 11, 30, 40, 42, 43))),
                        new Lotto(new ArrayList<>(List.of(2, 13, 22, 32, 38, 45))),
                        new Lotto(new ArrayList<>(List.of(1, 3, 5, 14, 22, 45)))
                        ),
                new ArrayList<>(List.of(8, 21, 23, 41, 42, 43)),
                new ArrayList<>(List.of(3, 5, 11, 16, 32, 38)),
                new ArrayList<>(List.of(7, 11, 16, 35, 36, 44)),
                new ArrayList<>(List.of(1, 8, 11, 31, 41, 42)),
                new ArrayList<>(List.of(13, 14, 16, 38, 42, 45)),
                new ArrayList<>(List.of(7, 11, 30, 40, 42, 43)),
                new ArrayList<>(List.of(13, 2, 22, 32, 38, 45)),
                new ArrayList<>(List.of(1, 3, 5, 14, 22, 45))
        );
    }

    @Test
    void printLottosTest1(){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(List.of(8, 21, 23, 41, 42, 43))));
        lottos.add(new Lotto(new ArrayList<>(List.of(3, 5, 11, 16, 32, 38))));
        lottos.add(new Lotto(new ArrayList<>(List.of(7, 11, 16, 35, 36, 44))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 8, 11, 31, 41, 42))));
        lottos.add(new Lotto(new ArrayList<>(List.of(13, 14, 16, 38, 42, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(7, 11, 30, 40, 42, 43))));
        lottos.add(new Lotto(new ArrayList<>(List.of(2, 13, 22, 32, 38, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 3, 5, 14, 22, 45))));
        assertThat(sample.printLottos(lottos))
                .contains(
                        "8개를 구매했습니다.",
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]",
                "[7, 11, 16, 35, 36, 44]",
                "[1, 8, 11, 31, 41, 42]",
                "[13, 14, 16, 38, 42, 45]",
                "[7, 11, 30, 40, 42, 43]",
                "[2, 13, 22, 32, 38, 45]",
                "[1, 3, 5, 14, 22, 45]");
    }

    @Test
    void getWinningNumberTest1(){
        assertThat(sample.getWinningNumber("1,2,3,4,5,6"))
                .contains(1,2,3,4,5,6);
    }

    @Test
    void getWinningNumberTest2(){
        assertThatThrownBy(() -> sample.getWinningNumber("1,2,3,4,5,a6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getWinningNumberTest3(){
        assertThatThrownBy(() -> sample.getWinningNumber("1,2,3,4,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getBonusNumberTest1(){
        assertThat(sample.getBonusNumber("4"))
                .isEqualTo(4);
    }

    @Test
    void getBonusNumberTest2(){
        assertThatThrownBy(() -> sample.getBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getWinningStatisticsTest1(){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(List.of(8, 21, 23, 41, 42, 43))));
        lottos.add(new Lotto(new ArrayList<>(List.of(3, 5, 11, 16, 32, 38))));
        lottos.add(new Lotto(new ArrayList<>(List.of(7, 11, 16, 35, 36, 44))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 8, 11, 31, 41, 42))));
        lottos.add(new Lotto(new ArrayList<>(List.of(13, 14, 16, 38, 42, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(7, 11, 30, 40, 42, 43))));
        lottos.add(new Lotto(new ArrayList<>(List.of(2, 13, 22, 32, 38, 45))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 3, 5, 14, 22, 45))));

        assertThat(sample.getWinningStatistics(lottos, new ArrayList<>(List.of(7, 11, 16, 35, 36, 44)), 5))
                .contains(
                        new LottoWinning(6, false)
                );
    }

    @Test
    void printWinningStatisticsTest1(){
        List<LottoWinning> lottoWinnings = new ArrayList<>();
        lottoWinnings.add(new LottoWinning(3,false));
        lottoWinnings.add(new LottoWinning(4,false));
        lottoWinnings.add(new LottoWinning(3,false));
        lottoWinnings.add(new LottoWinning(5,false));
        lottoWinnings.add(new LottoWinning(5,true));

        assertThat(sample.printWinningStatistics(lottoWinnings))
                .contains(
                        "3개 일치 (5,000원) - 2개",
                        "4개 일치 (50,000원) - 1개",
                        "5개 일치 (1,500,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 0개"
                        );
    }

    @Test
    void printYieldTest1(){
        List<LottoWinning> lottoWinnings = new ArrayList<>();
        lottoWinnings.add(new LottoWinning(3,false));

        assertThat(sample.printYield(lottoWinnings, 8000))
                .contains(
                        "총 수익률은 62.5%입니다."
                );
    }
}