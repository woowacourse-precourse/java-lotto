package lotto.model;

import lotto.view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinCount {

    static List<Integer> rankCount = new ArrayList<>(Arrays.asList(0,0,0,0,0));
    static OutputView outputView = new OutputView();


    public static List<Integer> winCount(List<WinDetail> result) {
        for(WinDetail winDetail : result) {
            count(winDetail);
        }
        return rankCount;
    }

    private static void firstCount(WinDetail winDetail) {
        if(winDetail.name().equals("First")) {
            rankCount.set(0,rankCount.get(0)+1);
        }
    }

    private static void secondCount(WinDetail winDetail){
        if(winDetail.name().equals("Second")){
            rankCount.set(1,rankCount.get(1)+1);
        }
    }

    private static void thirdCount(WinDetail winDetail){
        if(winDetail.name().equals("Third")) {
            rankCount.set(2,rankCount.get(2)+1);
        }
    }

    private static void fourthCount(WinDetail winDetail){
        if(winDetail.name().equals("Fourth")){
            rankCount.set(3, rankCount.get(3)+1);
        }
    }

    private static void fifthCount(WinDetail winDetail){
        if(winDetail.name().equals("Fifth")){
            rankCount.set(4,rankCount.get(4)+1);
        }
    }

    private static void count(WinDetail winDetail){
        firstCount(winDetail);
        secondCount(winDetail);
        thirdCount(winDetail);
        fourthCount(winDetail);
        fifthCount(winDetail);
    }

    public static void printCount(List<Integer> rankCount){
        outputView.rankMsg();
        outputView.fifthMsg(rankCount.get(4));
        outputView.fourthMsg(rankCount.get(3));
        outputView.thirdMsg(rankCount.get(2));
        outputView.secondMsg(rankCount.get(1));
        outputView.firstMsg(rankCount.get(0));

    }
}
