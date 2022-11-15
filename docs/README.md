# 로또 프로그램
**입력:** 
1. 로또를 구매할 금액
2. 로또 당첨 번호
3. 보너스 번호  
-----------------
**출력:** 
1. 구매한 로또의 수량과 번호
2. 당첨된 개수
3. 수익률  
-----------------
### 전반적인 흐름
![로또](https://user-images.githubusercontent.com/54941130/200999542-ad139ce2-3f41-4895-85e2-61028e848a65.png)
-----------------
### UI 분할
![로또UI분리](https://user-images.githubusercontent.com/54941130/201557191-b2ea34eb-4946-43e9-b320-0124e5c573c7.png)
-----------------
### 기능 구현 필요 목록:
- [X] 로또 클래스 구현
    #### 로또 클래스로 생성된 객체에는 복권 1장의 번호가 담겨있음.
    #### 또한, 모든 로또 클래스는 공통적으로 숫자의 개수, max number, min number, price 에 대한 정보를 공유함.
-----------------
    예) Lotto ticket = new Lotto(랜덤 번호);
    &rightarrow;ticket.numbers 는 List<Integer> 로 이루어진 랜덤 번호를 저장하게 됨.
-----------------
    상수 목록
    MIN_NUMBER = 1;
    MAX_NUMBER = 45;
    LOTTO_SIZE = 6;
    PRICE_OF_LOTTO = 1000;
    
    메소드 목록
    <Lotto>
    1. validateSize()
        숫자의 개수가 6을 넘어서는지 확인
    2. validateOverlap()
        숫자가 중복되지않는지 확인
    3. validateOutOfRange()
        숫자가 1~45 범위 안에 있는지 확인
    4. getLottoNumbers()
        Lotto의 번호를 반환해 줌.
-----------------

- [X] 로또 구입 금액 입력 + 예외처리
    #### 로또를 구입할 금액을 입력받고, 예외를 확인한 뒤, LottoGame class 멤버 변수 moneyToBuy 에 저장.
-----------------
    예) "8000" 입력 &rightarrow; moneyToBuy라는 변수에 금액 저장.
-----------------
    메소드 목록
    <Application>
    1. inputForMoney()
        구매할 금액을 입력받아 LottoGame으로 전달.

    <LottoGame>
    1. setMoneyToBuy()
        구매할 금액을 입력받아 예외 확인 후 저장.
    2. validateMoney()
        입력받은 금액 예외 처리
    3. checkOnlyNumber()
        금액이 오직 숫자로만 이루어져 있는지 체크
    4. checkDivisibleNumber()
        금액이 1000원 단위로 나누어 떨어지는지 체크
-----------------

- [X] 로또 생성(구매)
    #### 구입금액만큼 로또를 생성하여, LottoGame class 멤버 List<Lotto> purchasedLottoTickets 에 넣어줌.
-----------------
    예) 구입금액: 8000 &rightarrow; 로또 8개 생성 후 purchasedLottoTickets에 저장.
-----------------
    메소드 목록
    <LottoGame>
    1. buyLotto()
        구입 금액 만큼 로또를 생성받아와, purchasedLottoTickets에 저장.
    2. createLotto()
        1 ~ 45 까지 랜덤하게 중복없이 6개의 숫자를 생성하여, 로또로 만들어 리턴 해줌.
-----------------

- [X] 로또 수량, 번호 출력
    #### 구매한 로또들의 개수와 로또들의 번호를 출력해줌.
-----------------
    출력 예) 
        8개를 구매했습니다.
        [8, 21, 23, 41, 42, 43]
        [3, 5, 11, 16, 32, 38]
        [7, 11, 16, 35, 36, 44]
        [1, 8, 11, 31, 41, 42]
        [13, 14, 16, 38, 42, 45]
        [7, 11, 30, 40, 42, 43]
        [2, 13, 22, 32, 38, 45]
        [1, 3, 5, 14, 22, 45]
-----------------
    메소드 목록
    <Application>
    1. outputTickets(LottoGame lottoGame)
        lottoGame의 getPurchasedLottoTickets() 메소드를 이용하여, 
        구매한 로또들을 가져와, 구매한 로또들의 개수와 번호를 출력.
    <LottoGame>
    1. getPurchasedLottoTickets()
        LottoGame에 저장된 purchasedLottoTickets를 반환 해줌.
-----------------

- [X] 당첨 번호, 보너스 번호 입력 + 예외 처리
    #### 당첨 번호를 입력받아, 당첨번호를 가진 Lotto 객체를 만들어 winningNumber에 저장
    #### 보너스 번호를 입력하여 bonusNumber에 저장
-----------------
    예)
        당첨 번호를 입력해 주세요.
        1,2,3,4,5,6

        보너스 번호를 입력해 주세요.
        7
-----------------
    메소드 목록
    <Application>
    1. inputWinningNumber()
        당첨번호를 입력받음
    2. inputBonusNumber()
        보너스번호를 입력받음

    <LottoGame>
    1. setWinningNumber()
        inputWinningNumber()에서 전달받은 값을 예외 처리 후, Lotto 객체로 만들어 winningNumber에 저장
        1-1. checkArrayOnlyNumber()
            array 값이 숫자로만 이루어져있는지 확인
        1-2. makeArrayToLotto()
            array 값을 받아 Lotto 객체로 만들어 반환
    2. setBonusNumber()
        inputBonusNumber()에서 전달받은 값을 예외 처리 후, Integer 형태로 변환하여 bonusNumber에 저장
        1-1. validateBonusNumber()
            받아온 값을 확인 -> 당첨번호와 중복 여부, 숫자 범위 내에 포함 여부
            1-1-1. checkOutOfRange()
                String 타입을 받아와 범위를 확인
            1-1-2. checkOverlapWinningNumber()
                String 타입을 받아와 당첨번호와 중복 여부 확인
-----------------

- [X] 예외 문구 출력 (열거체 이용)
    #### ErrorType 열거체를 이용하여, 예외 처리 시, 에러문구 출력
-----------------
    예)  input -> "1000j"
        [ERROR] Input money is wrong

-----------------
    예외 목록
        1. Lotto 제작 중 문제 발생
            checkSize(numbers) 
                        || checkOverlap(numbers) 
                        || checkOutOfRange(numbers)
        2. 잘못된 값을 입력 받아와 문제 발생
            2-1. inputForMoney()
                -> checkOnlyNumber(answer) 
                        || checkDivisibleNumber(answer)
            2-2. inputWinningNumber()
                -> checkOnlyNumber(number)
            2-3. inputBonusNumber()
                -> checkOnlyNumber(answerBonusNumber) 
                        || checkOutOfRange(answerBonusNumber) 
                        || checkOverlapWinningNumber(answerBonusNumber)
-----------------
    예외 enum 목록
    <ErrorType>
    MAKE_LOTTO_ERROR("making lotto is wrong"),
    INPUT_MONEY_ERROR("Input money is wrong"),
    INPUT_WINNING_NUMBER_ERROR("Input winning numbers are wrong"),
    INPUT_BONUS_NUMBER_ERROR("Input bonus number is wrong");
-----------------

- [X] 당첨 번호와 로또 비교
    #### 당첨 번호와 구매한 로또들을 비교하여, 등수를 저장 -> List<Integer> winningCount
![로또 비교](https://user-images.githubusercontent.com/54941130/201799021-8b7cdbaa-fad7-44d4-8773-d23812cf7352.png)
-----------------
    메소드 목록
    <LottoGame>
    1. setWinningCount()
        List<Integer> winningCount에 구매한 로또들의 등수를 저장.
    2. rankLotto()
        구매한 로또를 받아 등수를 매김.
    2-1. compareWinningNumberAndLotto()
        당첨번호와 로또를 비교
    2-2. compareBonusNumberAndLotto()
        보너스번호와 로또를 비교
    2-3. makeRank()
        일치하는 개수와 보너스 일치 여부를 받아, 당첨 순위를 리턴.
-----------------

- [X] 획득 금액 계산
    #### 당첨 번호와 구매한 로또들을 비교하여, 등수를 저장 -> long earnedMoney
-----------------
    변수 목록
    <Lotto>
    static final long[] MONEY_OF_RANK = {2000000000, 30000000, 1500000, 50000, 5000};
    당첨 순위에 따른 금액 저장
 
    <LottoGame>
    long earnedMoney
    로또를 통해 얻은 돈 저장
-----------------
    메소드 목록
    <LottoGame>
    1. setEarnedMoney()
        earnedMoney에 얻은 금액 저장
    2. countMoney()
        Lotto의 winningCount(당첨순위리스트)를 받아 총 얻은 금액을 반환
-----------------

- [X] 결과 출력
    #### 당첨결과와 수익률을 출력한다.
-----------------
    메소드 목록
    <Application>
    1. outputWinningTickets()
        당첨결과를 받아와 출력
    2. outputRevenueLotto()
        수익률을 계산하여 출력
-----------------