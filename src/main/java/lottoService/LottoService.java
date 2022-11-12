package lottoService;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import common.Constant;
import common.LottoGameMessage;
import domain.Lotto;
import domain.LottoRank;
import domain.LottoReward;
import domain.Player;

import java.util.*;

public class LottoService {

    LottoGameMessage lottoGameMessage = new LottoGameMessage();

    public void inputPurchasePriceAndCheckException(Player player){
        lottoGameMessage.printPurchasePriceMessage();
        String purchaseLottoPrice = input();
        isNumber(purchaseLottoPrice);
        player.inputPurchaseLottoPrice(Integer.parseInt(purchaseLottoPrice));
        player.canDivideThousand();
        player.countLottoNumber();
    }

    public void hasSixLottoNumber(String inputPlayerLottoPickNumbers){
        if(inputPlayerLottoPickNumbers.split(",").length != 6)
            throw new IllegalArgumentException(Constant.NOT_MATCH_PICK_NUMBER_EXCEPTION);
    }

    public void isValidRange(List<Integer> winningLottoNumbers){
        for (Integer number : winningLottoNumbers) {
            if(Constant.LOTTO_START_NUMBER > number || Constant.LOTTO_END_NUMBER < number)
                throw new IllegalArgumentException(Constant.NOT_VALID_RANGE_EXCEPTION);
        }
    }


    public void printPlayerLottoNumberAndCreateLottoNumber(Player player){
        lottoGameMessage.printPurchaseCountMessage(player.getLottoCount());
        createPlayerRandomLottoPickNumbers(player);
        lottoGameMessage.printPlayerRandomLottoPickNumbers(player);
    }

    public void isNumber(String number){
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(Constant.NOT_NUMBER_EXCEPTION);
        }
    }

    public void createPlayerRandomLottoPickNumbers(Player player){
        for (int lottoNum = 0; lottoNum < player.getLottoCount(); lottoNum++) {
            Lotto playerLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(playerLotto.getNumbers());
            player.getPlayerLottoPickNumbers().add(playerLotto);
        }
    }

    private String input(){
        return Console.readLine().trim().replaceAll(" ","");
    }
}
