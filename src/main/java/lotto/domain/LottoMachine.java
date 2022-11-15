package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {

    private List<Integer> generateLottoNumbers(int startFrom, int endTo, int size) {
        HashSet<Integer> numberSet =
                new HashSet<Integer>(Randoms.pickUniqueNumbersInRange(startFrom, endTo, size));
        List<Integer> numbers = new ArrayList<Integer>(numberSet);
        Collections.sort(numbers);
        return numbers;
    }

    private boolean isValidUnit(int money) {
        if (Math.floorMod(money, LottoConstant.PRICE.getValue()) == 0) return true;
        return false;
    }

    private int countPurchaseQuantity(int money) {
        if (!isValidUnit(money)) {
            System.out.println(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
            throw new IllegalArgumentException();
        }
        return Math.floorDiv(money, LottoConstant.PRICE.getValue());
    }

    public List<Lotto> sellLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int money = LottoInputFilter.readPurchaseAmount();
        int quantity = countPurchaseQuantity(money);
        System.out.println(String.format("%d개를 구매했습니다.", quantity));

        for (int i = 0; i < quantity; i++) {
            lottos.add(
                    new Lotto(generateLottoNumbers(
                            LottoConstant.STARTFROM.getValue(),
                            LottoConstant.ENDTO.getValue(),
                            LottoConstant.SIZE.getValue()
                    )));
            System.out.println(lottos.get(i).getLottoNumbers());
        }
        return lottos;
    }

}
