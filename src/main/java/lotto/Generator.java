package lotto;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    public static List<Integer>[] createRandomLotto(int lottoCount){
        List<Integer>[] lottos = new List[lottoCount];
        for(int i = 0; i < lottoCount; i++) lottos[i] = new ArrayList<Integer>();
        int firstLoop = 0;
        int secondLoop = 0;
        while(firstLoop < lottoCount){
            while(secondLoop < 6){
                int number = new Random().nextInt(45) + 1;
                if(secondLoop == 0) {
                    lottos[firstLoop].add(number);
                    secondLoop++;
                }
                if(secondLoop != 0 && !lottos[firstLoop].contains(number)){
                    lottos[firstLoop].add(number);
                    secondLoop++;
                }
            }
            secondLoop = 0;
            firstLoop++;
        }
        return lottos;
    }
}
