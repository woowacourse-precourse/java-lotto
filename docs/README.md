
📌 우선 한글로 필요한 클래스를 먼저 정의해보겠습니다.

### 구매금액 입력

- 구매금액 입력받기
- 구매 금액 예외처리
    - 숫자 아닌 문자
    - 1000원 단위로 안떨어지면 예외처리

### 당첨 번호 입력

- 당첨번호 입력받기
- 당첨번호 예외처리
    - 6개가 들어왔는지
    - 쉼표로 구분이 됐는지
    - 숫자만 들어왔는지
    - unique 한 지

### 보너스 번호 입력

- 보너스번호 입력받기
- 보너스번호 예외처리
    - 6개가 들어왔는지
    - 쉼표로 구분이 됐는지
    - 숫자만 들어왔는지
    - 당첨번호와 겹치지 않는지

### 랜덤 로또 숫자 생성

- 구매 갯수 만큼 번호 생성
- 예외처리
    - 각각의 숫자들이 unique 한 지
    - 구매 금액에 맞게 생성이 되었는지

### 결과 비교하기

- 비교함수

### 결과 출력하기

- 당첨 등수 개수체크하기
- 수익률 계산함수

### 프린트함수

- 구매금액 출력 메세지
- 당첨번호 출력 메세지
- 보너스번호 출력 메세지
- 구매 번호출력 (오름차순)
- 당첨내역 출력
- 수익률 출력 (소수점 둘째자리)

### 에러 출력 함수 [Error]로 시작

- 숫자가 아니다
- 숫자의 범위가 아니다
- 쉼표 구분이 안된다
- 천원단위로 안떨어진다

---
이제 클래스로 나누고 변수와 구현해야할 함수를 정의해보겠습니다.

## Model Package

### Lotto (개발완료📌)
- variable
  - List<Integer> numbers
- function
  - Lotto(numbers) : 생성자
  - validate(numbers) 
    - 리스트의 사이즈가 6인지 체크하는 기능
    - 숫자들이 중복되지 않는지 체크하는 기능
    - 숫자들의 범위가 1~45인지 체크하는 기능
  - getNumbers() : numbers get Function
### Rank (Enum Class) (개발완료📌)
- variables
  - int count
  - int bonus
  - int prizeMoney
- Function
  - Rank(count, bonus, prizeMoney) : 생성자
  - getRank(count, bonus) : 당첨번호를 맞춘 개수와 보너스 번호를 맞춘 것에 따라서 value를 출력하는 함수

## Service Package
### LottoNumberService (개발완료📌️)
- function
  - receiveLottoSheetsAmount() : 구매금액을 받아올 함수
  - checkDivideBy1000() : 구매금액이 1000원으로 나누었을 때 나누어 떨어지는지 확인하는 함수
  - receiveLottoSheetsCount(lottoSheetsAmount) : 구매금액을 받아 구매장수를 정하는 함수
  - generateRandomNumber(int lottoSheetsCount) : 6개의 번호를 랜덤으로 부여한 한 장의 로또를 구매금액에 맞춰 여러 장 생성
### BonusNumberService (개발완료📌️)
- function
  - generateBonusNumber() : 보너스 넘버를 받아올 함수
  - checkNotEqualWinningNumber(winningNumberList, bonusNumber) : 보너스 숫자를 인자로 받아 당첨번호와 다른지 확인하는 함수
  - checkBonusRange(bonusNumber) : 보너스 숫자를 받아 보너스 숫자가 1~45 사이의 숫자인지 확인하는 함수
### WinningNumberService (개발완료📌️)
- function
  - generateWinningNumber() : 당첨 번호를 받아올 함수
  - converToInteger() : 당첨번호 문자열을 숫자리스트로 바꿀 함수
### CalculateResultService
- variable
  - Map<Rank, Integer> lottoCount
- function
  - compare(winningNumberList, bonusNumber, lottoSheetsList)
    - 당첨번호와 보너스넘버를 구매한 로또번호들을 비교하는 함수
  - add(rank, bonus): rank와 bonus를 받아 등수를 기록하는 함수
  - isBonus(winningCount, bonusNumber, lottoNumber) : 보너스 숫자를 맞췄는 확인하는 함수
  - calculateProfit(lottoResult) : 수익률을 계산하는 함수
## View Package
### PrintView Class
- function
  - printStartMessage : 구입 금액을 입력하라고 출력하는 함수
  - printLottoSheetCountMessage : 몇 개를 구매했는지 출력하는 함수
  - printLottoNumber : 자동으로 배정된 로또 한 장을 출력하는 함수
  - printWinningNumberMessage : 당첨 번호를 입력하라고 출력하는 함수
  - printBonusNumberMessage : 보너스 번호를 입력하라고 출력하는 함수
  - printWinningResultMessage : 당첨 통계에 대하여 출력하는 함수
  - printYieldMessage : 수익률을 출력하는 함수
  - getPrizeMoney : 맞힌개수에 맞게 상금을 출력하는 함수
  - getWinningCount : 맞힌개수가 없어서 null이라면 0을 출력하게 바꿔주는 함수

## Controller Package
### LottoController CLASS
- function
  - run : 전체 게임을 조정하는 컨트롤러
  - gameInit : Service 객체들을 게임 시작전에 초기화하는 함수
  - gameCleanUp : 게임이 종료되면 객체 할당 해제를 진행하는 함수
  - preparePurchaseAmount : 구입금액 관련 함수호출
  - preparePurchaseCount : 구입 장수 관련 함수
  - prepareLottoRandomNumber : 랜덤 숫자 생성 관련 함수 호출
  - inputWinningNumber : 당첨번호 관련 함수 호출
  - inputBonusNumber : 보너스번호 관련 함수 호출
  - calculateResult : 당첨 금액, 당첨 개수 등 당첨결과에 대한 함수 호출



이후 추가,삭제,변경되는 내용들이 있다면 업데이트를 하겠습니다.
추가적으로 바뀐 사항을 간략하게 밑에 기록해놓겠습니다.

📌 변경 사항 기록
1. PrintView : Rename Function
2. Lotto : validate : 예외처리기능 2가지 더 추가