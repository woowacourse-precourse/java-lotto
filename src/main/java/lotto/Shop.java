package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private static final String INVALID_MONEY_INPUT =
            "구매 금액은 1,000 단위로 나누어 떨어져야 합니다.";
    private static final String INVALID_STRING_INPUT =
            "숫자만 입력할 수 있습니다.";
    private static final String INVALID_SIZE_INPUT =
            "6개의 숫자를 입력해야 합니다.";
    private static final String NUMBER_DELIMETER = ",";
    private static final Integer LOTTO_PRICE = 1000;
    private Integer money;
    private List<Integer> winNumbers;

    public void inputMoney() {
        String money = Console.readLine();
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        try {
            Integer nMoney = Integer.parseInt(money);
            if (nMoney % LOTTO_PRICE != 0) {
                LottoError.illegalArgumentException(INVALID_MONEY_INPUT);
            }
        } catch (NumberFormatException ignored) {
            LottoError.illegalArgumentException(INVALID_STRING_INPUT);
        }
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private Lotto createLotto() {
        return new Lotto(createLottoNumbers());
    }

    public List<Lotto> sellLotto() {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < money; i++) {
            lotto.add(createLotto());
        }
        return lotto;
    }

    public void inputWinNumbers() {
        String input = Console.readLine();
        validateWinNumbers(input);
    }

    private void validateWinNumbers(String winNumbers) {
        String[] numbers = winNumbers.split(NUMBER_DELIMETER);
        if (numbers.length != 6) {
            LottoError.illegalArgumentException(INVALID_SIZE_INPUT);
        }
        try {
            for (String number : numbers) {
                Integer.parseInt(number);
            }
        } catch (NumberFormatException ignored) {
            LottoError.illegalArgumentException(INVALID_STRING_INPUT);
        }
    }

}
