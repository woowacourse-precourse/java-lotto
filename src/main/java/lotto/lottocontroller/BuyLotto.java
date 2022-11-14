package lotto.lottocontroller;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BuyLotto {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String INVALIDATE_PRICE_UNIT_MESSAGE = "[ERROR] 구매금액은 1000원 단위여야 합니다.";
    private static final String INVALIDATE_NUMERIC_MESSAGE = "[ERROR] 구매금액은 숫자여야 합니다.";
    private static final int INPUT_UNIT = 1000;
    private String price;

    public BuyLotto() {
        this.price = "";
    }

    private void inputMessage() {
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    private void buyNumberMessage() {
        System.out.println("\n" + numberOfLottoCount() + BUY_LOTTO_MESSAGE);
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
            throw new IllegalArgumentException(INVALIDATE_PRICE_UNIT_MESSAGE);
        }
    }

    private void validateNumeric() {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException invalidateNumeric) {
            System.out.println(INVALIDATE_NUMERIC_MESSAGE);
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
