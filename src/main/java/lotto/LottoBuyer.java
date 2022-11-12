package lotto;

import lotto.CheckInputException;
import lotto.Util;
import lotto.Lotto;

import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class LottoBuyer {

    private Lotto lotto;
    private BigInteger money;
    private Integer bonusNumber;

    private List<Lotto> lottos;
    public LottoBuyer() throws IllegalArgumentException {
        try {
            lottos = new ArrayList<Lotto>();
            setMoney();
            LottoMachine.buyLotto(lottos, money);
            LottoMachine.printLottoLog(lottos);
            setLottoNumbers();
            setBonusNumber();
        } catch(IllegalArgumentException iae){
            throw iae;
        }

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
            CheckInputException.checkBuyerInputIsNotFiveComma(input);
            CheckInputException.checkBuyerInputIsNotSixNumbers(input);
            inputNumbers = Util.splitInteger(input, ",");
            lotto = new Lotto(inputNumbers);
        }catch (IllegalArgumentException iae){
            throw iae;
        }
    }

    public void setBonusNumber() throws IllegalArgumentException{
        System.out.println("보너스 번호를 입력해 주세요.");
        final String input = Console.readLine();

        try{
            CheckInputException.checkBuyerInputIsNotNumberRange(input);
            CheckInputException.checkBuyerInputIsNotNumber(input);
            bonusNumber = Integer.valueOf(input);
        }catch(IllegalArgumentException iae){
            throw iae;
        }
    }

}
