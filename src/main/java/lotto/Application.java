package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값을 입력하였습니다.";
    private static final String MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위입니다.";
    private static final String LOTTO_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개입니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATED_ERROR_MESSAGE = "[ERROR] 중복된 로또 번호가 존재합니다.";

    public static void main(String[] args) {
        int inputMoney = 0;
        List<Lotto> lottos = new ArrayList<>();
        String userInput = Console.readLine();

        try {
            inputMoney = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }

        if (inputMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }

        for (int cnt = 0, lottoQuantity = inputMoney / LOTTO_PRICE; cnt < lottoQuantity; cnt++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT));
            lottos.add(lotto);
        }

        userInput = Console.readLine();
        Set<Integer> winningNumbers = new HashSet<>();
        String[] inputNumbers = userInput.split(",");

        if (inputNumbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }

        for (int cnt = 0; cnt < LOTTO_NUMBER_COUNT; cnt++) {
            int currNum;

            try {
                currNum = Integer.parseInt(inputNumbers[cnt].trim());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
            }

            if (currNum < MIN_LOTTO_NUMBER || currNum > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }

            winningNumbers.add(currNum);

            if (winningNumbers.size() != cnt + 1) {
                throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_ERROR_MESSAGE);
            }
        }

        userInput = Console.readLine();
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(userInput.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }

        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_ERROR_MESSAGE);
        }
    }
}
