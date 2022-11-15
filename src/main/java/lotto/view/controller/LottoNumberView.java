package lotto.view.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.vlidation.InputCorrectLottoValidator;

import java.util.List;

import static lotto.utils.ConvertUtil.convertInputToIntegerList;
import static lotto.view.controller.ConsoleMessage.*;
import static lotto.view.vlidation.InputMoneyValidator.validateBlank;

public class LottoNumberView {

    private LottoNumberView() {
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println(INPUT_CORRECT_LOTTO_MONEY);
        String input = Console.readLine();
        validateBlank(input);
        List<Integer> newLottoNumber = convertInputToIntegerList(input);
        InputCorrectLottoValidator.validate(newLottoNumber);
        return newLottoNumber;
    }

    public static void printTotalLottoCount(int lottoCount) {
        System.out.println(String.valueOf(lottoCount) + NUMBER_COUNT_UNITS + PRINT_BUY);
    }

    public static void printLottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }
}
