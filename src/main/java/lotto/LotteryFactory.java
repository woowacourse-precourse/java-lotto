package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryFactory {
    final static String INFORMATION_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    final static String INFORMATION_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    final static String INFORMATION_ERROR_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";


    private final Map<LotteryRank, Integer> ranks;

    // 생성자(EnumMap)
    public LotteryFactory() {
        this.ranks = new EnumMap<>(LotteryRank.class);
        for (LotteryRank rank : LotteryRank.values()) {
            this.ranks.put(rank, 0);
        }
    }

    public void printLotteryNumber(List<Lotto> lotteryTickets) {
        System.out.println(lotteryTickets.size() + "개를 구매했습니다.");

        for(Lotto lotteryTicket : lotteryTickets) {
            lotteryTicket.sortNumbers();
        }
    }

    private int getWinningStats() {
        int accumulatedReward = 0;
        for( LotteryRank rank : this.ranks.keySet() ) {
            int matches = rank.getMatches();
            int reward = rank.getReward();
            accumulatedReward += (reward * this.ranks.get(rank));

            DecimalFormat decFormat = new DecimalFormat("###,###");
            if( rank == LotteryRank.SIXTH_PLACE ) {
                continue;
            }
            if ( rank == LotteryRank.SECOND_PLACE ) {
                System.out.println(matches + "개 일치, 보너스 볼 일치 (" + decFormat.format(reward) + "원) - " + this.ranks.get(rank) + "개");
                continue;
            }

            System.out.println(matches + "개 일치 (" + decFormat.format(reward) + "원) - " + this.ranks.get(rank) + "개");
        }

        return accumulatedReward;
    }

    private void getRateOfReturn(int reward, int money) {
        double rateOfReturn = (reward / (double)money) * 100;
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public Integer checkMoney(String inputMoney) {
        Integer money ;

        try {
            money = Integer.parseInt(inputMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 입력해주세요.");
        }
        return money ;
    }

    public List<Lotto> getLotteryTicket(Integer money) {
        if ( 0 != (money % 1000) ) {
            throw new IllegalArgumentException(INFORMATION_ERROR_PURCHASE_AMOUNT);
        }

        List<Lotto> lotteryTicket = new ArrayList<>();

        Integer theNumberOfLottery = money / 1000;

        for(int i = 0; i < theNumberOfLottery; ++i) {
            Lotto numbers = new Lotto( Randoms.pickUniqueNumbersInRange(1, 45, 6) );
            lotteryTicket.add(numbers);
        }

        return lotteryTicket;
    }

    public List<Integer> getWinningNumber() {
        System.out.println(INFORMATION_INPUT_WINNING_NUMBER);

        List<Integer> winningNumber = Stream.of(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return Collections.unmodifiableList(winningNumber);
    }

    public Integer getBonusNumber() {
        System.out.println(INFORMATION_INPUT_BONUS_NUMBER);
        Integer bonusNumber = Integer.valueOf( Console.readLine() );

        return bonusNumber;
    }

    public void CompareLotteryNumbersAndWinningNumbers(WinningNumber winningNumber, List<Lotto> lotteryTickets) {
        for(Lotto lotteryTicket : lotteryTickets) {
            int matchesLotteryNumber = winningNumber.compareLotteryNumber( lotteryTicket );
            boolean matchesBonusNumber = winningNumber.compareBonusNumber( lotteryTicket );

            LotteryRank rank = LotteryRank.getRank(matchesLotteryNumber, matchesBonusNumber);
            ranks.put(rank, ranks.get(rank) + 1);
        }
    }

    public void printWinningStats(int money) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int reward = getWinningStats();
        getRateOfReturn(reward, money);
    }
}
