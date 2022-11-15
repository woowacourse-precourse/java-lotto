package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LotteryGroupTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,10,11,12-"
                    + "1,2,3,4,10,11-"
                    + "1,2,3,4,5,10-"
                    + "1,2,3,4,5,7-"
                    + "1,2,3,4,5,6:"
                    + "1,2,3,4,5,6:"
                    + "7:"
                    + "0,0,0,0,3"
    }, delimiterString = ":")
    void 로또묶음과_정답로또를_입력금액과_맞춘_갯수를_반환합니다(final String lottoBundleInput,
                                        final String answerLottInput,
                                        final String bonusNumberInput,
                                        final String count) {
        var lottoBundle = this.stringToLottoBundle(lottoBundleInput);
        var answerLott = this.stringToAnswerLotto(answerLottInput, bonusNumberInput);

        LotteryGroup lotteryGroup = new LotteryGroup();

        var result = lotteryGroup.settleResult(lottoBundle, answerLott);
        var money = lotteryGroup.calculateProfits();

        var expected = "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 1개\n"
                + "5개 일치 (1,500,000원) - 1개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                + "6개 일치 (2,000,000,000원) - 1개";

        assertThat(result).isEqualTo(expected);
        assertThat(money).isEqualTo(Money.generateMoney(2031555000L));
    }

    private LottoBundle stringToLottoBundle(final String input) {
        var lottoBundle = Arrays.stream(input.split("-"))
                .map(s -> Arrays.stream(s.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        return new LottoBundle(lottoBundle);
    }

    private AnswerLotto stringToAnswerLotto(final String answerLottoInput, final String bonusNumberInput) {
        return new AnswerLotto(new Lotto(answerLottoInput), new LottoNumber(bonusNumberInput));
    }

}