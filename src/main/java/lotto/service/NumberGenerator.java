package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ExceptionConstant;
import lotto.constant.LottoConstant;

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
        return purchasePrice / LottoConstant.PRICE_UNIT;
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

    private int exceptionInvalidPurchasePrice(String purchasePrice){

        try {
            return Integer.parseInt(purchasePrice);
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.INVALID_PURCHASE_PRICE);
        }
    }

    public void exceptionDividedIntoThousands(int purchasePrice) throws IllegalArgumentException{
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.INCORRECT_DIVIDED_PURCHASE_PRICE);
        }
    }

    private void exceptionInvalidLottoNumber(String lottoNumber) throws IllegalArgumentException{
        try {
            String[] lottoNumbers = lottoNumber.split(",");
            computerLotto = addComputerNumber(new ArrayList<>(Arrays.asList(lottoNumbers)));
        } catch (NumberFormatException exception) {
            throw new IllegalStateException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.INVALID_LOTTO_RANGE);
        }
    }
}