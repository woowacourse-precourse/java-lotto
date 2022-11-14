package lotto;

import java.util.Comparator;
import java.util.List;

public class Store {
    Customer customer;

    Store(Customer customer){
        this.customer=customer;
    }
    public void buy(){
        int count = countLotto();
        Lotto lotto;
        for(int i=0; i<count; i++){
            lotto = makeLotto();
            saveLotto(lotto);
        }
    }

    public int countLotto(){
        return customer.getMoney()/Money.MOD;
    }
    public Lotto makeLotto(){
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1,45,6);
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }
    public void saveLotto(Lotto lotto){
        DB.insert(lotto);
        return;
    }

}
