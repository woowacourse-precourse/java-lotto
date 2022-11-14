package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Rank {
    FIRST(List.of(6,0), 2000000000),
    SECOND(List.of(5,1),30000000),
    THIRD(List.of(5,0),30000000),
    FOURTH(List.of(4,0),50000),
    FIFTH(List.of(3,0), 5000),
    NOTHING(Collections.EMPTY_LIST,0);
    private final List<Integer>  NUMBER_OF_MATCHES;
    private final int REVENUE;

    Rank(List<Integer> numberOfMatches, int revenue){
        this.REVENUE=revenue;
        this.NUMBER_OF_MATCHES=numberOfMatches;
    }



}
