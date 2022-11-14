package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;
import static lotto.Count.*;
import static lotto.Count.WinningCount;

public class Game {
    private final List<List<Integer>> GeneratedLotto = new ArrayList<>();
    private int nLottoPrice;
    private int nLotto;

    public int HowMuch() {
        System.out.println(ASK_PRICE);
        String price = Console.readLine();
        nLottoPrice = validatePrice(price);
        validate1000(nLottoPrice);
        nLotto = nLottoPrice / 1000;
        //Lotto exception 필요
        return nLotto;
    }

    public int validatePrice(String price){
        try{
            nLottoPrice = Integer.parseInt(price);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액(숫자)을 입력하세요");}
        return nLottoPrice;
    }

    public void validate1000(int nLottoPrice){
        if (nLottoPrice % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
        }
    }

    public void BuyLotto(int nLotto) {
        System.out.println("\n" + nLotto + SHOW_BUY_COUNT);
        for (int i = 0; i < nLotto; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            GeneratedLotto.add(lottoNumbers);
        }
    }

    public void PrintGeneratedLotto(int nLotto, List<List<Integer>> GeneratedLotto) {
        for (int i = 0; i < nLotto; i++) {
            System.out.println(GeneratedLotto.get(i));
        }
    }

    public List<Integer> inputJackpotNum() {
        System.out.println(ASK_WINNING_NUMBER);
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
        int[] WinTypeCounter = prize(winCounts, countBonus);
        PrintWinning(WinTypeCounter);
    }

    public int[] prize(List<Integer> WinningCount, int[] countBonus) {
        int counterSize = 5;
        int[] WinTypeCounter = new int[counterSize];
        for (int i = 0; i < WinningCount.size(); i++) {
            if (WinningCount.get(i) == 3) {
                WinTypeCounter[0] += 1;
            } else if (WinningCount.get(i) == 4) {
                WinTypeCounter[1] += 1;
            } else if (WinningCount.get(i) == 5 && countBonus[i] == 1) {
                WinTypeCounter[3] += 1;
            } else if (WinningCount.get(i) == 5) {
                WinTypeCounter[2] += 1;
            } else if (WinningCount.get(i) == 6) {
                WinTypeCounter[4] += 1;
            }
        }
        /**
         for (int i = 0; i < WinTypeCounter.length; i++) {    //counter 출력중
         System.out.print(WinTypeCounter[i]);
         }**/
        return WinTypeCounter;
    }

    public void PrintWinning(int[] WinTypeCounter) {
        float prizeMoney = getPrizeMoney(WinTypeCounter);
        float getPercent = (prizeMoney / nLottoPrice) * 100;

        System.out.println(WINNING_STATISTICS);
        System.out.println(THREE_MATCH + WinTypeCounter[0] + PIECE);
        System.out.println(FOUR_MATCH + WinTypeCounter[1] + PIECE);
        System.out.println(FIVE_MATCH + WinTypeCounter[2] + PIECE);
        System.out.println(FIVE_BONUS_MATCH + WinTypeCounter[3] + PIECE);
        System.out.println(SIX_MATCH + WinTypeCounter[4] + PIECE);
        System.out.println(TOTAL_YIELD + (Math.round(getPercent * 100) / 100.0) + "%입니다.");
    }

    public int getPrizeMoney(int[] WinTypeCounter) {
        int sum;
        sum = WinTypeCounter[0] * 5000 + WinTypeCounter[1] * 50000 + WinTypeCounter[2] * 1500000 +
                WinTypeCounter[3] * 30000000 + WinTypeCounter[4] * 2000000000;
        return sum;
    }
}
