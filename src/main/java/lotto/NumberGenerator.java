package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class NumberGenerator {
    List<List<Integer>> autoLotto;
    List<Integer> computerLotto;
    int bonusNumber;

    public NumberGenerator() {
        computerLotto = new ArrayList<>();
    }

    public int calculatorLottoNumber(int purchasePrice) {
        return purchasePrice / Constant.PRICE_UNIT;
    }

    public int enterPurchasePrice() {
        int purchasePrice = exceptionInvalidPurchasePrice();
        exceptionDividedIntoThousands(purchasePrice);
        return purchasePrice;
    }

    public void enterLottoNumbers() {
        exceptionInvalidLottoNumber();
    }

    public void enterBonusNumber() {
        bonusNumber = exceptionInvalidBonusNumber();
    }

    private List<Integer> addComputerNumber(List<String> computerLottoString) {
        return convertedLottoNumbers(computerLottoString);
    }

    private List<Integer> convertedLottoNumbers(List<String> computerLottoString) {
        return computerLottoString.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public void createLottos(int purchaseQuantity) {
        autoLotto = new ArrayList<>(purchaseQuantity);
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            autoLotto.add(integers);
        }
    }

    public void printLottos(List<List<Integer>> autoLotto) {
        for (List<Integer> lotto : autoLotto) {
            Collections.sort(lotto);
            System.out.println(Arrays.toString(lotto.toArray()));
        }
    }

    private int exceptionInvalidPurchasePrice() {
        String purchasePrice = Console.readLine();
        try {
            return Integer.parseInt(purchasePrice);
        } catch (NumberFormatException exception) {
            NoSuchElementException e = new NoSuchElementException();
            System.out.println(Constant.ERROR_MESSAGE + "구매금액은 숫자여야합니다.");
            throw e;
        }
    }

    private void exceptionDividedIntoThousands(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println(Constant.ERROR_MESSAGE + "구매금액은 1,000원으로 나누어 떨어져야 합니다.");
            throw e;
        }
    }

    private void exceptionInvalidLottoNumber() {
        try {
            String[] lottoNumbers = Console.readLine().split(",");
            computerLotto = addComputerNumber(new ArrayList<>(Arrays.asList(lottoNumbers)));
        } catch (NumberFormatException exception) {
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println(Constant.ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw e;
        }
    }

    private int exceptionInvalidBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println(Constant.ERROR_MESSAGE + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw e;
        }
    }
}