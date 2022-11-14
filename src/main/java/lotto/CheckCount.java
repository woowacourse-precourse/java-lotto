package lotto;

import java.util.List;

public class CheckCount {

    public int CheckThree(List<Integer> result){
        int three = 0;
        for(int i =0;i<result.size();i++) {
            if (result.get(i) == 3) {
                three += 1;
            }
        }

        return three;
    }
    public int CheckFour(List<Integer> result){
        int four = 0;
        for(int i =0;i<result.size();i++){
        if(result.get(i) == 4) {
            four += 1;
            }
        }

        return four;
    }
    public int CheckFive(List<Integer> result){
        int Five = 0;
        for(int i =0;i<result.size();i++) {
            if (result.get(i) == 5) {
                Five += 1;
            }
        }

        return Five;
    }
    public int CheckFiveS(List<Integer> result){
        int FiveS = 0;
        for(int i =0;i<result.size();i++) {
            if (result.get(i) == 100) {
                FiveS += 1;
            }
        }
        return FiveS;
    }
    public int CheckSix(List<Integer> result){
        int Six = 0;
        for(int i =0;i<result.size();i++) {
            if (result.get(i) == 6) {
                Six += 1;
            }
        }

        return Six;
    }
}
