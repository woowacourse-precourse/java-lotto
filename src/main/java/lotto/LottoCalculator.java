package lotto;

import java.text.DecimalFormat;
import java.util.List;

public class LottoCalculator
{
    //compare issuedLotto to drawedLotto
    public int compareLotto(List<Integer> issuedLotto, List<Integer> lottoAnswer)
    {
        int count = 0;
        for(int i = 0; i < lottoAnswer.size(); i++)
        {
            if(count == 5 && i == 6 && issuedLotto.contains(lottoAnswer.get(i)))
                count += 2;

            if(i < 6 && issuedLotto.contains(lottoAnswer.get(i)))
                count++;
        }
        System.out.println("count : "+count);
        return count;
    }

    //결과 계산
    public int[] getResult(int[] resultArr, int count)
    {
        if(count < 3)
            return resultArr;

        if(count != 0 && count < 6){
            resultArr[count-3] += 1;
            return resultArr;
        }

        if(count == 6) {
            resultArr[4] += 1;
            return resultArr;
        }

        if(count == 7) {
            resultArr[3] += 1;
            return resultArr;
        }

        return resultArr;
    }

    //결과 출력
    public void printResult(int issuedLottoCount, int[] resultArr) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + resultArr[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + resultArr[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultArr[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultArr[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultArr[4] + "개");
        System.out.println("총 수익률은 " + getYield(issuedLottoCount, resultArr) + "%입니다.");
    }

    //총 수익률 구하기
    public String getYield(int issuedLottoCount, int[] resultArr)
    {
        int revenue = 0;
        for(int i = 0; i < resultArr.length; i++)
            revenue += getOneYield(i, resultArr[i]);

        double result = (double)revenue / (issuedLottoCount * 1000);
        result *= 100;

        DecimalFormat formatter = new DecimalFormat("###,###.#");
        String yield = formatter.format(result);

        return yield;
    }

    //발행한 로또의 수익
    public int getOneYield(int index, int value)
    {
        for(LottoStandard ls : LottoStandard.values())
        {
            if(index == ls.getIndex())
                return value * ls.getVlaue();
        }
        return 0;
    }
}
