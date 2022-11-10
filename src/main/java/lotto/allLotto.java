package lotto;

import java.util.ArrayList;
import java.util.List;

public class allLotto {
    private  List<List<Integer>> lottos;
    public allLotto(){
        this.lottos = new ArrayList<>();
    }
    public void addLotto(List<Integer> lotto){
        this.lottos.add(lotto);
    }
    public int sizeLotto(){
        return this.lottos.size();
    }

    public void printAllLotto(){
        for(int i=0;i<lottos.size();i++){
            System.out.print(lottos.get(i));
        }
    }
}
