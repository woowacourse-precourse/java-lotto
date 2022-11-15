package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private List<Integer> generateLottoNumbers(int startFrom, int endTo, int size) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startFrom, endTo, size);
        Collections.sort(numbers);
        return numbers;
    }

    private int countPurchaseQuantity(int money) {
        if (Math.floorMod(money, LottoConstant.PRICE.getValue()) != 0) {
            System.out.println(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
            throw new IllegalArgumentException();
        }
        else if (Math.floorDiv(money, LottoConstant.PRICE.getValue()) == 0) {
            System.out.println(ErrorMessage.MINIMUM_PURCHASE_QUANTITY.getMessage());
            throw new IllegalArgumentException();
        }
        return Math.floorDiv(money, LottoConstant.PRICE.getValue());
    }

    private int readPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int money = Integer.valueOf(Console.readLine());
            if (money < 0) {
                System.out.println(ErrorMessage.NON_POSITIVE_AMOUNT.getMessage());
                throw new IllegalArgumentException();
            }
            return money;
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.NON_NUMERIC_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> sellLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int money = readPurchaseAmount();
        int quantity = countPurchaseQuantity(money);
        System.out.println(String.format("%d개를 구매했습니다.", quantity));

        for (int i = 0; i < quantity; i++) {
            lottos.add(
                    new Lotto(generateLottoNumbers(
                            LottoConstant.STARTFROM.getValue(),
                            LottoConstant.ENDTO.getValue(),
                            LottoConstant.SIZE.getValue()
                    )));
            System.out.println(lottos.get(lottos.size()-1).getLottoNumbers());
        }
        return lottos;
    }

}
