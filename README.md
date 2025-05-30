# Втора лабораториска вежба по Софтверско инженерство
## Филип Станковски, бр. на индекс 233111

## Control Flow Graph
![SI_lab2_233111_CFG](https://github.com/user-attachments/assets/fe02773e-e56c-451d-ba0d-c26ba0bc811e)

## Цикломатска комплексност
Цикломатската комплексност на овој код е 11, истата ја добив преку броење на секој затворен регион (closed area) кој се формира во CFG.

## Тест случаи според критериумот Every statement
За Every Statement, минималниот број на тест случаи е: 5 тест случаи


### Тест Случај 1: testNullItemList

Опис: Тестира дали методот фрла исклучок кога allItems е null.
Цел: Покривање на проверката за празна листа.
Влез: allItems = null, cardNumber = "0123456789123456"
Очекувано: RuntimeException со порака "allItems list can't be null!

Покрива statements: A, B

---

### Тест Случај 2: testItemWithNullName

Опис: Проверува дали методот ќе фрли исклучок кога некој артикл има null име.
Цел: Валидација на името на артиклите.
Влез: Item{name=null, quantity=1, price=100, discount=0}, cardNumber = "0123456789123456"
Очекувано: RuntimeException со порака "Invalid item!"

Покрива statements: C, D (true), E  

---

### Тест Случај 3: testInvalidCardCharacter

Опис: Проверува дали методот ќе фрли исклучок ако бројот на картичка содржи недозволен карактер.
Цел: Проверка на валидација на број на картичка.
Влез: Item{name="abc", quantity=3, price=299, discount=0}, cardNumber = "0123456789aaa456"
Очекувано: RuntimeException со порака "Invalid character in card number!"

Покрива statements: C, D (false), F (false), H (false), J, K, L, M (true), N

---

### Тест Случај 4: testNullCardNumber

Опис: Проверка за null број на картичка.
Цел: Покривање на блокот else за невалиден број.
Влез: Item{name="abc", quantity=3, price=299, discount=0}, cardNumber = null
Очекувано: RuntimeException со порака "Invalid card number!"

Покрива statements: C, D (false), F (false), H (false), J, K (false), O

---

### Тест Случај 5: testItemWithDiscountAndPriceAboveThreshold

Опис: Тестира пресметка со попуст и цена над 300.
Цел: Покривање на попуст, одземање -30 и аритметика со попуст.
Влез: Item{name="abc", quantity=3, price=301, discount=0.1}, cardNumber = "0123456789123456"
Очекувано: sum = -30 + (301 * 0.9 * 3) = 813.7
Покрива statements: C, D (false), F (true), G, H (true), I, K, L, M (false)

---

Влезните test cases се земени како пример во тестовите.

## Тест случаи според критериумот Multiple Condition

Подуслови:
A: item.getPrice() > 300
B: item.getDiscount() > 0
C: item.getQuantity() > 10

 8 тест случаи се потребни за целосна покриеност според Multiple Condition критериумот, бидејќи има 2³ = 8 можни комбинации.

| Тест | Цена | Попуст | Количина | Очекувано |
|------|------|--------|----------|-----------|
| TC1  | 100  | 0.0    | 5        | Fail      |
| TC2  | 350  | 0.0    | 5        | Success   |
| TC3  | 100  | 0.2    | 5        | Success   |
| TC4  | 100  | 0.0    | 12       | Success   |
| TC5  | 350  | 0.2    | 5        | Success   |
| TC6  | 350  | 0.0    | 12       | Success   |
| TC7  | 100  | 0.2    | 12       | Success   |
| TC8  | 350  | 0.2    | 12       | Success   |


Објаснување за секој тест
TC1	    Сите услови се false – не се одзема -30 |
TC2	    Само цена > 300 (A=T) |
TC3	    Само попуст > 0 (B=T) |
TC4	    Само количина > 10 (C=T) |
TC5	    A=T, B=T |
TC6	    A=T, C=T |
TC7	    B=T, C=T |
TC8	    Сите се точни |


## Објаснување на напишаните unit tests

Во првата тест целина наречена testInvalidCardCharacter, проверува дали методот checkCart правилно фрла исклучок кога бројот на картичка содржи невалидни карактери. Се користи валиден артикл, но бројот на картичка е "0123456789aaa456", кој содржи букви (a). Методот треба да детектира дека карактерот не е цифра и да фрли RuntimeException со порака "Invalid character in card number!". Со тоа се покрива делот од кодот каде што се врши проверка на секој карактер од картичката (линиите K до N).

Во втората тест целина, именувана test_MultipleCondition, се проверува логичкиот услов кој содржи повеќе подуслови поврзани со вредностите на цената, попустот и количината: if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10). Во тестот се креира производ со име „Laptop“, цена од 400 што е повеќе од 300, попуст од 0.2 што повеќе од 0 и количина од 2 што е помалку од 10. Оваа комбинација ги задоволува првите два подуслови, па се очекува логичкиот услов да се активира и да се одземе -30 од вкупната сума. Конечната пресметка е: цената со попуст е 400 * (1 - 0.2) = 320, за две парчиња тоа е 320 * 2 = 640, и потоа се одземаат 30 денари, така што резултатот е 610. Овој тест служи за покривање на комбинации според Multiple Condition критериумот, и ја верификува исправноста на условот при композитни логички изрази.




