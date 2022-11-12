package lotto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Lotto winningNumber;
    private List<Lotto> lottos;

    public int putMoneyforLotto(String money){
        int totalPayment;
        try {
            totalPayment = Integer.parseInt(money);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
        checkDivideBy1000(totalPayment);

        return (int)totalPayment/1000;
    }
    public void checkDivideBy1000(int totalPayment) {
        if(totalPayment % 1000 !=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야합니다.");
        }
    }
    public void setWinningNumber(List<Integer> numbers){
        this.winningNumber = new Lotto(numbers);
    }
    public void setLottos(int tiket){
        LottoCreator lottoCreator = new LottoCreator();
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<tiket; i++){
            lottos.add(lottoCreator.createRandomLotto());
        }
        this.lottos = lottos;
    }
}
