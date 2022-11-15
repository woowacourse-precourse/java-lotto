package lotto;

import java.util.Map;

public enum matchedCountMessage {
    THREE_MATCH("3개 일치 (5,000원) - ", 3, 5000),
    FOUR_MATCH("4개 일치 (50,000원) - ", 4,50000),
    FIVE_MATCH("5개 일치 (1,500,000원) - ",5,1500000),
    SIX_MATCH("6개 일치 (2,000,000,000원) - ",6,2000000000),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 7,30000000);

    private String matchedMessage;
    private int number;
    private double price;

    matchedCountMessage(String string, int number, double price) {
        this.matchedMessage = string;
        this.number = number;
        this.price= price;
    }

    public String getMatchMessage() {
        return this.matchedMessage;
    }
    public int getMatchNumber() {
        return this.number;}
    public double getMatchNumberPrice(){
        return this.price;
    }

   public void printMatchMessage(Map<Integer,Integer> MatchedCount){
       System.out.println(this.getMatchMessage() + MatchedCount.getOrDefault(this.getMatchNumber(),0)+"개");
   }
}
