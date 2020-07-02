# Programozási technológiák beadandó

## Készítette: Szegedi József A13BQ7

## Dátum: 2020. 06. 30.

## Bevezetés

Beadandóm célja egy raktár manager program tervezése, amelyben különböző tervezési alapelveket, mintákat és technológiákat próbáltam megvalósítani. Például stratégia mintát használtam a külföldi és belföldi beszállítók által behozott áruk árának vám alapján való kiszámítására, különböző listák bejárását az iterátor mintával oldottam meg, obszerver mintát használtam a rendelések státuszának változásáról értesítő üzenetek szétküldéséhez, és a raktárak menedzselésére létrehozott osztályt a singleton minta használatával hoztam létre. Ahhoz, hogy a tiszta kód eszményét szem előtt tudjam tartani, egy jól bevált módszert választottam, ami a tesztvezérelt programozás. Munkám során igyekeztem végig betartani az OOP alapelveket. 

## UML diagram

![UML digram](https://github.com/A13BQ7/progtech_beadando/blob/master/resources/warehouse.png)

## Tesztvezérelt fejlesztés

Tudjuk, hogy a sikertelen egységteszt jelzése minden keretrendben piros, a sikeresé zöld. Ha minden egységtesztünk zölddé válik, akkor mondhatjuk el, hogy minden tesztünk lefutott. Azért fontos a tesztvezérelt programozás betartása, mert így sokkal kevesebb időt kell hibakereséssel, nyomkövetéssel tölteni, és a tesztek a kód nagy részét lefedik, így a program magas minőségében biztosak lehetünk. A TDD bátorságot, hogy hozzányúljunk a kódhoz.

![Tesztvezérelt programozás](https://github.com/A13BQ7/progtech_beadando/blob/master/resources/tdd.png)

## Tervezési minták

A tervezési minták gyakori programozói feladatokat oldanak meg. A minták alkalmazásával könnyen bővíthető, módosítható osztályszerkezetet kapunk, tehát rugalmas kódot.  
Következőkben a feladatban használt tervezési mintákat fogom bemutatni.

### Stratégia minta

A stratégia egy viselkedési tervezési minta, amely mindig egy, és mindig csak egy változékony metódust emel ki egy osztályhierarchiába, és amely felelősség átadással hívja meg a kiemelt metódust.

![Stratégia minta](https://github.com/A13BQ7/progtech_beadando/blob/master/resources/strategy.png)

### Iterator minta

Olyan viselkedési tervezési minta, amely egy adatszerkezet bejárását támogatja.

![Iterátor minta](https://github.com/A13BQ7/progtech_beadando/blob/master/resources/iterator.png)

### Singleton minta

Akkor használjuk, ha egy osztályt úgy kell megírnunk, hogy csak egy pédány lehet belőle. Egy osztályból példányt a konstruktorával készíthetünk, ha a konstruktor publikus, akkor akárhány pédány készíthető. Tehát publikus konstruktora nem lehet a singletonnak, a megoldást az osztályszintű metódusok jelentik, mert ezeket akkor is lehet hívni, ha nincs példány.

A raktárak kezelésére szolgáló osztályból csak egyre van szükség minden esetben, mert akárhány raktár van, egy közös osztályból kell kezelni őket. 

![Singleton minta](https://github.com/A13BQ7/progtech_beadando/blob/master/resources/singleton.png)

### Observer minta

Olyan viselkedési tervezési minta, amely egy esemény által kiváltott változékony metódust emel ki egy egy-sok kapcsolat sok oldalára, és amely műsorszórással hívja meg a kiemelt metódusokat. A műsorszórás (broadcast) egy olyan programozási módszer, amikor egy metódus sok más, előre nem ismert, metódust hív meg egy lista alapján. Ez a tervezési minta lehetővé teszi, hogy egy objektum megváltozása esetén értesíteni tudjon más objektumokat anélkül, hogy bármit is tudna róluk.

![Observer minta](https://github.com/A13BQ7/progtech_beadando/blob/master/resources/observer.png)
