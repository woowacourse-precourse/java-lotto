package lotto;

public enum WinningResult {

    LOSE("낙첨",0),
    WIN_5TH("3개 일치 (5,000원)",5000),
    WIN_4TH("4개 일치 (50,000원)",50000),
    WIN_3RD("5개 일치 (1,500,000원)",1500000),
    WIN_2ND("5개, 보너스 번호 일치 (30,000,000원)",30000000),
    WIN_1ST("6개 일치 (2,000,000,000원)",2000000000);
    private String content;
    private Integer reward;

    WinningResult(String content, Integer reward){
        this.content = content;
        this.reward = reward;
    }
}
