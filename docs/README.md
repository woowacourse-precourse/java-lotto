# 🚀 기능 구현 목록

---
## **패키지 분리**: View & Service
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현.
- **view**: Input, Output 등의 UI 로직.
- **service**: 핵심 로직(수익률 계산, 로또 번호 비교).
---
## View
- **UserIO**: 사용자의 로또 번호를 관리하는 클래스.
  1. moneySpent(): 사용자가 구입 금액을 입력 , 예외 처리 상황 - 입력 형식, 1000단위 체크
     1. checkInvalidMoney - 숫자 형식의 입력 값인지 확인(아닐 경우 "[ERROR] 로또 구입 금액은 숫자로 입력해 주세요.")
     2. money % 1000 != 0 - 1000단위로 나누어 떨어지는 수 인지 확인(아닐 경우 "[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.")
  2. purchaseLotto(): 구입 금액에 맞는 로또들의 번호를 생성한 뒤 저장
     1. Randoms.pickUniqueNumbersInRange 라이브러리 함수 이용해 1-45 범위의 서로다른 6개의 숫자 생성
     2. Collections.sort() 함수로 오름차순 정렬
     3. Lotto 객체 생성후 userLotto field 저장
  3. purchaseAmount(): 구입한 로또의 수량
  4. printLotto(): 구입한 로또 번호를 출력
---
- **LottoIO**: 당첨 번호, 최종 결과 출력을 관리하는 클래스.
  1. inputLottoAnswer(): 로또 당첨 번호를 입력, 예외 처리 상황 - 입력 형식(충족하지 않을 경우 "[ERROR] 당첨번호는 쉼표(,)를 기준으로 6개의 서로 다른 숫자를 입력해 주세요.")
     1. null 여부 확인
     2. 6개의 숫자로 이루어진 입력값인지 확인
     3. 중복된 숫자가 있는지 확인
     4. delimiter(,) 가 5개 쓰였는지 확인
     5. 숫자 형식의 입력 값인지 확인
  2. inputBonusAnswer(): 로또 보너스 번호를 입력, 예외 처리 상황 - 입력 형식(충족하지 않을 경우 "[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 1부터 45 사이의 숫자를 한 개만 입력해 주세요.")
     1. null 여부 확인
     2. 한 개의 숫자인지 확인
     3. 숫자 형식의 입력 값인지 확인
     4. inputLottoAnswer 에서의 값들과 중복 여부 확인
  3. checkInvalidNumbers(): 예외처리(null, 길이, 중복, 숫자값, 쉼표 개수)
  4. checkInvalidBonus(): 예외처리(null, 길이, 숫자, 앞선 입력값과 중복 여부)
  5. isNotNumericRange(): 입력 값의 숫자 여부를 판단
  6. printResult(): 당첨 최종결과 통계를 출력
  7. printResultFormat(): 형식적인 출력을 따로 관리
  8. printYieldsFormat(): 총 수익률 결과 출력

---
## Service
- **MatchLogic**: 번호 비교와 수익률 계산 등 핵심 로직을 수행하는 클래스. 
  1. countMatches(): 로또 번호를 비교하고 1등부터 5등까지의 달성 횟수를 저장
     1. Statistics(Enum 클래스) getRank 함수 이용 - 정답 일치 개수와 보너스 번호 일치 여부를 기준으로 등수 반환
     2. setWinner() - Enum 클래스의 인덱스 값으로 등수 저장
  2. answerMatch(): 한 개의 로또와 정답 로또를 비교하여 몇 개의 번호가 일치하는지 여부를 판단
  3. bonusMatch(): 한 개의 로또와 보너스 로또를 비교하여 포함 여부를 판단
  4. computeYields(): 구입 금액 대비 수익률을 계산
     1. 소수점 둘째자리에서 반올림 - (ex.Math.round(result * 10.0) / 10.0)
