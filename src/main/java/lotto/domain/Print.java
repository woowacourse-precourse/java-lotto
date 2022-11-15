package lotto.domain;

import java.util.List;

public class Print {

    public void intputPrice(){
        System.out.println("구매금액을 입력해 주세요.");
    }

    public void lottoCount(int lottocount){
        System.out.println(String.format("%d개를 구매했습니다.", lottocount));
    }

    public void lottoNumber(List<List> userlottos){
        System.out.println();
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

    public static String lottoNumberError(){
        return "[Error] 1~45까지 중복되지 않는 숫자를 , 로 구분하여 입력해주세요.";
    }

    public static String priceError(){
        return "[Error] 0이 아닌 1000으로 나누어 떨어지는 숫자를 입력해주세요.";
    }

    public static String bonusNumberError(){
        return "[Error] 당첨 번호와 다른 1~45까지의 숫자 하나를 입력해주세요.";
    }
}
