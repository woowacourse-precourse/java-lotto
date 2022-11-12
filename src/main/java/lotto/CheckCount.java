package lotto;

import java.util.List;

public class CheckCount {

    public int CheckThree(List<Integer> result){
        int three = 0;

        if(result.indexOf(3)!=-1){
            three += 1;
        }

        return three;
    }
    public int CheckFour(List<Integer> result){
        int four = 0;

        if(result.indexOf(4)!=-1){
            four += 1;
        }

        return four;
    }
    public int CheckFive(List<Integer> result){
        int Five = 0;

        if(result.indexOf(5)!=-1){
            Five += 1;
        }

        return Five;
    }
    public int CheckFiveS(List<Integer> result){
        int FiveS = 0;

        if(result.indexOf(100)!=-1){
            FiveS += 1;
        }

        return FiveS;
    }
    public int CheckSix(List<Integer> result){
        int Six = 0;

        if(result.indexOf(6)!=-1){
            Six += 1;
        }

        return Six;
    }
}
