package lotto;
import java.util.List;

public class Rank {
    private int[] ranks = new int[5];

    public void compareNum(List<Integer> buyNumbers, Lotto lotto, int bonusNum){
        List<Integer> winningNumbers = lotto.getNumbers();
        int count = 0;
        for (int i = 0; i < buyNumbers.size(); i++) {
            if(winningNumbers.contains(buyNumbers.get(i))){
                count ++;
            }
        }
        boolean bonusCheck = buyNumbers.contains(bonusNum);
        if (count == 6 && !bonusCheck){
            ranks[0] += 1;
            return;
        }
        if (count == 5 && bonusCheck){
            ranks[1] += 1;
            return;
        }
        if (count == 5){
            ranks[2] += 1;
            return;
        }
        if (count == 4){
            ranks[3] += 1;
            return;
        }
        if (count == 3){
            ranks[4] += 1;
        }
    }

    public int[] getRanks(){
        return ranks;
    }
}
