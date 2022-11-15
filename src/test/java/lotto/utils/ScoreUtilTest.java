package lotto.utils;

import lotto.domain.ScoreInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ScoreUtilTest {

    @ParameterizedTest(name = "{displayName} => {0}")
    @DisplayName("맞힌 개수와 보너스 맞춘 개수를 통해서 등수를 가려내는 함수")
    @MethodSource("giveCorrectCountAndBonusCountAndScoreInfo")
    void findRankByCorrectLottoCountTest(Integer correctCount, Integer bonusCount, ScoreInfo scoreInfo) {
        ScoreInfo expectedScoreInfo = ScoreUtil.findRankByCorrectLottoCount(correctCount , bonusCount);

        Assertions.assertEquals(expectedScoreInfo.getRank(), scoreInfo.getRank());


    }

    @ParameterizedTest(name = "{displayName} => {0}")
    @DisplayName("1 2등을 가려내는 함수")
    @MethodSource("giveBonusCountAndScoreInfo")
    void isSecondOrElseTest(Integer bonusCount, ScoreInfo scoreInfo, ScoreInfo resultScoreInfo) {
        ScoreInfo secondOrElse = ScoreUtil.isSecondOrElse(bonusCount, scoreInfo);

        Assertions.assertEquals(secondOrElse.getRank(), resultScoreInfo.getRank());

    }


//    @ParameterizedTest(name = "{displayName} => {0}")
//    @DisplayName("수익률을 계산하여 메시지를 만드는 메서드")
//    @MethodSource("giveBonusCountAndScoreInfo")
//    void calRateOfReturnMessageTest(List<ScoreInfo> scoreInfos) {
//        ScoreUtil.calRateOfReturnMessage(scoreInfos);
//    }

    private static Stream<Arguments> giveCorrectCountAndBonusCountAndScoreInfo() {
        return Stream.of(
                Arguments.of(3, 0, ScoreInfo.THREE),
                Arguments.of(6, 1, ScoreInfo.FIVE_ALPHA),
                Arguments.of(0, 0, ScoreInfo.ELSE));
    }
    private static Stream<Arguments> giveBonusCountAndScoreInfo() {
        return Stream.of(
                Arguments.of(1, ScoreInfo.FIVE_ALPHA, ScoreInfo.FIVE_ALPHA),
                Arguments.of(0, ScoreInfo.ELSE, ScoreInfo.ELSE),
                Arguments.of(0, ScoreInfo.THREE, ScoreInfo.THREE));
    }

    private static Stream<Arguments> givescoreInfos() {
        return Stream.of(
                Arguments.of(List.of(ScoreInfo.FIVE,ScoreInfo.FIVE)),
                Arguments.of(List.of(ScoreInfo.THREE,ScoreInfo.THREE)),
                Arguments.of(List.of(ScoreInfo.FOUR,ScoreInfo.FOUR)));
    }
}