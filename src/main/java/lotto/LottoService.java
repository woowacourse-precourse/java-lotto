package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private final static int ZERO_INITIALIZATION=0;
    private final static int MATCH_WIN_NUMBER=1;
    private final static int MATCH_BONUS_NUMBER=10;
    private final static String COMMA = ",";

    private final List<Lotto> lottos = new ArrayList<>();
    private final List<Integer> lottoNumberCountRight = new ArrayList<>();
    private final List<Integer> numbersOfWin = new ArrayList<>();


    public int getLottoCount(String input){
        try{
            int purchaseAmount = Integer.parseInt(input);
            validatePurchase(purchaseAmount);
            return purchaseAmount / Money.THOUSAND.getAmount();
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    private void validatePurchase(int purchaseAmount) {
        if(purchaseAmount%1000!=0){
            throw new IllegalArgumentException();
        }
    }

    public void drawLottos(int lottoCount){
        for (int i=ZERO_INITIALIZATION; i<lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public List<Integer> findNumbersOfWin(String winNumber, String bonusNumber){
        compareLottoNumber(winNumber,bonusNumber);
        numbersOfWin.add(Collections.frequency(lottoNumberCountRight, WinCount.THREE_WIN.getRightCount())
                + Collections.frequency(lottoNumberCountRight, WinCount.TWO_WIN_ONE_BONUS.getRightCount()));
        numbersOfWin.add(Collections.frequency(lottoNumberCountRight, WinCount.FOUR_WIN.getRightCount())
                + Collections.frequency(lottoNumberCountRight, WinCount.THREE_WIN_ONE_BONUS.getRightCount()));
        numbersOfWin.add(Collections.frequency(lottoNumberCountRight, WinCount.FIVE_WIN.getRightCount())
                + Collections.frequency(lottoNumberCountRight, WinCount.FOUR_WIN_ONE_BONUS.getRightCount()));
        numbersOfWin.add(Collections.frequency(lottoNumberCountRight, WinCount.FIVE_WIN_ONE_BONUS.getRightCount()));
        numbersOfWin.add(Collections.frequency(lottoNumberCountRight, WinCount.SIX_WIN.getRightCount()));
        return numbersOfWin;
    }

    public double getTotalReturn(String purchaseAmount){
        int grossEarning = ZERO_INITIALIZATION;
        List<Integer> moneys = Stream.of(Money.values()).map(m -> m.getAmount()).filter(m->m!=1000).
                collect(Collectors.toList());
        for(int i=0; i<numbersOfWin.size();i++){
            grossEarning+= numbersOfWin.get(i)*moneys.get(i);
        }
        return grossEarning/(Double.parseDouble(purchaseAmount))*100;
    }


    private void compareLottoNumber(String winNumber, String bonusNumber){
        List<Integer> winNumbers = changeType(winNumber);
        validateBonusNumber(bonusNumber);
        for (Lotto lotto : lottos) {
            int lottoNumbersRight = findLottoNumbersRight(lotto,winNumbers, Integer.parseInt(bonusNumber));
            lottoNumberCountRight.add(lottoNumbersRight);
        }
    }

    private void validateBonusNumber(String bonusNumber) {
        try {
            int bonus = Integer.parseInt(bonusNumber);
            if (bonus<1 || bonus>45){
                throw new IllegalArgumentException();
            }
        }catch (Exception e){
            throw new IllegalArgumentException();
        }

    }

    private int findLottoNumbersRight(Lotto lotto, List<Integer> winNumbers, int bonusNumber){
        int sameNumber=ZERO_INITIALIZATION;
        for (Integer integer : winNumbers) {
            if (lotto.getNumbers().contains(integer)){
                sameNumber+=MATCH_WIN_NUMBER;
            }
        }
        if(lotto.getNumbers().contains(bonusNumber)){
            sameNumber+=MATCH_BONUS_NUMBER;
        }
        return sameNumber;

    }


    private List<Integer> changeType(String winNumber) {
        return Arrays.asList(winNumber.split(COMMA)).stream().
                map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    public List<Integer> getLottoNumberCountRight(){
        return lottoNumberCountRight;
    }


}
