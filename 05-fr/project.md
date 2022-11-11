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
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu. ([UC3](#uc3))
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu. ([UC4](#uc4))

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
* [UC3](#uc3): Otrzymanie płatności za produkt
* [UC4](#uc4): Wysyłka produktu

[Kupujący](#ac2):
* [UC2](#uc2): Licytacja produktu
* [UC3](#uc3): Opłata produktu
* [UC4](#uc4): Otrzymanie produktu
* [UC5](#uc5): Wystawienie oceny aukcji/sprzedającemu.

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
### UC2: Licytacja

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) znalazł interesującą go ofertę i wystawia cenę wyższą niż cena początkowa/cena obecna.
2. System weryfikuje że wystawiona kwota jest wyższa niż cena początkowa.
3. [Kupujący](#ac2) wpisuje swoje dane (oraz dane dla dostawy przy wygraniu aukcji).
4. System weryfikuje poprawność wpisanych danych.
5. [Kupujący](#ac2) akceptuje regulamin obowiązku zapłaty przy wygraniu aukcji.
6. System informuje użytkownika o przebiciu jego oferty.
7. System oczekuje na zakończenie aukcji. 
8. System sprawdza bazę z danymi oferty i wybiera największą kwotę wpisaną przez użytkowników.
9. System wysyła powiadomienie [kupującemu](#ac2) o wygraniu aukcji.
10. System informuje [sprzedającego](#ac1) o wygraniu przez użytkownika aukcji.



**Scenariusze alternatywne:** 

2.A. Wystawiona przez użytkownika kwota nie jest wyższa niż cena początkowa/cena obecna.
* 4.A.1. System prosi użytkownika wpisać inną kwotę.
* 4.A.2  System daje możliwość wpisania większej kwoty.
* 4.A.3  Przejdź do kroku 3.

4.A. Podano niekompletne dane.
* 4.A.1. System informuje o niekompletności podanych danych.
* 4.A.2  System daje możliwość wprowadzić wszystkie niepodane dane.
* 4.A.3. Przejdź do kroku 5.

---
<a id="uc3"></a>
### UC3: Opłata produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**

1. [Sprzedający](#ac1) przekazuje dane dla opłaty produktu.
2. System weryfikuje poprawność wpisanych danych.
3. System wysyła powiadomienie [kupującemu](#ac2) o wprowadzeniu przez [sprzedającego](#ac1) danych dla opłaty produktu.
4. System daje możliwość [kupującemu](#ac2) wybrać różne sposoby opłaty.
5. [Kupujący](#ac2) wybiera odpowiednią dla siebie metodę płatności.
6. [Kupujący](#ac2) wpisuje swoje dane do przekazania płatności.
7. System weryfikuje poprawność wpisanych danych.
8. [Kupujący](#ac2) wykonuje opłatę produktu.
9. System otrzymuje potwierdzenie opłaty.
10. [Sprzedający](#ac1) dostaje powiadomienie o wgraniu opłaty.
11. System wysyła powiadomienie [sprzedającemu](#ac1) o otrzymaniu płatności za produkt.

**Scenariusze alternatywne:** 

2.A. Podano niepoprawne lub niekompletne dane dla opłaty produktu.
* 2.A.1. System informuje o błędnie podanych danych.
* 2.A.2. Przejdź do kroku 3.

7.A. Podano niepoprawne lub niekompletne dane dla przekazania płatności.
* 7.A.1. System informuje o błędnie podanych danych.
* 7.A.2. Przejdź do kroku 8.

---
<a id="uc4"></a>
### UC4: Wysyłanie produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**

1. System przekazuje dane kupującego dla dostawy do [sprzedającego](#ac1).
2. [Sprzedający](#ac1) przekazuje dane do firmy organizującej dostawy oraz ustala dzień odbioru paczki przez kuriera.
3. System powiadamia [kupującego](#ac2) o możliwości śledzenia przesyłki poprzez kod wprowadzony przez firmę kurierską.


---

## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

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

Aukcję wygrywa ten z [Kupujących](#ac2), który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt |  
| ------------------------------------------------- | ------ | ------- | 
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | 
| UC2: Licytacja produktu                                              |  C, R, U   |  R, U    |  |
| UC3: Opłata produktu                                              |  D   |   C, R, U   | 
| UC4: Wysyłka produktu                                              |    |  D    | 



