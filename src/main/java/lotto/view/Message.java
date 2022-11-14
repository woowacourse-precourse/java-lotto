package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import lotto.domain.Lotto;
import lotto.domain.LottoGrade;
import lotto.domain.User;

public class Message {

    public String inputPaymentMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void buyLottoMessage(int lottoAmount){
        System.out.println();
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void lottoDetailMessage(Lotto lotto){
        System.out.println(lotto.getNumbers());
    }

    public String inputWinningNumberMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumberMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void lottoResultMessage() {
        DecimalFormat df = new DecimalFormat("###,###");

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for(LottoGrade lottoGrade : LottoGrade.values()){
            System.out.print(lottoGrade.getCorrect() +"개 일치");
            if(lottoGrade== LottoGrade.second){
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(" ("+df.format(lottoGrade.getPrize())+"원) - ");
            System.out.println(User.getLottoGradeNumber(lottoGrade)+"개");
        }
    }
}
