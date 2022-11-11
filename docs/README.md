# 🚀 기능 목록 (체크리스트)

## 로또 구매

- [X] 구입 금액이 1,000원 단위인지 확인(예외처리 - 올바른 단위가 아님) - Customer.validatePayUnit()
- [X] 중복되지 않은 1~45 범위의 숫자 6개의 번호 생성 - LottoMachine.extractRandomNumbers()
- [X] 번호를 로또 객체로 만들기 - LottoMachine.convertLotto()
- [X] 위 과정을 구입금액/1,000 만큼 생성 - LottoMachine.pickLotteries()
- [X] 몇 개 구매했는지와 로또 번호들을 출력할 문구 만들기 - Customer.toLottoString()

## 당첨 번호 추첨

- [X] 구분자(쉼표) 기준으로 나누기(예외처리 - 쉼표로 구분자를 하지 않음) - LottoDraw.pickWinNumbers()
- [X] 구분자(쉼표)로 나눈 후 번호가 6개인지 확인(예외처리 - 올바른 개수가 아님)
- [X] 6개 번호에 중복이 있는지 확인(예외처리 - 번호에 중복이 있음)
- [X] 각 번호가 1~45 범위의 숫자가 맞는지 확인(예외처리 - 올바른 범위가 아님)
- [X] 로또 번호와 당첨 번호 비교하여 일치하는 번호 개수 확인 - Lotto.compareWinNumbers()
- [x] 위 과정을 가지고 있는 로또 번호만큼 확인 - Customer.matchWinNumbers()

## 보너스 번호 추첨

- [X] 구분자 기준으로 나눠도 번호가 1개인지 확인(예외처리 - 올바른 개수가 아님) - LottoDraw.pickBonusNumber()
- [X] 번호가 1~45 범위의 숫자가 맞는지 확인(예외처리 - 올바른 범위가 아님)
- [X] 로또 번호와 보너스 번호 비교하여 일치하는 번호 확인
- [X] 위 과정을 가지고 있는 로또 번호만큼 확인 - Customer.matchBonusNumber()

## 당첨 결과

- [X] 로또 번호 일치하는 개수를 확인하여 등수 선정 - Customer.createWinnings()
- [ ] 총 당첨금을 계산하기
- [ ] 수익률 계산하기
- [ ] 등수와 수익률을 출력할 문구 만들기

## 기타 및 추가사항

- [X] 입력값이 글자인지 숫자인지 확인하기(예외처리 - 숫자를 입력해주시기 바랍니다) - Customer.validateNumeric()
- [ ] 예외들 인터페이스로 리팩토링 하기
- [ ] 에러 출력하는 테스트 코드 예시 양식으로 리팩토링 하기
- [ ] enum 사용하기
- [X] 당첨 번호와 보너스 번호가 일치한지 확인하기(예외처리 - 당첨 번호와 보너스 번호에 중복된 숫자가 있습니다.) - Customer.validateDuplication()

## 참고사항

### FLOW CHART

![lotto_flowchart](https://user-images.githubusercontent.com/92911823/200890179-f1eb78eb-3577-49cb-ad04-0fd688ae037c.jpg)

### CLASS DIAGRAM

![lotto_class_diagram_3](https://user-images.githubusercontent.com/92911823/201154082-69b73c38-522c-4377-a4fa-7ffd043a0f8f.jpg)
