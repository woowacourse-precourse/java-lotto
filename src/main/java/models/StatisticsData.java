package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsData {

    List<Integer> DivisionCount;

    public StatisticsData(){
        this.DivisionCount = new ArrayList<>(Collections.nCopies(6,0));
    }

    public void countDivision(int division){

        if(division > 0){
            DivisionCount.set(division,DivisionCount.get(division)+1);
        }

    }

    public List<Integer> getDivisionCount() {
        return DivisionCount;
    }

}
