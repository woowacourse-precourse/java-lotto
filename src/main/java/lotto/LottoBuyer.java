package lotto;

import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class LottoBuyer {

    private Lotto lotto;
    private BigInteger money;
    private Integer bonusNumber;
    private List<Lotto> lottos;

    public LottoBuyer() {

    }

    public void setBuyer() throws IllegalArgumentException {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            setMoney();
            lottos = new ArrayList<>();
            int buyCount = LottoMachine.buyLotto(lottos, money);
            System.out.println(buyCount + "개를 구매했습니다.");
            LottoMachine.printLottoLog(lottos);
            System.out.println("당첨 번호를 입력해주세요.");
            setLottoNumbers();
            System.out.println("보너스 번호를 입력해 주세요.");
            setBonusNumber();
        } catch (IllegalArgumentException iae) {
            throw iae;
        }
    }

    public void setMoney() throws IllegalArgumentException {
        final String input = Console.readLine();

        try {
            CheckInputException.checkBuyerInputIsNotNumber(input);
            CheckInputException.checkBuyerInputIsMinus(input);
            CheckInputException.checkBuyerInputIsNotDivided(input);
        } catch (IllegalArgumentException iae) {
            throw iae;
        }
        money = new BigInteger(input);
    }

    public void setLottoNumbers() throws IllegalArgumentException {
        final String input = Console.readLine();
        List<Integer> inputNumbers;

        try {
            CheckInputException.checkBuyerInputIsNotFiveComma(input);
            CheckInputException.checkBuyerInputIsNotSixNumbers(input);
            inputNumbers = Util.splitInteger(input, ",");
            lotto = new Lotto(inputNumbers);
        } catch (IllegalArgumentException iae) {
            throw iae;
        }
    }

    public void setBonusNumber() throws IllegalArgumentException {
        final String input = Console.readLine();

        try {
            CheckInputException.checkBuyerInputIsNotNumberRange(input);
            CheckInputException.checkBuyerInputIsNotNumber(input);
            bonusNumber = Integer.valueOf(input);
            List<Integer> tmpNumbers = new ArrayList<>(lotto.getLottoNumbers());
            tmpNumbers.add(bonusNumber);
            CheckInputException.checkDuplicateNumbers(tmpNumbers);
        } catch (IllegalArgumentException iae) {
            throw iae;
        }
    }

    public BigInteger getMoney() {
        return money;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

}
