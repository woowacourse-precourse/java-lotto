package lotto.outputview;

import java.util.List;

public class OutputLottos {
    public void printMsg(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLotto(List numbers) {
        System.out.println(numbers);
    }
}
