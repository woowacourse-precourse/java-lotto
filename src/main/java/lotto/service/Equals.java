package lotto.service;

import java.util.List;

public class Equals {
    int count = 0;
    public int equalsCount(List<Integer> input, List<Integer> Lotto) {
        for(int i:Lotto) {
            getCount(i, input, Lotto);
        }
        return count;
    }

    public boolean equals(int i,List<Integer> input, List<Integer> Lotto) {
        return input.get(i).equals(Lotto.get(i));
    }

    public int getCount(int i,List<Integer> input, List<Integer> Lotto) {
        if(equals(i, input, Lotto)){
            count++;
        }
        return count;
    }
}
