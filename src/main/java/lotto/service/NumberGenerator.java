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
        int purchasePriceInt = LottoException.exceptionInvalidPurchasePrice(purchasePrice);
        LottoException.exceptionDividedIntoThousands(purchasePriceInt);
        return purchasePriceInt;
    }

    public void enterLottoNumbers() {
        String inputLottoNumbers = Console.readLine();
        String[] lottoNumbers = LottoException.exceptionInvalidLottoNumber(inputLottoNumbers);
        computerLotto = addComputerNumber(new ArrayList<>(Arrays.asList(lottoNumbers)));
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
}