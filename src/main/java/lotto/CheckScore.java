package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CheckScore {
    final List<Integer> winningNumber;
    final List<List<Integer>> allTickets;
    final Integer bonusNumber;

    final List<Integer> scoreList;

    static Integer size;

    public CheckScore(List<Integer> winningNumber, List<List<Integer>> allTickets, Integer bonusNumber){
        this.winningNumber = winningNumber;
        this.allTickets = allTickets;
        this.bonusNumber = bonusNumber;
        this.size = allTickets.size();
        this.scoreList = new ArrayList<>();
        goCheck();
    }

    private void goCheck() {
        System.out.println("go check");
        makeScoreList();
        for(int i=0; i<size; i++){
            List<Integer> ticket = allTickets.get(i);
            compareNumbers(i,ticket);
        }
    }

    private void makeScoreList() {
        System.out.println("run");
        System.out.println("scoreList = " + scoreList);
        System.out.println("scoreList.size() = " + scoreList.size());
        for(int i=0; i<size; i++){
            scoreList.add(0);
        }
    }

    private void compareNumbers(int idx,List<Integer> ticket) {
        for(int i=0; i<6; i++){
            Integer lottoNumber = winningNumber.get(i);
            if(ticket.contains(lottoNumber)){
                makeScore(idx);
            }
        }
        editScoreList();
    }

    private void makeScore(int idx) {
        Integer score = scoreList.get(idx);
        score+=1;
        if(score==6){
            score+=1;
        }
        scoreList.set(idx,score);
    }

    private void editScoreList(){
        for(int i=0; i<size; i++){
            if(scoreList.get(i)==5){
                bonusCheck(i);
            }
        }
    }

    private void bonusCheck(int i) {
        List<Integer> ticket = allTickets.get(i);
        if(ticket.contains(bonusNumber)){
            scoreList.set(i,6);
        }
    }

    //1등 당첨이면 6개 다 당첨임 --> 6개 다 당첨이면 숫자를 맞은 7개로 해줌
    //2등 당첨이면 5개 + 보너스 넘버 당첨임 --> 5개 맞으면 보너스 확인 메서드 타고, 보너스까지 맞으면 6개로 해줌
    //3등 당첨이면 5개 + 보너스 당첨 X임 --> 5개 맞으면 보너스 확인 메서드 타고, 틀리면 5개로 해줌
    //4등 4개
    //5등 3개


}
