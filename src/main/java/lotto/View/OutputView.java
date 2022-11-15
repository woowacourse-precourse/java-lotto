package lotto.View;

import lotto.Dto.Lotto;

import java.util.List;
import java.util.Map;

import static lotto.Dto.ConstDto.InputOutputConstDto.*;

enum Reword {
    FIVE_WORD("3"),FOUR_WORD("4"),THREE_WORD("5"),TWO_WORD("5BonusNumber"),ONE_WORD("6");
    public final String word;

    Reword(String word) {
        this.word = word;
    }
}

public class OutputView {

    public void printLottoSize(int lottoSize){
        System.out.println(lottoSize+PRINT_LOTTO_SIZE_MESSAGE);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for(Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
        System.out.println();
    }
    public void printWinnigResult(Map<String,Integer> winningResult){
        System.out.println(WINNING_STATS);
        System.out.println("---");
        System.out.println(THREE_MATCHES+winningResult.get(Reword.FIVE_WORD.word)+DEPENDENT_NOUN);
        System.out.println(FOUR_MATCHES+winningResult.get(Reword.FOUR_WORD.word)+DEPENDENT_NOUN);
        System.out.println(FIVE_MATCHES+winningResult.get(Reword.THREE_WORD.word)+DEPENDENT_NOUN);
        System.out.println(FIVE_BONUS_NUMBER_MATCHES+winningResult.get(Reword.TWO_WORD.word)+DEPENDENT_NOUN);
        System.out.println(SIX_MATCHES+winningResult.get(Reword.ONE_WORD.word)+DEPENDENT_NOUN);
    }
}
