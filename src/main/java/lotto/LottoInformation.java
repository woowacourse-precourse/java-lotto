package lotto;

public enum LottoInformation {
    RANK5("3개 일치 (5,000원)", 5000),
    RANK4("4개 일치 (50,000원)", 50000),
    RANK3("5개 일치 (1,500,000원)",1500000),
    RANK2("5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
    RANK1("6개 일치 (2,000,000,000원)",2000000000);

    private final String resultMsg;
    private final Integer prizeMoney;

    LottoInformation(String resultMsg, Integer prizeMoney){
        this.resultMsg = resultMsg;
        this.prizeMoney = prizeMoney;
    }
    public String getResultMsg(){
        return resultMsg;
    }
    public Integer getPrizeMoney(){
        return prizeMoney;
    }
}
