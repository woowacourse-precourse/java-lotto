package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoLogic;
import lotto.domain.Rank;

public class UI {
    static LottoLogic lottoLogic = new LottoLogic();

    public static String LottoInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        System.out.println();
        return input;
    }

    public void LottoCountOutput(){
        System.out.println(lottoLogic.getLottoCount()+"개를 구매했습니다.");
    }

    public void PrintLottoNumber(){
        for (int i = 0; i < lottoLogic.getLottos().size(); i++){
            System.out.println(lottoLogic.getLottos().get(i).getLottoNumber());
        }
        System.out.println();
    }

    public static String WinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        System.out.println();
        return input;
    }

    public static String BonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        System.out.println();
        return input;
    }

    public static void WinningTotal(){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Rank.FIFTH.getRanking()+Rank.FIFTH.getBonus()+"개 일치 "+Rank.FIFTH.getMoney()+" - "+lottoLogic.getThreeSame()+"개");
        System.out.println(Rank.FORTH.getRanking()+Rank.FORTH.getBonus()+"개 일치 "+Rank.FORTH.getMoney()+" - "+lottoLogic.getFourSame()+"개");
        System.out.println(Rank.THIRD.getRanking()+Rank.THIRD.getBonus()+"개 일치 "+Rank.THIRD.getMoney()+" - "+lottoLogic.getFiveSame()+"개");
        System.out.println(Rank.SECOND.getRanking()+"개 일치"+Rank.SECOND.getBonus()+Rank.SECOND.getMoney()+" - "+lottoLogic.getFiveBonusSame()+"개");
        System.out.println(Rank.FIRST.getRanking()+Rank.FIRST.getBonus()+"개 일치 "+Rank.FIRST.getMoney()+" - "+lottoLogic.getSixSame()+"개");


        /*3개 일치 (5,000원) - 1개

         */
    }

}
