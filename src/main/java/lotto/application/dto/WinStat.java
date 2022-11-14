package lotto.application.dto;

import java.util.ArrayList;
import java.util.List;

public class WinStat {
    private List<Integer> winStat;
    public WinStat(){
        winStat=new ArrayList<>(List.of(0,0,0,0,0));
    }
    public void updateWinStat(Integer rank){
        winStat.set(rank, winStat.get(rank)+1);
    }
    public List<Integer> getWinStat() {
        return winStat;
    }
}
