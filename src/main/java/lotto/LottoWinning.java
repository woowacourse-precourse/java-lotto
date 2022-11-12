package lotto;

import java.util.List;

public class LottoWinning
{
    //compare issuedLotto to drawedLotto
    protected int compareLotto(List<Integer> issuedLotto, List<Integer> lottoAnswer)
    {
        int count = 0;
        for(int i = 0; i < lottoAnswer.size(); i++)
        {
            if(count == 5 || i == 6)
                count =+ 2;

            if(i < 6 && issuedLotto.contains(lottoAnswer.get(i)))
                count++;
        }

        return count;
    }

    //결과 계산
    public int[] getResult(int[] resultArr, int count)
    {
        if(count < 3)
            return resultArr;

        else if(count != 0 && count < 6)
            resultArr[count-3] += 1;

        else if(count == 6)
            resultArr[4] += 1;

        else if(count == 7)
            resultArr[3] += 1;

        return resultArr;
    }

    //결과 출력
    public void printResult(int[] resultArr) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + resultArr[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + resultArr[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultArr[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultArr[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultArr[4] + "개");
        System.out.println("총 수익률은 " + getYield() + "%입니다.");
    }

    //총 수익률 구하기
    private float getYield()
    {
        return 0;
    }
}
