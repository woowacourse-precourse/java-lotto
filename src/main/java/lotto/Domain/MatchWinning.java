package lotto.Domain;

public class MatchWinning {

    WinningPrice winningPrice;
    private int profit;
    private int firstPrice = 0;
    private int secondPrice = 0;
    private int thirdPrice = 0;
    private int forthPrice = 0;
    private int fifthPrice = 0;

    public void matchThePrice(int theNumberOfWins, int winningBonus) {
        if (theNumberOfWins == 6) {
            profit += winningPrice.FIRST.getPrizeMoney();
            firstPrice ++;
        }
        if (theNumberOfWins == 5 && winningBonus == 1) {
            profit += winningPrice.SECOND.getPrizeMoney();
            secondPrice++;
        }
        if (theNumberOfWins == 5 && winningBonus == 0) {
            profit += winningPrice.THIRD.getPrizeMoney();
            thirdPrice++;
        }
        if (theNumberOfWins == 4) {
            profit += winningPrice.FORTH.getPrizeMoney();
            forthPrice++;
        }
        if (theNumberOfWins == 3) {
            profit += winningPrice.FIFTH.getPrizeMoney();
            fifthPrice++;
        }
    }

    public int getProfit() {
        return profit;
    }

    public int getFirstPrice() {
        return firstPrice;
    }

    public int getSecondPrice() {
        return secondPrice;
    }

    public int getThirdPrice() {
        return thirdPrice;
    }

    public int getForthPrice() {
        return forthPrice;
    }

    public int getFifthPrice() {
        return fifthPrice;
    }
}
