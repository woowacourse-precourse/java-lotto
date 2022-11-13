package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Model {


    private final List<Lotto> lottoList; // save computer generated Lotto numbers
    private Lotto winningLotto; // save user input Lotto numbers
    private double returnRate; // rate of return by Model.userMoney
    private int userMoney; // user input value

    public Model() {
        this.lottoList = new ArrayList<>();
    }

    /**
     *
     * @return Lotto object lists
     */
    public List<Lotto> getLottoList(){
        return lottoList;
    }

    /**
     * judge money is constructed by digits
     * @param money served by setUserMoney
     * @return Is money variable is constructed by digits
     */
    private boolean validateInt(String money) {
        for(int i = 0; i < money.length(); i++){
            if(!Character.isDigit(money.charAt(i))){
                return false;
            }
        }
        return true;
    }
    /**
     * set money with user input
     * @param stringMoney String to be thousands unit
     */
    public void setUserMoney(String stringMoney) {
        if(!validateInt(stringMoney)){
            throw new IllegalArgumentException("[ERROR] Please input Number only");
        }
        int money = Integer.parseInt(stringMoney);
        if(money % 1000 > 0){
            throw new IllegalArgumentException("[ERROR] Please enter in thousands");
        }
        this.userMoney = money;
    }

    /**
     * generate lotto numbers.
     * repeat money / 1000 times.
     */
    public void generateLotto() {
        System.out.println(this.userMoney/1000);
        for(int i = 0; i < this.userMoney/1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            this.lottoList.add(new Lotto(numbers));
        }
    }
}

