package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class result {
    public static void printSixRange(List<Integer> randomLottos, int row) {
        List<Integer> seperateRandomLotto = new ArrayList<>();

        for(int j=row*6 ; j<(row+1)*6 ; j++){
            int target = randomLottos.get(j);
            seperateRandomLotto.add(target);
        }
        Collections.sort(seperateRandomLotto);
        System.out.println(seperateRandomLotto);
    }
    private void getCompareTarget(){
        List<Integer> randomNumbers = Buy.compareRandomLottos();
        List<Integer> winningNumbers = Lotto.compareWinningNumbers();
        comapreNumbers(randomNumbers,winningNumbers);
    }
    public void comapreNumbers(List<Integer> randomNumbers,List<Integer> winningNumbers){
        HashMap<Integer,Integer> result = new HashMap<>();
        int count = 0;
        for(int i =1;i<=randomNumbers.size() / 6;i++){
            result.put(i,0);
        }

        for(int i =0;i<randomNumbers.size()/6;i++){
            count = compareSixNumbers(randomNumbers,winningNumbers,i);
            result.put(count,result.get(count)+1);
        }
        for(int i =0;i<randomNumbers.size();i++)
        System.out.println(result);
    }

    public int compareSixNumbers(List<Integer> randomNumbers,List<Integer> winningNumbers,int row){
        int count =0;
        List<Integer> seperateRandomLotto = new ArrayList<>();
        for(int j= row*6;j<(row+1)*6;j++){
            int target = randomNumbers.get(j);
            seperateRandomLotto.add(target);
        }

        for(int i =0;i< seperateRandomLotto.size();i++){
            if(seperateRandomLotto.contains(winningNumbers.get(i))){
                count ++;
            }
        }

        return count;
    }


}
