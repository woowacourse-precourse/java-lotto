package lotto.View;

import lotto.domain.*;

public class outputview {
    private static final String output_paper = "개를 구매했습니다.";
    private static final String count = "개";
    private static final String output_result1 = "당첨 통계";
    private static final String output_result2 = "---";
    private static final String output_result3 = "3개 일치 (5,000원) - ";
    private static final String output_result4 = "4개 일치 (50,000원) - ";
    private static final String output_result5 = "5개 일치 (1,500,000원) - ";
    private static final String output_result6 = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String output_result7 = "6개 일치 (2,000,000,000원) - ";
    private static final String output_result8 = "총 수익률은 ";
    private static final String output_result9 = "%입니다.";
    private static void Out_paper(Paper paper) {
        System.out.println(paper.Get_Paper() + output_paper);
    }

    public static void Out_lottos(Lottos lottos, Paper paper){
        Out_paper(paper);
        for (int i = 0; i < paper.Get_Paper(); i++){
            Out_lotto(lottos.Get_lotto(i));
        }
    }

    private static void Out_lotto(Lotto lotto){
        System.out.println(lotto.Get_numbers());
    }

    public static void Out_result(Score score, String percent){
        Out_result1();
        Out_result2(score);
        Out_result3(percent);
    }

    private static void Out_result1(){
        System.out.println(output_result1);
        System.out.println(output_result2);
    }

    private static void Out_result2(Score score){
        System.out.println(output_result3 + score.Get_val(0) + count);
        System.out.println(output_result4 + score.Get_val(1) + count);
        System.out.println(output_result5 + score.Get_val(2) + count);
        System.out.println(output_result6 + score.Get_val(3) + count);
        System.out.println(output_result7 + score.Get_val(4) + count);
    }

    private static void Out_result3(String percent){
        System.out.println(output_result8 + percent + output_result9);
    }
}
