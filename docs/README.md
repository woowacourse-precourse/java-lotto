# 🚀 기능 구현 목록

---
## **패키지 분리**: [view] & [service]
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현.
- **view**: Input, Output 등의 UI 로직.
- **service**: 핵심 로직(수익률 계산, 로또 번호 비교).

## [view]
- **userIO**: 사용자의 로또 번호를 관리하는 클래스.
  1. moneySpent(): 사용자가 구입 금액을 입력
  2. purchaseLotto(): 구입 금액에 맞는 로또들의 번호를 생성한 뒤 저장
  3. purchaseAmount(): 구입한 로또의 수량
  4. printLotto(): 구입한 로또 번호를 출력
  
- **LottoIO**: 당첨 번호, 최종 결과 출력을 관리하는 클래스.
  1. inputLottoAnswer(): 로또 당첨 번호를 입력
  2. inputBonusAnswer(): 로또 보너스 번호를 입력
  3. checkInvalidNumbers(): 예외처리(null, 길이, 숫자 여부)
  4. checkInvalidBonus(): 예외처리(null, 숫자 여부)
  5. isNotNumericRange(): 입력 값의 숫자 여부를 판단
  6. printResult(): 당첨 최종결과 통계를 출력
  7. printResultFormat(): 형식적인 출력을 따로 관리
  8. printYieldsFormat(): 총 수익률 결과 출력


## [service]
- **MatchLogic**: 번호 비교와 수익률 계산 등 핵심 로직을 수행하는 클래스. 
  1. countMatches(): 로또 번호를 비교하고 1등부터 5등까지의 달성 횟수를 저장
  2. answerMatch(): 한 개의 로또와 정답 로또를 비교하여 몇 개의 번호가 일치하는지 여부를 판단
  3. bonusMatch(): 한 개의 로또와 보너스 로또를 비교하여 포함 여부를 판단
  4. computeYields(): 구입 금액 대비 수익률을 계산
