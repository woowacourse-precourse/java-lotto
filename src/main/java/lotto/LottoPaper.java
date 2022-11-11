package lotto;

import java.util.List;

public class LottoPaper {
    private final List<Integer> number;
    public LottoPaper(List<Integer> number){

        this.number = number;
    }
    public int getResult(List<Integer> winningNumber, int bonusNumber){
        if(this.number.contains(bonusNumber)){
            this.number.retainAll(winningNumber);
            if(this.number.size() == 5){
                return 7;
            }
        }
        this.number.retainAll(winningNumber);
        return this.number.size();
    }
}
