package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int price;
    private float earningRate;
    private int[] winningCount= new int[5];;


    public User(int price) {
        validatePrice(price);
        this.price = price;

        lottos = new ArrayList<Lotto>();
        int countLottos = price/1000;

        for (int i=0; i<countLottos;i++){
            lottos.add(new Lotto(createNumbers()));
        }
        System.out.printf("%d개를 구매했습니다.\n", countLottos);
    }

    private void validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 음수일 수 없습니다.");
        }
        if (price <= 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1000원입니다.");
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력 할 수 있습니다.");
        }
    }

    private List<Integer> createNumbers() {
        List<Integer> numbers =Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
    public void printNumbersOfLottos(){
        for (Lotto lotto: this.lottos) {
            lotto.printNumbers();
        }
    }
}
