package lotto;

import java.util.List;

public class WinningLotto {
    private final int threeWins;
    private final int fourWins;
    private final int fiveWins;
    private final int fiveWinsIncludBonus;
    private final int sixWins;

    public WinningLotto(List<Integer> number, List<List<Integer>> numbers) {
        int three = 0;
        int four = 0;
        int five = 0;
        int fiveWithBonus = 0;
        int six = 0;
        for (List<Integer> num : numbers) {
            three += getThreeWins(number, num);
            four += getFourWins(number, num);
            five += getFiveWins(number, num);
            fiveWithBonus += getFiveWithBonusWins(number, num);
            six += getSixWins(number, num);
        }
        this.threeWins = three;
        this.fourWins = four;
        this.fiveWins = five;
        this.fiveWinsIncludBonus = fiveWithBonus;
        this.sixWins = six;
        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveWithBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
    }

    public int getTotalYield() {
        int three = this.threeWins * 5000;
        int four = this.fourWins * 50000;
        int five = this.fiveWins * 1500000;
        int fiveWithBonus = this.fiveWinsIncludBonus * 30000000;
        int six = this.sixWins * 2000000000;
        return three + four + five + fiveWithBonus + six;
    }

    private int getThreeWins(List<Integer> number, List<Integer> num) {
        int cnt = countOverlapNumber(number, num);
        int threeWinsNum = 0;
        if (!num.contains(number.get(6)) && cnt == 3) {
            threeWinsNum++;
        }
        return threeWinsNum;
    }

    private int getFourWins(List<Integer> number, List<Integer> num) {
        int cnt = countOverlapNumber(number, num);
        int fourWinsNum = 0;
        if (!num.contains(number.get(6)) && cnt == 4) {
            fourWinsNum++;
        }
        return fourWinsNum;
    }

    private int getFiveWins(List<Integer> number, List<Integer> num) {
        int cnt = countOverlapNumber(number, num);
        int fiveWinsNum = 0;
        if (!num.contains(number.get(6)) && cnt == 5) {
            fiveWinsNum++;
        }
        return fiveWinsNum;
    }

    private int getFiveWithBonusWins(List<Integer> number, List<Integer> num) {
        int cnt = countOverlapNumber(number, num);
        int fiveWinsIncludBonusNum = 0;
        if (num.contains(number.get(6)) && cnt == 5) {
            fiveWinsIncludBonusNum++;
        }
        return fiveWinsIncludBonusNum;
    }

    private int getSixWins(List<Integer> number, List<Integer> num) {
        int cnt = countOverlapNumber(number, num);
        int sixWinsNum = 0;
        if (!num.contains(number.get(6)) && cnt == 6) {
            sixWinsNum++;
        }
        return sixWinsNum;
    }

    private int countOverlapNumber(List<Integer> number, List<Integer> num) {
        int cnt = 0;
        for (int numberr : number) {
            if (num.contains(numberr)) {
                cnt++;
            }
        }
        return cnt;
    }
}