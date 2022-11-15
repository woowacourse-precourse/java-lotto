package lotto.view.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.ScoreInfo;
import lotto.view.vlidation.InputCorrectLottoValidator;

import java.util.List;

import static lotto.domain.ScoreInfo.*;
import static lotto.utils.ConvertUtil.convertInputToIntegerList;
import static lotto.view.controller.ConsoleMessage.*;
import static lotto.view.vlidation.InputMoneyValidator.validateBlank;

public class LottoNumberView {

    private static final List<ScoreInfo> scoreInfoWithoutElse = List.of(SIX, FIVE_ALPHA, FIVE, FOUR, THREE);

    private LottoNumberView() {
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println(INPUT_CORRECT_LOTTO_MONEY.getMessage());
        String input = Console.readLine();
        validateBlank(input);
        List<Integer> newLottoNumber = convertInputToIntegerList(input);
        InputCorrectLottoValidator.validate(newLottoNumber);
        return newLottoNumber;
    }

    public static void printTotalLottoCount(Integer lottoCount) {
        System.out.println(lottoCount + NUMBER_COUNT_UNITS.getMessage() + PRINT_BUY.getMessage());
    }

    public static void printLottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void printScoreBoard(List<Integer> scoreBoard) {

        System.out.println(PRINT_LOTTO_STATISTICS.getMessage());
        System.out.println(PARTITION_LINE.getMessage());
        for (ScoreInfo scoreInfo : scoreInfoWithoutElse) {
            System.out.println(scoreInfo.getMessage() + scoreBoard.get(scoreInfo.getRank()) + NUMBER_COUNT_UNITS.getMessage());
        }
    }
}
