package lotto.model;

import lotto.price;

import java.util.List;

public class Result {
    private int[] resultArray;
    private double rateOfReturn;
    private int sum;

    public Result() {
        rateOfReturn=0;
        resultArray=new int[6];
        for(int i=0;i<6;i++)
            resultArray[i]=0;
        sum=0;
    }

    public void calculatorResult(List<List<Integer>> randomNumbers, List<Integer> lottoNumber, int bonusNumber){
        randomNumbers.stream()
                .forEach(numberList->setResult(
                        setResultArray((int)numberList.stream()
                        .filter(number->lottoNumber.contains(number))
                        .count(),
                        (int)numberList.stream()
                        .filter(number->number==bonusNumber)
                        .count()))
                );
    }
    private static int setResultArray(int number,int bonusNumber)
    {
        if(number==3)
            return 1;
        if(number==4)
            return 2;
        if(number==5) {
            if (bonusNumber==1)
                return 4;
            return 3;
        }
        if(number==6)
            return 5;

        return 0;
    }

    private void setResult(int index){
        resultArray[index]++;
    }
}
