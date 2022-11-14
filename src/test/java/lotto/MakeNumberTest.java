package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MakeNumberTest {

    @Test
    void makeUserNumber() {
        /** GIVEN **/
        int buyCount = 6;

        MakeNumber makeNumber = new MakeNumber();

        /** WHEN **/
        List<List> numbers = makeNumber.makeUserNumber(buyCount);

        /** THEN **/

        //개수가 같은지
        assertEquals(numbers.size(),buyCount);
        //중복이 있는지
        for (List<Integer> number:
             numbers) {
            assertEquals(number.stream().distinct().count(),6);
        }
    }
}