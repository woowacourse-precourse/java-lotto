package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ExceptionConstant;
import lotto.constant.LottoConstant;
import lotto.domain.Player;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class NumberGenerator {

    List<List<Integer>> autoLotto;

    public int calculatorLottoQuantity(int purchasePrice) {
        return purchasePrice / LottoConstant.PRICE_UNIT;
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