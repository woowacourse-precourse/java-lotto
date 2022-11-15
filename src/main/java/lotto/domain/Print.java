package lotto.domain;

import java.util.List;

public class Print {

    public void lottoCount(int lottocount){
        System.out.println(String.format("%d개를 구매했습니다.", lottocount));
    }

    public void lottoNumber(List<List> userlottos){
        for (int i = 0; i < userlottos.size(); i++){
            System.out.println(userlottos.get(i));
        }
    }

    public void inputLotto(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void inputBonus(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void statistics(){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void winningMoney(List<Integer> matchFrequency){
        List<String> winningsPrint = PrizeCategory.getWinningsPrint();
        List<Integer> matchCount = PrizeCategory.getMatchCount();
        for (int i = 0; i < matchFrequency.size(); i++){
            System.out.println(String.format("%d개 일치%s - %d개",
                    matchCount.get(i),
                    winningsPrint.get(i),
                    matchFrequency.get(i)));
        }
    }

    public void profitRate(double profit){
        System.out.println(String.format("총 수익률은 %.1f", profit) + "%입니다.");
    }
}
