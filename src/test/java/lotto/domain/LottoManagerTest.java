package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {
    @Test
    @DisplayName("숫자 형식이 아닐경우 에러 출력")
    void isNotNumberic(){
        LottoManager lottoManager = new LottoManager();
        assertThrows(NoSuchElementException.class, () ->{
            lottoManager.countLotto("1000a");
        });
    }

    @Test
    @DisplayName("1000으로 나누어 떨어지지 않을때 에러 출력")
    void hasRestError(){
        LottoManager lottoManager = new LottoManager();
        assertThrows(IllegalArgumentException.class, () ->{
            lottoManager.countLotto("1590");
        });

    }

    @Test
    @DisplayName("1000원 이하일때 에러 출력")
    void MinimumAmountError(){
        LottoManager lottoManager = new LottoManager();
        assertThrows(IllegalArgumentException.class, () ->{
            lottoManager.countLotto("999");
        });

    }

    @Test
    @DisplayName("랜덤 숫자에 중복이 없는지 확인")
    void isDuplication(){
        LottoManager lottoManager = new LottoManager();
        List<List<Integer>> lists = lottoManager.buyerLottoNumbers(1000);
        for (List<Integer> list : lists) {
            Set<Integer> numberSet = new HashSet<>(list);
            Assertions.assertEquals(numberSet.size(),list.size());
        }
    }
}