package lotto;

import java.util.ArrayList;
import java.util.List;

public enum PrizeEnum {
    fifthWinner_3(5000,3,false),
    fourthWinner_4(50000,4,false),
    thirdWinner_5(1500000,5,false),
    secondWinner_5_bonus(30000000,5,true),
    firstWinner_6(2000000000,6,false);

    private int prize;
    private int correctNumber;
    private boolean bonusCorrect;
    private int count;
    private List<Integer> ans = new ArrayList<>(List.of(2,3,3,0,4));

    PrizeEnum(int prize, int correctNumber, boolean bonusCorrect) {
        this.prize = prize;
        this.correctNumber = correctNumber;
        this.bonusCorrect = bonusCorrect;
    }
    public void plusCount(List<Integer> ans) {
        for (int i = 0;i < ans.size();i++){
        if(this.correctNumber == ans.get(i)){
            this.count++;
        }
    }}

    public int getPrize(){
        return this.prize;
    }

    public int getCount(){
        return this.count;
    }


    public static int getResults(List<Integer> list){
        for(int i:list){
            if(i == 1){

            }
        }
        return 0;
    }
}
