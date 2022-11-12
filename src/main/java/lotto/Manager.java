package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Manager {
    private List<List<Integer>> purchasedLottos;
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 45;
    static final int TOTAL_NUM = 6;

    public Manager() {
        purchasedLottos = new ArrayList<>();
    }

    /**
     * Receives input of purchase amount
     * @return number of lotto tickets
     * @throws IllegalArgumentException if invalid user input
     */
    private int purchase() throws IllegalArgumentException {
        System.out.println("구입 금액을 입력해주세요.");
        String amountInput = Console.readLine().trim();
        validateAmountInput(amountInput);
        return Integer.parseInt(amountInput) / 1000;
    }

    /**
     * Validates user input of purchasing amount
     * @param amountInput user input of purchasing amount
     * @throws IllegalArgumentException if input is not divisible by 1000 or not a number
     */
    public void validateAmountInput(String amountInput) throws IllegalArgumentException {

        int amount;

        try {
            amount = Integer.parseInt(amountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 금액은 숫자여야 합니다.");
        }

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 로또 한 장은 1000원 입니다. 1000원 단위의 숫자를 입력해주세요.");
        }
    }

    /**
     * Generate a single lotto ticket containing numbers
     * @param min min number of range
     * @param max max number of range
     * @param numCount number of digits to generate
     * @return Sorted list containing 6 number
     */
    private List<Integer> generateLottoNumber(int min, int max, int numCount) {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(min, max, numCount);
        lotto.sort(Comparator.naturalOrder());
        return lotto;
    }

    /**
     * Save all lists of lottos
     * @param lottoCount number of lottos purchased
     */
    public void setPurchasedLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            purchasedLottos.add(generateLottoNumber(MIN_NUM, MAX_NUM, TOTAL_NUM));
        }
    }

    /**
     * Returns List of purchased lottos
     * @return purchased lottos
     */
    public List<List<Integer>> getPurchasedLottos() {
        return purchasedLottos;
    }

    /**
     * Print all purchased lottos
     */
    private void showPurchasedLottos() {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (List<Integer> lotto : purchasedLottos) {
            System.out.println(lotto);
        }
    }

    /**
     * Initiate purchase process
     */
    public void start() {
        int lottoCount;
        try {
            lottoCount = purchase();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        setPurchasedLottos(lottoCount);
        showPurchasedLottos();
    }
}
