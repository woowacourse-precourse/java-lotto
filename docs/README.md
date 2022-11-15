### 구현할 기능 목록

1. ListOfLottos 클래스: 로또 로직을 구현한 클래스
    - 구입 금액에 맞게 로또 n개 생성기 (generateListOfLottos)
   - 로또 모두 출력하는 메소드 (printAllLottos)
2. Lotto 클래스
   - 로또 번호 오름차순으로 정렬하는 메소드 (sortLotto)
   - View 클래스의 validator를 활용한 validator 메소드 (validateLotto)
   - 로또를 출력하는 메소드 (printLotto)
3. Program 클래스
   - 유저의 구입 금액을 입력받아 로또 셋업하는 메소드 (lottoSetup)
   - 유저의 당첨 번호를 입력받아 랭킹 계산 전까지 셋업하는 메소드 (winSetup)
   - 로또 순위 계산하는 메소드 (result)
4. View 클래스: user input 클래스
    - 구입 금액 입력 받아서 로또 뽑기 회수 리턴, 예외 상황 시 에러 발생시키는 메소드 (getMoneyInput)
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
5. PrintMsg 클래스: message print 클래스
   - 구입금액 입력 받을 때 메시지 출력하는 메소드 (printMoneyInputMsg)
   - 로또 구매 개수 출력하는 메소드 (printNumberOfLottosMsg)
   - 당첨 번호 입력 받을 때 메시지 출력하는 메소드 (printWinnerInputMsg)
   - 보너스 번호 입력 받을 때 메시지 출력하는 메소드 (printBonusInputMsg)
   - 소수점 둘째 자리에서 반올림한 수익률 출력하는 메소드 (printProfitRate)
   - 당첨 내역 출력하는 메소드 (printResult)
6. Application 클래스: 게임 실행
7. Ranking enum 클래스
   - enum 정의
   - 로또의 결과가 어느 랭킹에 해당하는지 찾는 메소드 (findRanking)
   - enum의 변수에 대한 get 메소드 (getMatch, getPrize, getBonusMatch, getDescription)
8. DrawLotto 클래스
   - 당첨 내역 확인하는 로직 메소드 (checkLotto)
   - 로또 당첨이 5 숫자일 경우 보너스 숫자와 일치하는 확인하는 메소드 (checkBonus)
   - CheckListOfLottos 메소드를 위해 비교 맵을 셋업하는 메소드 (setupComparison)
   - 로또 리스트의 당첨 내역 확인하는 메소드 (checkListOfLottos)
   - 로또의 랭킹을 리턴하는 메소드 (getRank)
   - 소수점 둘째 자리에서 반올림한 수익률 계산하는 메소드 (calculateProfitRate)
   - 수익 계산하는 메소드 (calculateProfit)
9. LottoTest
   - 5개의 숫자를 넣을 때
   - 겹치는 숫자를 넣을 때
   - 1~45 범위 밖의 숫자를 넣을 때
10. ApplicationTest
   - 보너스 볼과 일치해야 하는 경우 
   - 구입 금액이 1000으로 나눠떨어지지 않는 경우
11. GameTest