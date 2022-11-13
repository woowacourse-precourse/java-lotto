package lotto.view;

import java.util.List;

public class OutputView {

    String[] winning = {"3개 일치 (5,000원) - ", "4개 일치 (50,000원) - ", "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - "};
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

    public void lottoResult(int[] lottoCount, float yield){
        System.out.println("당첨 통계\n" + "---");
        for(int i = 0; i < lottoCount.length; i++){
            System.out.println(this.winning[i] + lottoCount[i]+"개");
        }
        System.out.println("총 수익률은 "+yield+"%입니다.");
    }
}
