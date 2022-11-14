package lotto.model;

import java.util.List;

public class Revenue {

    private final List<List<Integer>> matches;
    private int revenue;

    public Revenue(Discriminator discriminator){
        matches=discriminator.getMatches();
    }

    public int getRevenue(){
        return revenue;
    }
}
