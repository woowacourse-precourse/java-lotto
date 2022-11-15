package lotto;

public class WinningHistory {

    int firstWinningCmt;
    int secondWinningCmt;
    int thirdWinningCmt;
    int forthWinningCmt;
    int fifthWinningCmt;

    public WinningHistory() {
        initializeWinningCmt();
    }

    public void print() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + fifthWinningCmt);
        System.out.println("4개 일치 (50,000원) - " + forthWinningCmt);
        System.out.println("5개 일치 (1,500,000원) - " + thirdWinningCmt);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondWinningCmt);
        System.out.println("6개 일치 (2,000,000,000원) - " + firstWinningCmt);
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
