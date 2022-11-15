package lotto.view;// @ author ninaaano

public enum WinningResult {
    /*
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

    3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.

     */

    FIRST_WINNING(2000000000,6,"6개 일치 (2,000,000,000원) - "),
    SECOND_WINNING(30000000,5,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_WINNING(1500000,5,"5개 일치 (1,500,000원) - "),
    FOURTH_WINNING(50000,4,"4개 일치 (50,000원) - "),
    FIFTH_WINNING(5000,3,"3개 일치 (5,000원) - ");

    private int winnings;
    private int winningsCount;
    private String result;

    WinningResult(int winnings, int winningsCount, String result) {
        this.winnings = winnings;
        this.winningsCount = winningsCount;
        this.result = result;
    }

    public int getWinnings() {
        return winnings;
    }

    public int getWinningsCount() {
        return winningsCount;
    }

    public String getResult() {
        return result;
    }

}
