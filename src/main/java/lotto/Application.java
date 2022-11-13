package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    static List<List<Integer>> ListArrary = new ArrayList<>();
    static String Regex = "[^0-9]";
    public static int Insertpurchase() {
        String strVal = Console.readLine();
        if (strVal.replaceAll(Regex,"").length()!=strVal.length()) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하였습니다.");
        }
        int intval = Integer.parseInt(strVal);

        if (intval%1000>=1) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위가 아닙니다.");
        }
        return (int)intval/1000;
    }
    public static List<Integer> RandomChoice() {
        List<Integer> Lottonum = new ArrayList<>();
        while (Lottonum.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!Lottonum.contains(randomNumber)) {
                Lottonum.add(randomNumber);
            }
        }
        Collections.sort(Lottonum);
        return Lottonum;
    }
    public static void MakeLotto(int Lottonumber) {
        for (int i=0;i<Lottonumber;i++) {
            List<Integer> TmpList = RandomChoice();
            ListArrary.add(TmpList);
            System.out.println(TmpList);
        }
    }
    public static List<Integer> InsertLotto() {
        List<Integer> AnswerLottoInt = new ArrayList<>();
        String AnswerLotto = Console.readLine();
        String[] SplitStr = AnswerLotto.split(",");

        for (int i=0; i<SplitStr.length; i++) {
            if (SplitStr[i].replaceAll(Regex,"").length()!=SplitStr[i].length()) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하였습니다.");
            }
            int tmpInt = Integer.parseInt(SplitStr[i]);
            if (tmpInt<=0 || tmpInt>=46) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            AnswerLottoInt.add(tmpInt);
        }
        return AnswerLottoInt;
    }
    public static int InsertBounus() {
        String Bonus = Console.readLine();

        if (Bonus.replaceAll(Regex,"").length()!=Bonus.length()) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하였습니다.");
        }
        int BonusNum = Integer.parseInt(Bonus);
        if (BonusNum<=0 || BonusNum>=46) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return BonusNum;
    }

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int Lottonumber = Insertpurchase();
        System.out.printf("\n%d개를 구매했습니다.\n",Lottonumber);
        MakeLotto(Lottonumber);
        System.out.println("당첨 번호를 입력해주 주세요.");
        List<Integer> AnswerLotto = InsertLotto();
        Lotto A = new Lotto(AnswerLotto);
        System.out.println("보너스 번호를 입력해주세요.");
        int BonousNum = InsertBounus();
        System.out.println("당첨 통계");
        System.out.println("---");
        A.Statistics(ListArrary,BonousNum);
    }
}
