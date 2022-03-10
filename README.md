# java-blackjack

블랙잭 미션 저장소

## 블랙잭 미션 목표
- 공통 목표
  - 상속의 필요성을 느끼고 사용해보기
- 야호 목표
  - 주도적으로 스트림을 떠올려서 사용하기
  - 의미없는 getter 를 사용하지 않기
- 판다 목표
  - TDD 잘 지켜서 코드 짜기

## 구현 기능 목록

- [X] 참가자의 이름을 입력받는 기능
```markdown
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason
```

- [X] 딜러와 참가자에게 카드를 2장씩 나눠주는 기능
- [X] 딜러와 참가자 각각의 카드를 보여주는 기능
```markdown
딜러와 pobi, jason에게 2장의 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드
```

- [X] 참가자들이 카드를 더 받을지 입력받는 기능
```markdown
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드
```

- [X] 딜러의 카드 수령 여부를 결정하는 기능
```markdown
딜러는 16이하라 한장의 카드를 더 받았습니다.
```

- [X] 딜러와 참가자 각각의 카드와 결과를 출력하는 기능
```markdown
딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17
```

- [X] 최종 승패를 출력하는 기능
```markdown
## 최종 승패
딜러: 1승 1패
pobi: 승 
jason: 패
```

## 예외 처리 사항
- [X] 이름은 공백일 수 없다.
- [X] 이름에 특수문자가 포함될 수 없다. 
- [X] 참가자의 수는 8명을 초과할 수 없다. 
- [X] 카드 수령 여부는 y 또는 n 으로만 입력해야 한다.
