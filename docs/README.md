### 구현할 기능 목록

1. Game 클래스: 로또 로직을 구현한 클래스
    - 중복되지 않는 6개 숫자 생성기 (generateLotto)
    - 구입 금액에 맞게 로또 n개 생성기 (generateArrOfLottos)
    - 당첨 번호 입력값을 ,로 나누고 Integer List로 리턴하는 메소드 (getListOfNumbers)
    - 당첨 내역 확인하는 로직 메소드 (checkLotto)
2. Lotto 클래스
3. View 클래스: user input/output 클래스
    - 구입 금액 입력 받아서 로또 뽑기 회수 리턴, 예외 상황 시 에러 발생시키는 메소드 메소드 (getMoneyInput)
      - 구입 금액이 1000으로 나눠떨어지지 않으면 IllegalArgumentException 발생시키는 메소드 (validateIsDivisible)
      - 입력값이 숫자가 아닌 값이 있으면 IllegalArgumentException 발생시키는 메소드 (validateIsNumber)
    - 당첨 번호 입력 받아서 숫자 리스트로 리턴, 예외 상황 시 에러 발생시키는 메소드 (getWinnerInput)
      - 번호 입력이 중복되면 IllegalArgumentException 발생시키는 메소드 (validateUniqueNumberInput)
      - 번호가 1~45 범위 밖이면 IllegalArgumentException 발생시키는 메소드 (validateNumbersInRange)
      - 입력된 숫자의 개수가 6이 아니면 IllegalArgumentException 발생시키는 메소드 (validateNumberOfNumbers)
      - 입력값이 ',' 제외 숫자가 아닌 값이 있으면 IllegalArgumentException 발생시키는 메소드 (validateAreNumbers)
      - 위의 validator 메소드를 한꺼번에 실행하는 메소드 (validateWinnerInput)
    - 보너스 번호 입력 받고 숫자로 리턴, 예외 상황 시 에러 발생시키는 메소드 (getBonusInput)
      - 번호 입력이 당첨 번호 입력과 중복되면 IllegalArgumentException 발생시키는 메소드 (validateUniqueNumberInput)
      - 입력값이 숫자가 아니면 IllegalArgumentException 발생시키는 코드 (validateIsNumber, 위와 동일)
      - 번호가 1~45 범위 밖이면 IllegalArgumentException 발생시키는 메소드 (validateNumberInRange, 위와 동일)
      - 위의 validator 메소드를 한꺼번에 실행하는 메소드 (validateBonusInput)
    - 구입금액 입력 받을 때 메시지 출력하는 메소드 (printMoneyInputMsg)
    - 로또 구매 개수 출력하는 메소드 (printNumberOfLottosMsg)
      (로또 클래스 구현 이후 구현)
    - 로또 모두 출력하는 메소드 (printAllLottos)
    - 소수점 둘째 자리에서 반올림한 수익률 출력하는 메소드 (printProfitRateMsg)
    - 당첨 내역 출력하는 메소드 (printResult)
4. Application 클래스: 게임 실행
