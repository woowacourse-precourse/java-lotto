package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

/***
 * 로또의 갯수와 랜덤수를 구하는 클래스
 */
public class LottoManager {
    private static final String ERROR = "[ERROR]";
    private static final String ENTERNUMBER = "숫자를 입력해주세요.";
    private static final String RESTNUMBER = "나머지가 있습니다.";
    private static final String NOTENOUGHMONEY = "금액이 부족합니다.";
    private static final int LOTTOSTARTNUMBER = 1;
    private static final int LOTTOLASTNUMBER = 45;
    private static final int LOTTOCOUNT = 6;
    private static final int LOTTOPRICE = 1000;

    public LottoManager() {
    }

    public int countLotto(String inputMoney) {
        int money = isNumberic(inputMoney);
        hasRestError(money);
        MinimumAmountError(money);
        return money / LOTTOPRICE;
    }

    public int isNumberic(String inputMoney) {
        if (inputMoney == null || inputMoney.matches("[-+]?\\d*\\.?\\d+") == false) {
            System.out.println(ERROR + ENTERNUMBER);
            throw new NoSuchElementException(ERROR + ENTERNUMBER);
        }
        return Integer.parseInt(inputMoney);
    }

    public void hasRestError(int money) {
        if (money % LOTTOPRICE != 0) {
            throw new IllegalArgumentException(ERROR + RESTNUMBER);
        }
    }

    public void MinimumAmountError(int money) {
        if (money < LOTTOPRICE) {
            throw new IllegalArgumentException(ERROR + NOTENOUGHMONEY);
        }
    }

    public List<List<Integer>> buyerLottoNumbers(int lottoCount) {
        List<List<Integer>> randomNumbers = new ArrayList<>();
        int cnt = 0;
        while (cnt < lottoCount) {
            List<Integer> randomNumber = makeRandomNumber();
            if (isNotDuplication(randomNumber)) {
                Collections.sort(randomNumber);
                randomNumbers.add(randomNumber);
                cnt++;
            }
        }
        return randomNumbers;
    }

    public List<Integer> makeRandomNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTOSTARTNUMBER, LOTTOLASTNUMBER, LOTTOCOUNT));
        return numbers;
    }

    public boolean isNotDuplication(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            return false;
        }
        return true;
    }

}
