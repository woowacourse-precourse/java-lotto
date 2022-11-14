package lotto;

import java.util.*;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class LottoStore {
    private static final String BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BOUGHT_NUMBER_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---\n" +
            "3개 일치 (5,000원) - %d개\n" + "4개 일치 (50,000원) - %d개\n" + "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" + "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String RATE_OF_RETURN1 = "총 수익률은 %s";
    private static final String RATE_OF_RETURN2 = "%입니다.";
    private static final int LOTTO_NUMBER = 6;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final int FOURTH = 3;
    private static final int FIFTH = 4;

    private List<Ranking> rankings;
    private List<Integer> numberOfRanking;
    private List<ArrayList<Integer>> buyer;
    private List<Integer> lotto;
    private int bonusNumber;
    private boolean hasBonusNumber;

    public LottoStore() {}

    public void buyAndDraw() {
        String buyAmount = buyLotto();
        if(buyAmount.equals("0")) {
            return;
        }
        inputWinningNumbers();
        inputBonusNumber();
        draw();
        printRateOfReturn(buyAmount);
    }

    private void printRateOfReturn(String buyAmount) {
        findNumberOfRanking();
        System.out.printf(WINNING_STATISTICS, numberOfRanking.get(FIFTH), numberOfRanking.get(FOURTH),
                numberOfRanking.get(THIRD), numberOfRanking.get(SECOND), numberOfRanking.get(FIRST));
        int prizeMoney = calculatePrize();
        String rate = calculateRate(buyAmount, prizeMoney);
        System.out.printf(RATE_OF_RETURN1, rate);
        System.out.println(RATE_OF_RETURN2);
    }

    private int calculatePrize() {
        int prizeMoney = 0;

        for(int i=0; i<LOTTO_NUMBER; i++) {
            prizeMoney += Ranking.values()[i].getPrize() * numberOfRanking.get(i);
        }
        return prizeMoney;
    }

    private String calculateRate(String buyAmount, int prizeMoney) {
        int buy = Integer.parseInt(buyAmount);
        Double rate = (prizeMoney*1.0 / buy) * 100;
        String rateString = String.format("%.1f", rate);
        return rateString;
    }

    private void findNumberOfRanking() {
        numberOfRanking = new ArrayList<>();
        for(Ranking ranking : Ranking.values()) {
            int count = Collections.frequency(rankings, ranking);
            numberOfRanking.add(count);
        }
    }

    private void draw() {
        rankings = new ArrayList<>();
        for(int i = 0 ; i < buyer.size() ; i++) {
            int count = calculateNumbers(buyer.get(i));
            hasBonusNumber = hasBonusNumber(buyer.get(i));
            rankings.add(Ranking.rankingOfLabel(count, hasBonusNumber));
        }
    }

    private int calculateNumbers(List<Integer> buyersLotto) {
        int count = 0;

        for(int i = 0 ; i < LOTTO_NUMBER ; i++) {
            int number = lotto.get(i);
            if(buyersLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasBonusNumber(List<Integer> buyersLotto) {
        if(buyersLotto.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private String buyLotto() {
        buyMessage();
        String buyAmount = Console.readLine();
        Buyer lottoLists = new Buyer();
        lottoLists.setListOfLotto(buyAmount);
        buyer = lottoLists.getListOfNumbers();

        if(buyer.size() == 0){
            return "0";
        }
        printBoughtLotto();
        return buyAmount;
    }

    private void printBoughtLotto() {
        System.out.printf(BOUGHT_NUMBER_MESSAGE, buyer.size());

        for(int i = 0 ; i < buyer.size() ; i++){
            System.out.println(buyer.get(i));
        }
    }

    private void buyMessage() {
        System.out.println(BUY_MESSAGE);
    }

    private void inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine();
        List<Integer> winningNumbers = stringToIntegerList(input);
        Lotto lotto = new Lotto(winningNumbers);
        this.lotto = lotto.getNumbers();
    }

    private void inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        bonusNumber = Integer.parseInt(input);
    }

    private List<Integer> stringToIntegerList(String string) {
        String[] numbers = string.split(",");
        List<Integer> newNumbers = Arrays.asList(numbers).stream()
                                    .map(s -> Integer.parseInt(s))
                                    .collect(Collectors.toList());
        return newNumbers;
    }
}
