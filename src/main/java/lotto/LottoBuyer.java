package lotto;

import lotto.CheckInputException;
import lotto.Util;

import java.math.BigInteger;

import camp.nextstep.edu.missionutils.Console;

public class LottoBuyer {

    String input = Console.readLine();
    public static BigInteger inputMoney() throws IllegalArgumentException{
        final String input = Console.readLine();

        try {
            CheckInputException.checkBuyerInputIsNotNumber(input);
            CheckInputException.checkBuyerInputIsMinus(input);
            CheckInputException.checkBuyerInputIsNotDivided(input);
        } catch (IllegalArgumentException iae) {
            throw iae;
        }
        return new BigInteger(input);
    }
}
