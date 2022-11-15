package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application
{
    public static void main(String[] args)
    {
        try {
            LottoVandingMachine lottoVM = new LottoVandingMachine();
            LottoCalculator lottoCal = new LottoCalculator();

            //로또 발행
            List<Lotto> lottoList = lottoVM.getIssuedLottoList();

            //로또 추첨
            Lotto lottoAnswer = new Lotto(lottoVM.drawLotto(), true);

            //로또 추첨 결과
            int[] result = new int[5];
            for (Lotto lotto : lottoList) {
                int matchCount = lottoCal.compareLotto(lotto.getNumbers(), lottoAnswer.getNumbers());
                result = lottoCal.getResult(result, matchCount);
            }

            //결과 출력
            lottoCal.printResult(lottoVM.getIssuedLottoCount(), result);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
