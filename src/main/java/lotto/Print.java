package lotto;

import java.util.List;

public class Print {
    public void infoLottos(List<Lotto> lottos){
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }

}
