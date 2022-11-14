package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Count.*;
import static lotto.Count.WinningCount;
import static lotto.Lotto.BonusNumber;

public class Game {
    private final List<List<Integer>> GeneratedLotto = new ArrayList<>();
    private int nLottoPrice;
    private int nLotto;

    public int HowMuch() {
        System.out.println("구입 금액을 입력해 주세요.");
        String price = Console.readLine();
        nLottoPrice = Integer.parseInt(price);
        nLotto = nLottoPrice / 1000;
        //Lotto exception 필요
        return nLotto;
    }

    public void BuyLotto(int nLotto){
        System.out.println("\n" + nLotto + "개를 구매했습니다.");
        for (int i = 0; i < nLotto; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            GeneratedLotto.add(lottoNumbers);
        }
    }

    public void PrintGeneratedLotto(int nLotto, List<List<Integer>> GeneratedLotto){
        for (int i = 0; i < nLotto; i++) {
            System.out.println(GeneratedLotto.get(i));
        }
    }

    public List<Integer> inputJackpotNum(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winning = Console.readLine();
        String[] winningNumbers = winning.split(",");

        List<Integer> JackpotNumbers = new ArrayList<>();
        for (String winningNum : winningNumbers) {
            JackpotNumbers.add(Integer.parseInt(winningNum));
        }
        return JackpotNumbers;
    }

    public void Jackpot() {
        BuyLotto(HowMuch());
        PrintGeneratedLotto(nLotto, GeneratedLotto);
        List<Integer> JackpotNumbers = inputJackpotNum();

        Lotto lotto = new Lotto(JackpotNumbers);
        //System.out.println(lotto.getNumbers());

        lotto.askBonusNumber();
        int[] countBonus = BonusCount(GeneratedLotto);

        List<Integer> winCounts = WinningCount(GeneratedLotto, JackpotNumbers);
        //System.out.println(counts);
        int[] counter = prize(winCounts, countBonus);
        PrintWinning(counter);
    }

    public int[] prize(List<Integer> WinningCount, int[] countBonus) {
        int counterSize = 5;
        int[] counter = new int[counterSize];
        for (int i = 0; i < WinningCount.size(); i++) {
            if (WinningCount.get(i) == 3) {
                counter[0] += 1;
            } else if (WinningCount.get(i) == 4) {
                counter[1] += 1;
            } else if (WinningCount.get(i) == 5 && countBonus[i] == 1) {
                counter[3] += 1;
            } else if (WinningCount.get(i) == 5) {
                counter[2] += 1;
            } else if (WinningCount.get(i) == 6) {
                counter[4] += 1;
            }
        }
        for (int i = 0; i < counter.length; i++) {    //counter 출력중
            System.out.print(counter[i]);
        }
        return counter;
    }

    public void PrintWinning(int[] counter) {
        float prizeMoney = getPrizeMoney(counter);
        float getPercent = (prizeMoney/nLottoPrice)*100;

        System.out.print("\n\n당첨 통계\n---\n");
        System.out.printf("3개 일치 (5,000원) - %d개\n", counter[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", counter[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", counter[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", counter[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개", counter[4]);
        System.out.println("총 수익률은 "+(Math.round(getPercent*100)/100.0)+"%입니다.");
    }

    public int getPrizeMoney(int[] counter) {
        int sum;
        sum = counter[0] * 5000 + counter[1] * 50000 + counter[2] * 1500000 +
                counter[3] * 30000000 + counter[4] * 2000000000;
        return sum;
    }
}
