# 구현할 기능 목록

## 사용자의 구입 금액 입력
- 사용자의 구입 금액을 입력받아서 로또를 몇 개 사는 지 확인 (1000원 당 로또 1개)
- `camp.nextstep.edu.missonutils.Console` 라이브러리에서 `readLine` 함수를 사용
- 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생하고 에러 메시지 출력 후 종료

## 사용자의 로또 번호 생성
- 사용자가 로또를 구매한 개수만큼 랜덤한 숫자 6개의 리스트를 생성
- `camp.nextstep.edu.missonutils.Randoms` 라이브러리에서
  `pickUniqueNumbersInRange` 함수를 사용
- 이 때 로또 번호를 오름차순으로 정렬

## 생성된 사용자의 로또 번호 출력
- 생성된 사용자의 로또 번호를 출력

## 당첨 번호 입력
- 이번 주 당첨 번호, 보너스 번호를 입력
- `camp.nextstep.edu.missonutils.Console` 라이브러리에서 `readLine` 함수를 사용
- 잘못된 값이거나 중복된 값을 입력할 경우 `IllegalArgumentException` 발생하고 에러 메시지 출력 후 종료

## 당첨 번호랑 사용자의 로또 번호들과 비교
- 당첨 번호와 보너스 번호를 랜덤으로 생성된 사용자의 로또 번호들과
    비교해서 사용자의 당첨 유무 확인

## 당첨 통계 출력
- 사용자의 로또 숫자들과 당첨 번호가 3개 이상 일치 하는 경우의 개수를 출력
- 사용자가 로또를 구입한 금액과 당첨 금액을 확인해서 수익률을 계산 및 출력