package lotto;

public enum WinningStaticsFormat {
    CASE1(3, "3개 일치 (5,000원) - "),
    CASE2(4, "4개 일치 (50,000원) - "),
    CASE3(5, "5개 일치 (1,500,000원) - "),
    CASE4(7, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CASE5(6, "6개 일치 (2,000,000,000원) - ");

    private int matchNumber;
    private String format;

    WinningStaticsFormat(int matchNumber, String format){
        this.matchNumber = matchNumber;
        this.format = format;
    }

    public int getMatchNumber(){
        return matchNumber;
    }

    public String getFormat(){
        return format;
    }
}
