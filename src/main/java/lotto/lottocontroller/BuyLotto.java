package lotto.lottocontroller;

import camp.nextstep.edu.missionutils.Console;
import lotto.AllLottoMessage;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BuyLotto {
    private static final int INPUT_UNIT = 1000;
    private String price;

    public BuyLotto() {
        this.price = "";
    }

    private void inputMessage() {
        System.out.println(AllLottoMessage.INPUT_MONEY.getMessage());
    }

    private void buyNumberMessage() {
        System.out.println(AllLottoMessage.LINE_BREAK_CHARACTER.getMessage() + numberOfLottoCount() + AllLottoMessage.BUY_LOTTO.getMessage());
    }
    
    public void inputPrice() {
        inputMessage();
        price = Console.readLine();
        validateNumeric();
        validatePriceUnit();
        buyNumberMessage();
    }

    public int getPrice() {
        return Integer.parseInt(price);
    }

    private void validatePriceUnit() {
        if((Integer.parseInt(price) % INPUT_UNIT) != 0) {
            throw new IllegalArgumentException(AllLottoMessage.INVALIDATE_PRICE_UNIT.getMessage());
        }
    }

    private void validateNumeric() {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException invalidateNumeric) {
            System.out.println(AllLottoMessage.INVALIDATE_NUMERIC.getMessage());
            throw new NoSuchElementException();
        }
    }

    private int numberOfLottoCount() {
        return Integer.parseInt(price) / INPUT_UNIT;
    }

    public List<List<Integer>> issue () {
        LottoNumbers lottoNumbers = new LottoNumbers();

        List<List<Integer>> allLottoNumbers = new ArrayList<>();
        inputPrice();

        for (int issueNumberIndex = 0; issueNumberIndex < numberOfLottoCount(); issueNumberIndex++) {
            Lotto lotto = new Lotto(lottoNumbers.generator());
            lotto.printLotto();
            allLottoNumbers.add(lotto.setLotto());
        }

        return allLottoNumbers;
    }
}
