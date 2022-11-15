package lotto;
import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    public static void main(String[] args) {
        int lotto_cnt = getMoney();
        List<Lotto> lotto_list = new ArrayList<>();;
        for(int i =0 ; i<lotto_cnt;i++){
            lotto_list.add(getLotto());
           System.out.println(lotto_list.get(i).getNumbers());
        }
        WinLotto win_lotto = new WinLotto(getWinLotto(), getBonusNum());
        lottoResult(lotto_list, win_lotto, lotto_cnt);
    }
    public static Lotto getLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new lotto.Lotto(numbers);
        return lotto;
    }

    public static Lotto getWinLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        List<String> input_string_list = new ArrayList<String>(Arrays.asList(input.split(",")));
        List<Integer> input_integer_list = input_string_list.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        Lotto lotto = new lotto.Lotto(input_integer_list);
        return lotto;
    }

    public static int getBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return Integer.parseInt(input);
    }

    public static int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        int input_money = Integer.parseInt(input);
        return input_money/1000;
    }



    private static void lottoResult(List<Lotto> lottoList, WinLotto winningLotto, int lottoAmount) {
        Map<Rank, Integer> result = setResult();
        Rank rank;

        System.out.println("당첨 통계\n----------");
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, lottoAmount);
    }
    private static Map<Rank, Integer> setResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private static void printEarningRate(Map<Rank, Integer> result, int lottoAmount) {
        double EarningRate = 0;

        for (Rank rank : result.keySet()) {
            EarningRate += (double) ((rank.getWinningMoney()) / (lottoAmount * TICKET_PRICE)) * result.get(rank) * PERCENTAGE;
        }
        System.out.println("총 수익률은 " + String.format("%.3f", EarningRate) + "%입니다.");
    }
    private static void printResult(Map<Rank, Integer> result) {
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank.values()[i].printMessage(result.get(Rank.values()[i]));
        }
    }

}
