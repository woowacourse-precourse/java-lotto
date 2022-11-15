package winning;

public class WinningHistory {

    private int firstWinningCount = 0;
    private int secondWinningCount = 0;
    private int thirdWinningCount = 0;
    private int forthWinningCount = 0;
    private int fifthWinningCount = 0;

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

    public int getFirstWinningCount() {
        return firstWinningCount;
    }

    public int getSecondWinningCount() {
        return secondWinningCount;
    }

    public int getThirdWinningCount() {
        return thirdWinningCount;
    }

    public int getForthWinningCount() {
        return forthWinningCount;
    }

    public int getFifthWinningCount() {
        return fifthWinningCount;
    }
}
