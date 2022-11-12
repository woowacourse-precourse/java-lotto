package lotto.view;

import java.util.List;

public class OutputView {
    public void moneyOutput(int lottoAmount){
        System.out.println(lottoAmount+"개를 구매했습니다.");
    }

    public void lottoFactoryOutput(int lottoAmout, List<List<Integer>> lottos){
        for(int i = 0; i < lottoAmout; i++){
            lottoOutput(lottos.get(i));
        }
    }

    public void lottoOutput(List<Integer> lotto){
        String output = "[" + Integer.valueOf(lotto.get(0));
        for(int i = 1; i < lotto.size(); i++){
            output += ", " + Integer.valueOf(lotto.get(i));
        }
        output += "]";

        System.out.println(output);
    }
}
