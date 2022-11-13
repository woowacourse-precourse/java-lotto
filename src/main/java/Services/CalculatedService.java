package Services;

import Dto.Money;

public class CalculatedService {

    public int lottoSize(Money size){
        int number = size.getMoney();
        if(number % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 돈을 입력하시오");
        }
        return number / 1000;
    }
}
