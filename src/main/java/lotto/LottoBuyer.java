package lotto;

import lotto.CheckInputException;
import lotto.Util;
import lotto.Lotto;

import java.util.List;
import java.math.BigInteger;

import camp.nextstep.edu.missionutils.Console;

public class LottoBuyer {

    private Lotto lotto;
    private BigInteger money;

    public LottoBuyer(){
        lotto = null;
        money = null;
    }
    public void setMoney() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해주세요.");
        final String input = Console.readLine();

        try {
            CheckInputException.checkBuyerInputIsNotNumber(input);
            CheckInputException.checkBuyerInputIsMinus(input);
            CheckInputException.checkBuyerInputIsNotDivided(input);
        } catch (IllegalArgumentException iae) {
            throw iae;
        }
        money =  new BigInteger(input);
    }

    public void setLottoNumbers() throws IllegalArgumentException{
        System.out.println("당첨 번호를 입력해주세요.");
        final String input = Console.readLine();
        List<Integer> inputNumbers;

        try{
            CheckInputException.checkBuyerInputIsNotSixNumbers(input);
            inputNumbers = Util.splitInteger(input, ",");
            lotto = new Lotto(inputNumbers);
        }catch (IllegalArgumentException iae){
            throw iae;
        }
    }
}
