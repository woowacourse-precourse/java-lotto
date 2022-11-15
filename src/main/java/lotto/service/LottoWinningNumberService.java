package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoWinningNumber;
import lotto.utils.Parser;

import java.util.List;

import static lotto.enumtype.LottoInterfaceMsg.*;

public class LottoWinningNumberService {
    private static final String DELIMITER = ",";

    public LottoWinningNumber setLottoWinningNumber() {
        return new LottoWinningNumber(requestWinningNumbers(), requestBonusNumber());
    }

    private List<Integer> requestWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBER.getMessage());
        String input = Console.readLine().replace(" ", "");
        return Parser.getListOfIntegerSplitToString(input, DELIMITER);
    }

    private int requestBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        return Parser.parseInt(input);
    }
}
