---
docs: controller 기능 구현 목록
## SystemController 기능 구현

- startLotto()
  - 구입금액을 입력받고 구입금액이 타당한지 검사
  - purchaseLotto()의 출력문을 출력하고, 반환 값을 리스트에 저장
  - 당첨 번호를 입력받고, 입력이 타당한지 검사
  - 보너스 번호를 입력받고, 입력이 타당한지 검사
  - statistics()를 출력
- purchaseLotto()
  - 로또 몇 개를 샀는지 출력하고, 그 로또들을 리스트로 반환
- statistics()
  - 당첨금액에 해당하는 로또 리스트들의 개수를 matchScores 라는 리스트에 저장.
  - 저장한 리스트를 출력
  - calculateYield()값 출력
- calculateYield()
  - 구입금액과 당첨금액, 당첨금액의 개수를 통해 수익률을 계산


---
docs: model 기능 구현 목록
## Bonus 기능 구현
매개변수 int bonus를 받음
- validateValue()
  - 1~45까지의 숫자가 아니면 Exception 발생

## Lotto 기능 구현
매개변수 List<Integer> numbers를 받음
- validate()
  - Lotto 리스트의 길이가 6이 아니면 Exception 발생
- NotDuplicate()
  - 중복된 숫자가 있으면 Exception 발생
- validateNumbers()
  - 1~45까지의 숫자가 아니면 Exception 발생

## MatchScore 기능 구현
enum 타입으로 Nothing, Three, Four, Five, FiveAndBonus, Six 값을 받게함
- getScore()
  - enum 타입의 score 값을 반환

## Money 기능 구현
매개변수 String purchase를 받음
- validateMoney()
  - 매개변수 purchase가 1000으로 나누어 떨어지지않으면 Exception 발생
- validateNumber()
  - 1~45까지의 숫자가 아니면 Exception 발생
- howMany()
  - 매개변수 purchase의 1000으로 나눈값을 반환

## ScoreResult 기능 구현
- getScore()
  - 리스트 두개를 비교하여 리스트의 원소가 다른 리스트에 포함되면 count 의 값을 증가
  - 당첨번호와 구매한 리스트의 값을 비교하여 몇 개 당첨되었는지 확인
- getScoreResult()
  - getScore()을 이용하여 당첨된 개수만큼 Enum 타입의 값을 비교하는 List 와 match 시킴
- getScoreFiveAndBonus()
  - 5개를 맞추고, 보너스를 맞추었을때의 경우를 나타냄
  - 아니면 그대로 getScoreResult()

---
docs: util 기능 구현 목록
## CountRandomLotto 기능 구현
- calculate()
  - int 형 변수를 입력받아, WinningNumber 클래스의 RandomLotto()를 int 형 변수 만큼 생성

## WinningNumber 기능 구현
- RandomLotto()
  - 1~45까지의 숫자를 6개 받아 SortRandomLotto() 시키고 반환
- SortRandomLotto()
  - 리스트를 받아 sort 시키고 다른 리스트에 넣어 반환

---
docs: view 기능 구현 목록
## InputView 기능 구현
- startInput()
  - 구입금액 출력문구 출력
  - 구입금액을 입력받고 반환함
- winningNumberInput()
  - 당첨 번호 출력문구 출력
  - Tokenizer 로 쉼표를 구분하여 입력받음
  - Tokenizer 로 입력받은 값을 List<Integer>형으로 변환하고 반환
- BonusNumberInput()
  - 보너스 번호 출력문구 출력
  - 보너스 번호를 입력받고 반환

## OutputView 기능 구현
- startInput_Output()
  - 개를 구매했습니다 출력
- ResultLottoOutput()
  - 당첨통계와 "---" 출력
