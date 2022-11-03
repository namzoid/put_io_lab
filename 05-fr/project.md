# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC1](#uc1): Ustalenie początkowej ceny produktu
* [UC1](#uc1): Ustalenie czasu do zakończenia aukcji
* [UC2](#uc2): Dostaje powiadomienie o wniesieniu opłaty 
* [UC2](#uc2): Przekazanie danych kupującego do firmy wysyłającej produkt
* [UC2](#uc2): Otrzymanie powiadomienia o dostarczeniu przesyłki

[Kupujący](#ac2):
* [BR1](#br1): Oferuje kwotę większą od początkowej
* [BR1](#br1): Wpisuje swoje dane
* [BR1](#br1): Akceptuje regulamin oraz obowiązek zapłaty przy wygraniu
* [BR1](#br1): Dostaje powiadomienie o przebiciu ceny
* [BR1](#br1): Oferuje wyższą cenę
* [BR2](#br2): Dostaje powiadomienie o wygraniu aukcji
* [BR2](#br2): Wnosi opłatę za produkt
---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2), ...

**Scenariusz główny:**
1. [Kupujący](#ac2) znalazł interesującą go ofertę i wystawia cenę wyższą niż cena początkowa.
2. System weryfikuje że wystawiona kwota jest wyższa niż cena początkowa.
3. [Kupujący](#ac2) wpisuje swoje dane (oraz dane dla dostawy przy wygraniu aukcji).
4. System weryfikuje poprawność wpisanych danych.
5. [Kupujący](#ac2) akceptuje regulamin obowiązku zapłaty przy wygraniu aukcji.
6. System oczekuje na zakończenie aukcji. 
7. System sprawdza bazę z danymi oferty i wybiera największą kwotę wpisaną przez użytkowników.
8. [Kupujący](#ac2) otrzymuje powiadomienie o wygraniu aukcji.
9. [Kupujący](#ac2) opłaca produkt za pomocą karty płatniczej.
10. [Sprzedający](#ac1) dostaje powiadpmienie o wgraniu opłaty.



**Scenariusze alternatywne:** 

1.A. Kwota kupującego została przebita.
* 4.A.1. System informuje użytkownika o przebiciu jego oferty.
* 4.A.2  System daje możliwość wpisania większej kwoty.

---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |


