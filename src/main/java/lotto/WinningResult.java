package lotto;

public enum WinningResult {

    LOSE(0,"낙첨",0),
    WIN_5TH(5,"3개 일치 (5,000원)",5000),
    WIN_4TH(4,"4개 일치 (50,000원)",50000),
    WIN_3RD(3,"5개 일치 (1,500,000원)",1500000),
    WIN_2ND(2,"5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
    WIN_1ST(1,"6개 일치 (2,000,000,000원)",2000000000);
    private Integer rank;
    private String content;
    private Integer reward;

    WinningResult(Integer rank,String content, Integer reward){
        this.rank = rank;
        this.content = content;
        this.reward = reward;
    }

    public Integer getRank() {
        return rank;
    }

    public String getContent(){
        return content;
    }

    public Integer getReward(){
        return reward;
    }
}
