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
    private static final String INVALID_BONUS_INPUT =
            "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String NUMBER_DELIMETER = ",";
    private static final Integer LOTTO_PRICE = 1000;
    private Integer money;
    private List<Integer> winNumbers;
    private Integer bonusNumber;

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
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.SIZE);
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
        winNumbers = new ArrayList<>();
        for (String number : input.split(NUMBER_DELIMETER)) {
            winNumbers.add(Integer.parseInt(number));
        }
    }

    private void validateWinNumbers(String winNumbers) {
        String[] numbers = winNumbers.split(NUMBER_DELIMETER);
        try {
            List<Integer> lotto = new ArrayList<>();
            for (String number : numbers) {
                lotto.add(Integer.parseInt(number));
            }
            new Lotto(lotto);
        } catch (NumberFormatException ignored) {
            LottoError.illegalArgumentException(INVALID_STRING_INPUT);
        }
    }

    public void inputBonusNumber() {
        try {
            Integer input = Integer.parseInt(Console.readLine());
            validateBonusNumber(input);
            this.bonusNumber = input;
        } catch (NumberFormatException ignored) {
            LottoError.illegalArgumentException(INVALID_STRING_INPUT);
        }
    }

    private void validateBonusNumber(Integer number) {
        if (winNumbers.contains(number)) {
            LottoError.illegalArgumentException(INVALID_BONUS_INPUT);
        }
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            LottoError.illegalArgumentException(Lotto.INVALID_RANGE_INPUT);
        }
    }
}
