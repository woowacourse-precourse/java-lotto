package lotto;

//winningNumber을 enum으로 작성하겠다
public enum WinningType {

    FIFTH(5,"3","5,000"),
    FOURTH(4,"4","50,000"),
    THIRD(3,"5","1,500,000"),
    SECOND(2,"5","30,000,000"),FIRST(1,"6","2,000,000,000");
    private int rank;
    private String prize;
    private String matchNum;
    WinningType(int rank,String matchNum,String prize) {
        this.rank = rank;
        this.prize = prize;
        this.matchNum = matchNum;

    }
    public void showPrize(){
        System.out.println(this.rank);
        System.out.println(this.prize);
    }
    public String getMatchNum(){
        return this.matchNum;
    }
    public String getPrize(){
        return this.prize;
    }
    public int getRank(){
        return this.rank;
    }

}
