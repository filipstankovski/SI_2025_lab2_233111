# Втора лабораториска вежба по Софтверско инженерство
## Филип Станковски, бр. на индекс 233111

## Control Flow Graph
![SI_lab2_233111_CFG](https://github.com/user-attachments/assets/fe02773e-e56c-451d-ba0d-c26ba0bc811e)

## Цикломатска комплексност
Цикломатската комплексност на овој код е 11, истата ја добив преку броење на секој затворен регион (closed area) кој се формира во CFG.

## Тест случаи според критериумот Every statement
За Every Statement, минималниот број на тест случаи е: 4 тест случаи

Тест Случај 1: allItems == null
Цел: Да се покрие линијата која фрла RuntimeException на самиот почеток.
Влез: allItems = null, cardNumber = "1234567890123456"
Очекувано: RuntimeException со порака "allItems list can't be null!"
Покрива: линиите A, B

Тест Случај 2: Valid item без попуст
Цел: Да се покрие нормалната патека кога се додава цена без попуст.
Влез:
Item{name="Milk", price=100, quantity=2, discount=0.0}
cardNumber = "1234567890123456"
Очекувано: Резултат = 100 * 2 = 200
Покрива: линии C, D (false), F (false), H (false), J, K, L (for), M (false)

Тест Случај 3: Item со цена > 300 и со попуст
Цел: Да се покрие гранката каде се одзема -30 и се пресметува попуст.
Влез:
Item{name="TV", price=400, quantity=1, discount=0.25}
cardNumber = "1234567890123456"
Очекувано:
sum = -30 + 400 * 0.75 = 270
Покрива: F (true), G, H (true), I

Тест Случај 4: Невалиден карактер во картичка
Цел: Да се покрие RuntimeException за недозволен карактер.
Влез:
Item{name="Bread", price=50, quantity=1, discount=0}
cardNumber = "12345678901234AB"
Очекувано: RuntimeException: Invalid character in card number!
Покрива: M (true), N

Влезните test cases се земени како пример во тестовите.

## Тест случаи според критериумот Multiple Condition

Подуслови:
A: item.getPrice() > 300
B: item.getDiscount() > 0
C: item.getQuantity() > 10

 8 тест случаи се потребни за целосна покриеност според Multiple Condition критериумот, бидејќи има 2³ = 8 можни комбинации.

Тест	  Цена	  Попуст	    Количина	Очекувано
TC1	    100	    0.0	        5	        Fail
TC2	    350	    0.0	        5	        Success
TC3	    100	    0.2	        5	        Success
TC4	    100	    0.0	        12	      Success
TC5	    350	    0.2	        5	        Success
TC6	    350	    0.0	        12	      Success
TC7	    100	    0.2	        12	      Success
TC8	    350	    0.2	        12	      Success

Објаснување за секој тест
TC1	    Сите услови се false – не се одзема -30
TC2	    Само цена > 300 (A=T)
TC3	    Само попуст > 0 (B=T)
TC4	    Само количина > 10 (C=T)
TC5	    A=T, B=T
TC6	    A=T, C=T
TC7	    B=T, C=T
TC8	    Сите се точни




