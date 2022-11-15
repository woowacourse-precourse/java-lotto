package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoMaker {

    private HashSet overlapNumber= new HashSet();
    private Exception exception = new Exception();


    List<Integer> splitNumber(String number){
        String [] numbers =number.split(",");
        return stringToInteger(numbers);
    }

    private List<Integer> stringToInteger(String [] numbers){

        List<Integer> LottoNumber = new ArrayList<>();

        for(int i=0;i<numbers.length;i++){
            if(exception.lottoValidator(Integer.parseInt(numbers[i]))){
                LottoNumber.add(Integer.parseInt(numbers[i]));
                addOverlap(Integer.parseInt(numbers[i]));
                continue;
            }
            throw new IllegalArgumentException("ERROR");
        }
        return LottoNumber;
    }

    public void addOverlap(int number){
        overlapNumber.add(number);
    }

    public boolean overlapException(String type){
        //System.out.println(overlapNumber.size());
        if(type =="lotto"){
            if(overlapNumber.size()==6)return true;
        }

        if(type=="bonusLotto"){
            if(overlapNumber.size()==7)return true;
        }

        return false;
    }

}
