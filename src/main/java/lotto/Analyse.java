package lotto;

import java.util.ArrayList;
import java.util.List;

public class Analyse {
    public static int containNumber(Lotto winLotto, Lotto buyLotto, int winBonus) {
        int result = 0;

        List<Integer> winNumber = winLotto.getLotto();
        List<Integer> buyNumber = buyLotto.getLotto();

        for(int i=0; i<buyNumber.size(); i++) {
            if(winNumber.contains(buyNumber.get(i))) {
                result++;
            }
        }

        if(result==5) {
            if(winNumber.contains(winBonus)) {
                result=7;
            }
        }

        return result;
    }

    public static List<Integer> analyseResult(List<Integer> results) {
        List<Integer> graph = new ArrayList<>();
        int three = 0;
        int four =0;
        int five =0;
        int seven =0;
        int six =0;
        for(int i=0; i<results.size(); i++) {
            if(results.get(i)==3) {three++;}
            if(results.get(i)==4) {four++;}
            if(results.get(i)==5) {five++;}
            if(results.get(i)==7) {seven++;}
            if(results.get(i)==6) {six++;}
        }
        graph.add(three);
        graph.add(four);
        graph.add(five);
        graph.add(six);
        graph.add(seven);

        return graph;

    }
}
