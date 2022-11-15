package lotto.io;

import lotto.Lotto;
import lotto.constants.ExceptionMessage;
import lotto.constants.LottoConstants;

import java.util.List;

public class StaffTellerImpl implements  StaffTeller{
    @Override
    public void tellPurchasedNumberOfLotto(int numberOfLottoPurchased) {
        System.out.printf("%d개를 구매했습니다.%n", numberOfLottoPurchased);
    }

    @Override
    public void tellLottos(List<Lotto> lottos) {
        if(lottos == null) {
            throw new IllegalArgumentException(ExceptionMessage.NO_LOTTO_NUMBERS);
        }
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            printOneLotto(numbers, sb);
        }
        System.out.println(sb.toString());
    }

    private void printOneLotto(List<Integer> numbers, StringBuilder sb) {
        sb.append("[");
        for(int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if(i < numbers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        sb.append("\n");
    }
}
