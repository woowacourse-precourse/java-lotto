package lotto.io;

import lotto.constants.LottoConstants;
import lotto.lottoChecker.WaysToWinAndRewards;
import lotto.numbers.Lotto;
import lotto.constants.ExceptionMessage;

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

    @Override
    public void tellLottoResult(int[] rankResult) {
        StringBuilder sb = new StringBuilder();
        for(int i = LottoConstants.LAST_RANK; i >= 1; i--) {
            WaysToWinAndRewards rank = WaysToWinAndRewards.findByRank(i);
            sb.append(rank.getMainNumberMatches());
            sb.append("개 일치");
            if(rank.isBonusNumberShouldMatch()) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append("(");
            sb.append(convertMoney(rank.getReward()));
            sb.append("원) - ");
            sb.append(rankResult[i]);
            sb.append("개\n");
        }
        System.out.println(sb.toString());
    }
    private String convertMoney(int money) {
        String str = String.valueOf(money);
        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            if(i != str.length() - 1 && (str.length() - i - 1) % 3 == 0) {
                sb.append(",");
            }
            sb.append(str.charAt(i));
        }
        return sb.reverse().toString();
    }
}
