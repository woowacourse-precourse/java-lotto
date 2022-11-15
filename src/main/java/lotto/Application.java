package lotto;

import java.util.List;
import lotto.domain.Generator;
import lotto.domain.Lotto;
import lotto.view.Parser;
import lotto.view.Statistics;

public class Application {
    public static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String INPUT_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String STATICS_MESSAGE = "당첨 통계\n---";

    public static void main(String[] args) {
        play();
        // TODO: 프로그램 구현
    }

    public static void play(){
        System.out.println(START_MESSAGE);
        Parser parser = new Parser();
        int count = parser.getCount();
        System.out.println(count + PURCHASE_MESSAGE);
        Generator generator = new Generator(count);
        List<List<Integer>> tickets = generator.getTickets();
        tickets.stream().forEach(System.out::println);
        System.out.println(INPUT_LOTTO_MESSAGE);
        Lotto lotto = parser.getLotto();
        System.out.println(INPUT_BONUS_MESSAGE);
        List<Integer> lottoNumbers = lotto.getNumbers();
        Integer bonusNumber = parser.getBonus(lotto).getNumber();
        System.out.println(STATICS_MESSAGE);
        Statistics.printReward(tickets, lottoNumbers, bonusNumber);
        Statistics.printProfitRate(tickets,lottoNumbers, bonusNumber);
    }

}
