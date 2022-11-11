package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {

    List<List<Integer>> userLottos;
    List<Integer> computerLotto;

    public NumberGenerator() {
        computerLotto = new ArrayList<>();
    }

    public int calculatorLottoNumber(int purchasePrice) {
        return purchasePrice / Constant.PRICE_UNIT;
    }

    public int enterPurchasePrice() {
        String purchasePrice = Console.readLine();
        return Integer.parseInt(purchasePrice);
    }

    public void enterLottoNumbers() {
        exceptionInvalidLottoNumber();
    }

    public int enterBonusNumber() {
        return exceptionInvalidBonusNumber();
    }

    private List<Integer> addComputerNumber(List<String> computerLottoString) {
        return convertedLottoNumbers(computerLottoString);
    }

    private List<Integer> convertedLottoNumbers(List<String> computerLottoString) {
        return computerLottoString.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public void operationLotto(int purchaseQuantity) {
        userLottos = new ArrayList<>(purchaseQuantity);
        createLottoNumbers(purchaseQuantity);
        printLottoNumbers();
    }

    private void createLottoNumbers(int purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottos.add(integers);
        }
    }

    private void printLottoNumbers() {
        for (List<Integer> lotto : userLottos) {
            System.out.println(lotto);
        }
    }

    private void exceptionInvalidLottoNumber() {
        try {
            String[] lottoNumbers = Console.readLine().split(",");
            computerLotto = addComputerNumber(new ArrayList<>(Arrays.asList(lottoNumbers)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 문자 또는 값을 비워 둘 수 없습니다.");
        }
    }

    private int exceptionInvalidBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호에 문자 또는 값을 비워 둘 수 없습니다.");
        }
    }
}

/**
 * 8개를 구매했습니다.
 * [8, 21, 23, 41, 42, 43]
 * [3, 5, 11, 16, 32, 38]
 * [7, 11, 16, 35, 36, 44]
 * [1, 8, 11, 31, 41, 42]
 * [13, 14, 16, 38, 42, 45]
 * [7, 11, 30, 40, 42, 43]
 * [2, 13, 22, 32, 38, 45]
 * [1, 3, 5, 14, 22, 45]
 *
 * 당첨 번호를 입력해 주세요.
 * 1,2,3,4,5,6
 *
 * 보너스 번호를 입력해 주세요.
 * 7
 *
 * 당첨 통계
 * ---
 * 3개 일치 (5,000원) - 1개
 * 4개 일치 (50,000원) - 0개
 * 5개 일치 (1,500,000원) - 0개
 * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 * 6개 일치 (2,000,000,000원) - 0개
 * 총 수익률은 62.5%입니다.
 */