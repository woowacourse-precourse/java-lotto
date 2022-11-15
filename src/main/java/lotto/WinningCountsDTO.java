package lotto;

public class WinningCountsDTO {

    private int[] winningCounts;

    public WinningCountsDTO(int[] counts) {
        winningCounts = counts.clone();
    }

    public int[] getWinningCounts() {
        return (winningCounts);
    }
}
