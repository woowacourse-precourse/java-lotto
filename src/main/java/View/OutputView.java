package View;

import Domain.Lotto;
import Domain.LottoList;

import java.util.List;

public class OutputView {
    public static void printNumberOfLotto(int numberOfLotto, List<Lotto> lottoList){
        System.out.printf("%d개를 구매했습니다.\n", numberOfLotto);
        printEachLottoNum(lottoList);
    }

    public static void printEachLottoNum(List<Lotto> lottoList){
        for(Lotto lotto : lottoList){
            System.out.print("["); //상수
            int len = lotto.getLottoNumbers().size();
            for(int i=0; i<len-1; i++){
                System.out.print(lotto.getLottoNumbers().get(i) + ", "); //상수
            }
            System.out.print(lotto.getLottoNumbers().get(len-1));
            System.out.println("]"); //상수
        }
        System.out.println();
    }

    public static void printLottoResult(int[] countList, LottoList lottoList, int income){ //상수
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countList[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + countList[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countList[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countList[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countList[1] + "개");
        printIncomeRate(lottoList.getLottoPlayNumber(), income);
    }

    public static void printIncomeRate(int numberOfLotto, int income){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (income * 100.0) / (numberOfLotto * 1000)); //상수
    }

}
