package Winning;

public class WinningHistory {

    private int firstWinningCmt;
    private int secondWinningCmt;
    private int thirdWinningCmt;
    private int forthWinningCmt;
    private int fifthWinningCmt;

    public WinningHistory() {
        initializeWinningCmt();
    }

    public void print() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + fifthWinningCmt + "개");
        System.out.println("4개 일치 (50,000원) - " + forthWinningCmt + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdWinningCmt + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondWinningCmt + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstWinningCmt + "개");
    }

    private void initializeWinningCmt() {
        firstWinningCmt = 0;
        secondWinningCmt = 0;
        thirdWinningCmt = 0;
        forthWinningCmt = 0;
        fifthWinningCmt = 0;
    }

    public void addFirstWinningCmt() {
        firstWinningCmt++;
    }

    public void addSecondWinningCmt() {
        secondWinningCmt++;
    }

    public void addThirdWinningCmt() {
        thirdWinningCmt++;
    }

    public void addForthWinningCmt() {
        forthWinningCmt++;
    }

    public void addFifthWinningCmt() {
        fifthWinningCmt++;
    }
}
