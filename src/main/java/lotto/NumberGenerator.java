package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberGenerator {
    List<List<Integer>> autoLotto;
    List<Integer> computerLotto;

    public NumberGenerator() {
        computerLotto = new ArrayList<>();
    }

    public int calculatorLottoQuantity(int purchasePrice) {
        return purchasePrice / Constant.PRICE_UNIT;
    }

    public int enterPurchasePrice() {
        String purchasePrice = Console.readLine();
        int purchasePriceInt = exceptionInvalidPurchasePrice(purchasePrice);
        exceptionDividedIntoThousands(purchasePriceInt);
        return purchasePriceInt;
    }

    public void enterLottoNumbers() {
        String lottoNumber = Console.readLine();
        exceptionInvalidLottoNumber(lottoNumber);
    }

    public List<Integer> addComputerNumber(List<String> computerLottoString) {
        return convertedLottoNumbers(computerLottoString);
    }

    public List<Integer> convertedLottoNumbers(List<String> computerLottoString) {
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
            Stream<Integer> sorted = Collections.unmodifiableCollection(lotto).stream().sorted();
            System.out.println(Arrays.toString(sorted.toArray()));
        }
    }

    private int exceptionInvalidPurchasePrice(String purchasePrice) {
        try {
            return Integer.parseInt(purchasePrice);
        } catch (NumberFormatException exception) {
            NoSuchElementException e = new NoSuchElementException();
            System.out.println(Constant.ERROR_MESSAGE + "구매금액은 숫자여야합니다.");
            throw e;
        }
    }

    public void exceptionDividedIntoThousands(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println(Constant.ERROR_MESSAGE + "구매금액은 1,000원으로 나누어 떨어져야 합니다.");
            throw e;
        }
    }

    private void exceptionInvalidLottoNumber(String lottoNumber) {
        try {
            String[] lottoNumbers = lottoNumber.split(",");
            computerLotto = addComputerNumber(new ArrayList<>(Arrays.asList(lottoNumbers)));
        } catch (NumberFormatException exception) {
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println(Constant.ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw e;
        }
    }
}