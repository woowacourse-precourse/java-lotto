# 단위테스트 작성 목록
1. Lotto 테스트
2. UserLottos 테스트
3. WinningLotto 테스트
4. LottoResult 테스트<br>
**(맨 아래 구체적인 내용 작성)**

---
# 오류 해결 과정 정리

1. 돈을 넣어도, 로또 0개를 생성하는 오류 발생
    - 에러 원인 :
      1) Lotto 인스턴스 생성시, 
      2) **isNotDuplicated() 메서드가 항상 false를 반환함**<br>
             -> Set.of(numbers).size() == LOTTO_NUMBER;
      3) Lotto 인스턴스가 생성되지 않음<br><br>
   - 에러 해결법 :
     - Set.of() 를 Set.copyOf()로 바꿔준다
     - Set.of()는 ImmutableCollections 이기 때문에, 
       <br><br><br>

2. UnsupportedOperationException 예외 발생되며, 로또 생성 실패
   - 에러 원인 : 
     1) ApplicationTest의 List.of()로 생성된 입력 바꿀수 없음!!
     2) 로또 클래스 생성시, 매개변수인 `List<Integer> numbers` 정렬하려고 함
     3) **List.of로 생성된 리스트는 ImmutableCollections이므로, 수정(정렬)하려고 하면** 
     4) **UnsupportedOperationException 예외 발생<br><br>**
   - 에러 해결법 :
     - Lotto클래스의 정렬 기능 삭제
     - Lotto인스턴스 생성시, 정렬하지 않고,
     - 출력 시, 값을 복사하여 출력하도록 함.
       <br><br><br>

3. 구매 금액으로, 1005,1500,2300,5000005 입력해도 예외가 발생하지 않았다.
    - 에러 원인 :
      1) validateMoney() 메서드의 조건문을
      2) "로또 금액보다 작고 && 1000원 단위가 아닌경우"로 설정하여, 
      3) 두 조건 모두를 충족해야 예외를 발생했다.<br><br>
    - 에러 해결법 :
      - UserLottos클래스의 메서드 조건문을 `money < LOTTO_PRICE || money % LOTTO_PRICE != 0` 으로 변경
        <br><br><br>

4. 로또의 당첨 등수 확인 테스트 실행시, <br>
 3등(당첨번호 5개 일치,보너스번호 false)을 예상했으나, 5등(3개 일치)으로 매김
    - 에러 원인 :
        1) Rank (enum클래스) 의 `hasSameRankBy()`메서드
           ```
           if(matchCount == SECOND_AND_THIRD_MATCH_COUNT) {
           return this.hasBonusNumber == hasBonusNumber;
           }
        
        2) = matchCount가 5이면, <br>enum상수의 보너스번호 - 매개변수 보너스번호 여부가 일치하는지 확인한다.
        3) WinningLotto의 getRankOf메서드에서,
        4) Rank.rankValues()는 FIFTH부터 순회한다.
        5) matchCount==5이고, FIFTH 상수의 hasBonusNumber 값과도 일치하므로, FIFTH가 되는 것이다.

           <br><br>
    - 에러 해결법 :
        - Rank 클래스의 hasSameRankBy 메서드 속 if 조건문을 아래와 같이 수정한다.
            ```
          if(matchCount == this.matchCount && matchCount ==  SECOND_AND_THIRD_MATCH_COUNT ) { ~ }
    <br><br>

5. 보너스 번호가 45 이상이어도 예외 발생하지 않았다.
     - 에러 해결법 : <br>
        WinningLotto의 validateBonusNumber() 메서드를 수정한다  -> 보너스 번호가 범위 안에 있지 않으면, 예외를 발생한다.
       <br><br>

---
# 단위 테스트 작성 목록

1. Lotto 테스트
    1. 로또 번호 리스트와 일치하는 번호 개수 세기 테스트
       - @ParameterizedTest
       - @MethodSource("provideWinningNumbersAndExpected") 사용해서,<br>
         Stream<Arguments>를 매개변수로 제공하면, <br>
         Stream<Arguments> 순회하면서 각 Arguments 요소를 인자로 사용한다.
   2. 보너스 번호 가지고 있는지 테스트
      - @CsvSource 사용
   3. 로또의 생성자 테스트(=유효성 검사)
      - @MethodSource("provideInvalidNumbers")
        사용하여, <br>
      유효하지않은(범위 오류 / 중복 오류/ 크기 오류가 있는) 로또 번호 리스트를 제공한다.
      - 이를 가지고 로또를 생성했을 때, 오류 발생하는지 테스트

    <br><br>
2. UserLottos 테스트
    1. 유효하지 않은 돈을 입력했을 때, 예외 발생하는지 테스트 (=생성자 테스트)
       - @ValueSource 의 int 배열 사용
    2. 금액에 해당하는 개수만큼 로또 생성하는지 테스트
       - @MethodSource("provideUserLottosWithMoney") 사용하여,<br>
         금액을 넣고 로또 생성,<br>
         생성된 로또의 개수가 expected한 개수와 일치하는지 체크하기.

    <br><br>
3. WinningLotto 테스트
   1. 금액에 해당하는 개수만큼 로또 생성하는지 테스트
      - @MethodSource("provideDuplicatedNumbersAndBonusNumber") 사용하여,
        중복되는 당첨번호와 보너스번호를 넣을 경우 IllegalArgumentException예외가 발생하는지 테스트한다.
   2. 매개변수로 넣은 로또의 당첨 등수가 올바른지 테스트
      - 당첨번호와 보너스번호를 지정하고,
      - @MethodSource("provideLottoAndRank") 사용하여,
        제공한 로또의 등수가 예상한 등수와 일치하는지 확인한다

   3. 유효하지 않은 로또번호나 보너스 번호로 객체 생성 시도시 예외 발생하는지 테스트<br>
   4. 생성과 등수 정하기 기능 테스트
      - @MethodSource("provide_WinningLotto_And_Rank")사용하여,
        유효한값을 넣었을 때,<br>
        WinningLotto를 생성하고, lotto의 예상한 등수(enum)를 반환하는지 테스트
        <br><br><br>
      
4. LottoResult 테스트<br>
   1. {등수:개수} 정확한지 기능 테스트
      1) UserLottos의 로또 번호들을 내가 지정한 값으로 테스트
      - assertRandomUniqueNumbersInRangeTest의 mock 기능 사용해서,
      - Randoms.pickUniqueNumbersInRange() 사용시,
        입력 값이 내가 지정한 값이 될 수 있도록 함.
      2) OutputStream 사용하여, 바이트 배열에 저장되도록 함
      3) 형성한 resultmap을 String으로 출력하여 내가 예상했던 값이 들어있는지 확인한다.
         <br>   
   2. 수익률 계산 기능 테스트
      1. setResultMapTest(); 사용하여,
         내가 지정한 값으로 사용자로또 형성하도록 함
      2. 계산한 수익률이 내가 예상한 값과 일치하는지 확인
