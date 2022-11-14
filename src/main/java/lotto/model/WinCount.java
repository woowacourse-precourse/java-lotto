package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinCount {

    List<Integer> rankCount = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));


    public List<Integer> winCount(List<WinDetail> result) {
        for(WinDetail winDetail : result) {
            count(winDetail);
        }
        return rankCount;
    }

    private void firstCount(WinDetail winDetail) {
        if(winDetail.name().equals("First")) {
            rankCount.set(0,rankCount.get(0)+1);
        }
    }

    private void secondCount(WinDetail winDetail){
        if(winDetail.name().equals("Second")){
            rankCount.set(1,rankCount.get(1)+1);
        }
    }

    private void thirdCount(WinDetail winDetail){
        if(winDetail.name().equals("Third")) {
            rankCount.set(2,rankCount.get(2)+1);
        }
    }

    private void fourthCount(WinDetail winDetail){
        if(winDetail.name().equals("Fourth")){
            rankCount.set(3, rankCount.get(3)+1);
        }
    }

    private void fifthCount(WinDetail winDetail){
        if(winDetail.name().equals("Fifth")){
            rankCount.set(4,rankCount.get(4)+1);
        }
    }

    private void count(WinDetail winDetail){
        firstCount(winDetail);
        secondCount(winDetail);
        thirdCount(winDetail);
        fourthCount(winDetail);
        fifthCount(winDetail);
    }
}
