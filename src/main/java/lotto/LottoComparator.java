package lotto;

import lotto.Lotto.Lotto;
import lotto.Lotto.WinningLotto;

public class LottoComparator {

    private volatile static LottoComparator lottoComparator;

    public Prize compare(Lotto myLotto, WinningLotto winningLotto)
    {
        int correctCount = 0;
        correctCount += compareWith(myLotto,winningLotto);
        boolean isCorrectSpecialNumber = correctWithSpecialNumber(myLotto,winningLotto);

        return Prize.of(correctCount,isCorrectSpecialNumber);
    }

    private Integer compareWith(Lotto myLotto,WinningLotto winningLotto)
    {
        int correctCount = 0;

        for (int myLottoNumberIndex = 0; myLottoNumberIndex < Lotto.LOTTO_SIZE; myLottoNumberIndex++)
        {
            Integer myLottoNumber = myLotto.get(myLottoNumberIndex);
            if(winningLotto.isContain(myLottoNumber))
            {
                correctCount++;
            }
        }

        return correctCount;
    }

    private boolean correctWithSpecialNumber(Lotto myLotto,WinningLotto winningLotto)
    {
        Integer specialNumber = winningLotto.getSpecialNumber();
        if(myLotto.isContain(specialNumber))
        {
            return true;
        }

        return false;
    }

    public static LottoComparator getInstance()
    {
        if(lottoComparator == null)
        {
            synchronized (LottoComparator.class)
            {
                if(lottoComparator == null)
                {
                    lottoComparator = new LottoComparator();
                }
            }
        }

        return lottoComparator;
    }


}
