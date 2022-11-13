package lotto;

public class CountNumberOfWins {
    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;
    private int fourthPlace;
    private int fifthPlace;
    private final BuyLotto buyLotto;
    private final WinningNumbers winningNumbers;

    public CountNumberOfWins(BuyLotto buyLotto, WinningNumbers winningNumbers) {
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
        this.fourthPlace = 0;
        this.fifthPlace = 0;
        this.buyLotto = buyLotto;
        this.winningNumbers = winningNumbers;
    }
}
