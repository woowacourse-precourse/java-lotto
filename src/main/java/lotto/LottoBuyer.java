package lotto;

import lotto.CheckInputException;
import lotto.Util;

import java.util.List;
import java.math.BigInteger;

import camp.nextstep.edu.missionutils.Console;

public class LottoBuyer {

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

    public static List<Integer> inputLottoNumbers() throws IllegalArgumentException{
        final String input = Console.readLine();
        List<Integer> inputNumbers;

        try{
            CheckInputException.checkBuyerInputIsNotSixNumbers(input);
            inputNumbers = Util.splitInteger(input, ",");
        }catch (IllegalArgumentException iae){
            throw iae;
        }
        System.out.println(inputNumbers);
        return inputNumbers;
    }
}
