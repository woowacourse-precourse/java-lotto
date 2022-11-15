package lotto.ui;

import lotto.setting.WinningEnum;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Output {

    public static void printInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBoughtLotto(int lottoCount){
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printBoughtLottoNumbers(List<Integer> lotto){
        System.out.println(String.format("%s", lotto.toString()));
    }

    public static void printInputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatistics(Map<WinningEnum, Integer> statistics){
        System.out.println("당첨 통계");
        System.out.println("---");

        for(WinningEnum winning : WinningEnum.values()){
            if(winning.isHaveToCorrectBonusNumber()) {
                System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", winning.getCorrectNumberCount(), winning.getWinningAmount(), Optional.ofNullable(statistics.get(winning)).orElse(0)));
            }
            else{
                System.out.println(String.format("%d개 일치 (%,d원) - %d개", winning.getCorrectNumberCount(), winning.getWinningAmount(), Optional.ofNullable(statistics.get(winning)).orElse(0)));
            }
        }
    }

    public static void printYield(double yield){
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", yield));
    }
}
