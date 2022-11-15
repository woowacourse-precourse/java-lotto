package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCheck {
    private final int bonusNum;
    private List<List<Integer>> lottoNums;
    private List<Integer> winningNum;

    public int totalPrice;
    public List<String> checkRank;

    public LottoCheck(List<List<Integer>> lottoNums, List<Integer> winningNum, int bonusNum) {
        totalPrice = 0;
        checkRank = new ArrayList<>();
        this.lottoNums = lottoNums;
        this.winningNum = winningNum;
        this.bonusNum = bonusNum;

        lottoCheck();
        result();
    }

    private void lottoCheck() {
        for (List<Integer> num : lottoNums) {
            int matchNum = setCheckRank(num);
            if (matchNum > 2)
                checkRank.add(bonusNumCheck(matchNum));
        }
    }

    private int setCheckRank(List<Integer> num) {
        int count = 0;

        for (Integer n : num) {
            if (winningNum.contains(n))
                count++;
        }

        return count;
    }

    private String bonusNumCheck(int matchNum) {
        if (matchNum == 5) {
            winningNum.contains(bonusNum);
            return (Integer.toString(matchNum) + "+");
        }
        return Integer.toString(matchNum);
    }

    private void result() {
        List<String> allResult = List.of("3", "4", "5", "5+", "6");

        for (String res : allResult) {
            int check = 0;
            String price = Winnings.getTotalWinnings(res);

            for (String realRes : checkRank) {
                if (res.equals(realRes))
                    check++;
            }

            if (res != "5+")
                printResult(Integer.parseInt(res), price, check);

            else
                printSecondResult(check);

            if (check > 0) {
                price = price.replace(",", "");
                totalPrice += (Integer.parseInt(price) * check);
            }
        }
    }

    private void printResult(int match, String price, int amount) {
        System.out.printf("%d개 일치 (%s원) - %d개", match, price, amount);
        System.out.println();
    }

    private void printSecondResult(int amount) {
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", amount);
        System.out.println();
    }
}
