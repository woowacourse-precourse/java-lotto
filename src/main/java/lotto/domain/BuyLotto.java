package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {

    public InPutSystem inPutSystem = new InPutSystem();

    public static final int LOTTO_PRICE = 1000;

    public List<List<Integer>> lottoList = new ArrayList<>();
    public static int cntLotto = 0;

    public BuyLotto() {

    }

    public void calculateLotto(int price) {
        cntLotto = price / LOTTO_PRICE;

        // 예외 처리 필요 ( 1000 단위 )
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PrintMessages.ERROR_MONEY_RANGE.getMessage());
        }
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(PrintMessages.ERROR_MONEY_MIN.getMessage());
        }
    }

    public void inputPrice() {
        int price = Integer.parseInt(inputSystem());
        calculateLotto(price);
    }

    public void GenerateLottoNumber() {
        for (int i = 0; i < cntLotto; i++) {
            List<Integer> randomList = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(randomList);
            Lotto lotto = new Lotto(randomList);
            lottoList.add(lotto.getNumbers());
        }
    }

    public String inputSystem() {
        String input = Console.readLine();
        validateNumberCheck(input);
        return input;
    }

    public void validateNumberCheck(String inputNumber) {
        for (char input : inputNumber.toCharArray()) {
            if (!Character.isDigit(input)) {
                throw new IllegalArgumentException(PrintMessages.ERROR_NUMBER.getMessage());
            }
        }
    }
}
