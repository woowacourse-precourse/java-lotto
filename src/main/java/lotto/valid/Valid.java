package lotto.valid;

/*
1. [ERROR] `,`와 숫자가 아닌 값
2. [ERROR] `,`로 나눴을 때 6자리가 아닐 때
3. [ERROR] 중복된 값이 들어올 수 없다.
4. [ERROR] 숫자가 아닌 값 들어올 수 없다.
5. [ERROR] 1 ~ 45까지의 정수만 들어올 수 있다.
6. [ERROR] 1000원 미만 단위 입력 받을 수 없다.
-[ ] Lotto 당첨번호 입력(1,2,3,4,5)
-[ ] Lotto 보너스번호 입력(3,4,5)
 */
public class Valid {

    public static String[] lotto_answer_valid(String answer){
        return answer.split(",");
    }
}
