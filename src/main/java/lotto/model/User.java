package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    static final String INPUT_RANGE="[0-9]+";
    private String money;
    private String lottoQuantity;
    private List<Lotto> lottos;

    public User(){
        lottos=new ArrayList<Lotto>();
    }

    public void inputMoney(){
        String money=Console.readLine();
        validate(money);
        this.money=money;
    }

    public String getMoney(){return money;}
    public List<Lotto> getLottos(){return lottos;}

    public void validate(String money){
        if(checkComposeOfNumbers(money)){
            throw new IllegalArgumentException("입력값은 숫자여야만 합니다.");
        }
        if(money.length()<3
                ||checkDivisibleByThousand(money.substring(money.length()-3))){
            throw new IllegalArgumentException("구입금액은 1000원 단위이어야 합니다.");
        }
    }
    private boolean checkComposeOfNumbers(String money){
        return !money.matches(INPUT_RANGE);
    }

    private boolean checkDivisibleByThousand(String lastThreeDigit){
        if(!lastThreeDigit.equals("000")){
            return true;
        }
        return false;
    }

    public void setLottoQuantity(){
        lottoQuantity=calculateQuantity();
    }

    private String calculateQuantity(){
        return money.substring(0,money.length()-3);
    }

    public void printLottoQunantity(){
        System.out.println();
        System.out.println(lottoQuantity+"개를 구매했습니다.");
    }

    public void buyingLotto(){
        for(int number=1;number<=Integer.parseInt(lottoQuantity);number++) {
            lottos.add(generateLotto());
        }
    }

    private Lotto generateLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

    public void printAllBuyingLotto(){
        for (Lotto lotto: lottos){
            lotto.printLotto();
        }
        System.out.println();
    }
}
