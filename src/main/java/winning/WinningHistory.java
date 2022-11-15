package winning;

public class WinningHistory {

    private int firstWinningCount = 0;
    private int secondWinningCount = 0;
    private int thirdWinningCount = 0;
    private int forthWinningCount = 0;
    private int fifthWinningCount = 0;

    public void print() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + fifthWinningCount + "개");
        System.out.println("4개 일치 (50,000원) - " + forthWinningCount + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdWinningCount + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondWinningCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstWinningCount + "개");
    }

    public void addFirstWinningCount() {
        firstWinningCount++;
    }

    public void addSecondWinningCount() {
        secondWinningCount++;
    }

    public void addThirdWinningCount() {
        thirdWinningCount++;
    }

    public void addForthWinningCount() {
        forthWinningCount++;
    }

    public void addFifthWinningCount() {
        fifthWinningCount++;
    }
}
