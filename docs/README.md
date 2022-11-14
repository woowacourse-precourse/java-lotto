# 기능 목록

기능을 Application, UI, Domain으로 분리

---

## UI 계층
1. 구입 금액을 입력받는 메서드 : getInputMoney()
2. 구입한 로또의 번호를 출력하는 메서드 : printLottoNumbers()
3. 당첨 로또 번호를 입력받는 메서드 : getInputWinningNumbers()
4. 보너스 번호를 입력받는 메서드 : getInputBonusNumber()
5. 당첨 통계를 출력하는 메서드 : printWinningStats()

---

## 도메인 계층
1. 구입 금액의 유효성 판단하는 메서드 : validatePriceInput()
2. 당첨 번호의 숫자 범위를 검증하는 메서드 : validateNumberRange()
3. 당첨 번호의 숫자 중복 여부를 검증하는 메서드 : validateOverlapping()
4. 당첨 번호의 유효성을 판단하는 메서드 : validateWinningNumberInput()
5. 문자열 형태의 input을 정수 리스트로 변환하는 메서드 : trimLottoNumberInput()
6. 구매한 로또 개수를 입력받아 Lotto 객체 List 반환하는 메서드 : createRandomLottoNumbers()
7. 수익률 계산하는 메서드 : getYield()
8. 등수에 따른 당첨금 반환하는 메서드 : getReward()
9. 로또 번호 리스트와 당첨 번호로부터 각 등수의 개수를 계산해 반환하는 메서드 - getRankList()

---

## Lotto 클래스
 랜덤으로 생성된 로또 번호 객체를 관리
 - 멤버 변수 : List<Integer> numbers
 - 메서드
1. 객체와 입력받은 정수 리스트에서 일치하는 수의 개수를 반환하는 메서드 : getNumberOfOverlapping()
2. 객체 생성 시 입력의 유효성을 검증하는 메서드 : validate()
3. 객체의 당첨 등수를 반환하는 메서드 : getRank()

## Rank enum
 로또 등수 별 정보를 저장하는 enum
  - reward : 당첨금
  - overlappingNumber : 일치하는 수의 개수
  - bonusBall : 보너스볼 일치 개수