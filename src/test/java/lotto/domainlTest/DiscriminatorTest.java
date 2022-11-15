package lotto.domainlTest;

import lotto.domain.Discriminator;
import lotto.domain.Lotto;
import lotto.domain.RaffleNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscriminatorTest {
    @Test
    @DisplayName("발행한 로또 번호와 입력받은 추첨 번호를 이용하여 몇 개를 맞췄는지 확인한다.")
    public void guessLottoNumber() {
        int expectedResult = 5;
        List<Integer> lottoNumbers = List.of(1, 45, 6, 7, 8, 20);
        Lotto lotto = new Lotto(lottoNumbers);

        String raffleNumbers = "1,45,6,7,9,20";
        String bonusNumber = "8";
        RaffleNumber raffleNumber = new RaffleNumber();
        raffleNumber.create(raffleNumbers, bonusNumber);

        Discriminator discriminator = new Discriminator();
        discriminator.initialize(raffleNumber);

        assertThat(discriminator.guessLottoNumber(lotto)).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("추첨 번호를 5개 맞추었다면 true를 반환")
    public void checkThatLottoMatchesFiveOfRaffleNumber() {
        String raffleNumbers = "1,45,6,7,9,20";
        String bonusNumber = "8";
        RaffleNumber raffleNumber = new RaffleNumber();
        raffleNumber.create(raffleNumbers, bonusNumber);

        Discriminator discriminator = new Discriminator();
        discriminator.initialize(raffleNumber);

        assertThat(discriminator.canSecondRank(5)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("추첨 번호를 5개 이상 또는 이하로 맞추었다면 false를 반환")
    @ValueSource(ints = {1, 2, 3, 4, 6})
    public void checkThatLottoDoesNotMatchesFiveOfRaffleNumber(int matchCount) {
        String raffleNumbers = "1,45,6,7,9,20";
        String bonusNumber = "8";
        RaffleNumber raffleNumber = new RaffleNumber();
        raffleNumber.create(raffleNumbers, bonusNumber);

        Discriminator discriminator = new Discriminator();
        discriminator.initialize(raffleNumber);

        assertThat(discriminator.canSecondRank(matchCount)).isFalse();
    }

    @Test
    @DisplayName("추첨 번호를 5개 맞추고 보너스 번호를 맞춘 경우 보너스 번호 맞춘 개수는 1인지 확인한다.")
    public void compareLottoWithBonusNumber() {
        int expectedBonusCount = 1;

        List<Integer> lottoNumbers = List.of(1, 45, 6, 7, 8, 20);
        Lotto lotto = new Lotto(lottoNumbers);

        String raffleNumbers = "1,45,6,7,9,20";
        String bonusNumber = "8";
        RaffleNumber raffleNumber = new RaffleNumber();
        raffleNumber.create(raffleNumbers, bonusNumber);

        Discriminator discriminator = new Discriminator();
        discriminator.initialize(raffleNumber);

        assertThat(discriminator.guessBonusNumber(lotto, 5)).isEqualTo(expectedBonusCount);
    }

    @Test
    @DisplayName("2개 이하의 추첨 번호를 맞춘 결과는 제외된다.")
    public void excludeResultUnderTwoMatches() {
        int expectedBonusCount = 0;
        int raffleMatches;
        int bonusMatches = 0;

        List<Integer> lottoNumbers = List.of(1, 45, 6, 7, 8, 20);
        Lotto lotto = new Lotto(lottoNumbers);
        List<List<Integer>> matches;

        String raffleNumbers = "1,45,5,11,23,9";
        String bonusNumber = "15";
        RaffleNumber raffleNumber = new RaffleNumber();
        raffleNumber.create(raffleNumbers, bonusNumber);

        Discriminator discriminator = new Discriminator();
        discriminator.initialize(raffleNumber);

        raffleMatches = discriminator.guessLottoNumber(lotto);
        discriminator.addMatchOverThree(raffleMatches, bonusMatches);
        matches = discriminator.getMatches();

        assertThat(matches.size()).isEqualTo(expectedBonusCount);
    }

    @Test
    @DisplayName("3개 이상 맞춘 로또들만 결과에 집계된다.")
    public void countMatchedLotteries() {
        int expectedMatchCount = 5;
        List<List<Integer>> matches;

        String raffleNumbers = "1,45,5,11,23,20";
        String bonusNumber = "15";

        // 순서대로 2개, 3개, 4개, 5개, 5개+보너스, 6개 맞춘 로또들이다.
        List<Lotto> lotteries = List.of(
                new Lotto(List.of(1, 45, 6, 7, 8, 2)), // 2개 맞춘 로또
                new Lotto(List.of(1, 45, 6, 7, 8, 20)), // 3개 맞춘 로또
                new Lotto(List.of(1, 45, 5, 7, 8, 20)), // 4개 맞춘 로또
                new Lotto(List.of(1, 45, 5, 11, 23, 28)), // 5개 맞춘 로또
                new Lotto(List.of(1, 45, 5, 11, 23, 15)), // 5개 + 보너스 맞춘 로또
                new Lotto(List.of(1, 45, 5, 11, 23, 20))); // 6개 맞춘 로또

        RaffleNumber raffleNumber = new RaffleNumber();
        raffleNumber.create(raffleNumbers, bonusNumber);

        Discriminator discriminator = new Discriminator();
        discriminator.initialize(raffleNumber);

        discriminator.discriminate(lotteries);
        matches = discriminator.getMatches();
        assertThat(matches.size()).isEqualTo(expectedMatchCount);
    }

    @Test
    @DisplayName("3개 이상 맞춘 로또들만 결과에 집계된다.")
    public void checkMatchLotteriesResult() {
        List<List<Integer>> expectedMatchCountResult = List.of(List.of(3, 0), List.of(4, 0), List.of(5, 0), List.of(5, 1), List.of(6, 0));
        List<List<Integer>> matches;

        String raffleNumbers = "1,45,5,11,23,20";
        String bonusNumber = "15";

        // 순서대로 2개, 3개, 4개, 5개, 5개+보너스, 6개 맞춘 로또들이다.
        List<Lotto> lotteries = List.of(
                new Lotto(List.of(1, 45, 6, 7, 8, 2)), // 2개 맞춘 로또
                new Lotto(List.of(1, 45, 6, 7, 8, 20)), // 3개 맞춘 로또
                new Lotto(List.of(1, 45, 5, 7, 8, 20)), // 4개 맞춘 로또
                new Lotto(List.of(1, 45, 5, 11, 23, 28)), // 5개 맞춘 로또
                new Lotto(List.of(1, 45, 5, 11, 23, 15)), // 5개 + 보너스 맞춘 로또
                new Lotto(List.of(1, 45, 5, 11, 23, 20))); // 6개 맞춘 로또

        RaffleNumber raffleNumber = new RaffleNumber();
        raffleNumber.create(raffleNumbers, bonusNumber);

        Discriminator discriminator = new Discriminator();
        discriminator.initialize(raffleNumber);

        discriminator.discriminate(lotteries);
        matches = discriminator.getMatches();
        assertThat(matches).containsExactlyElementsOf(expectedMatchCountResult);
    }
}
