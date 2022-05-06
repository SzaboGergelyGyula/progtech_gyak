# Rendszertev

## A rendszer célja

A rendszerünk egy egyszerű folyamatleíró resndszer, amelyben különböző számítógépeket tudunk előállítani.

## Projektterv

Ketten dolgozunk a rendszeren:
- Krigovszki Bálint
- Sazbó Gergely Gyula

## Üzleti folyamatok modellje

A felhasználó bejelentkezés után be tudja vinni az adatokat, melyek alapján a rendszerünk különböző számítógépeket készít. Továbbá visszajelzést kap a felhasználó, hogy milyen gépeket készített már el korábban a rendszer.

## Követelmények

- be és kijelentkezés megvalósítása
- erőforrás beállításának lehetősége
- készítés indítása
- elkészült eszközök megjelenítése (listában)

## Funkcionális terv

![login](loginWindow.jpg)


![window](mainWindow.jpg)


## Fizikai környezet

Az alakalmazást Java-ban fejlesztjük, adatbázishoz mysql lesz használva.

## Adatbázis terv

2 táblát veszünk igénybe:
- users: a belépés adatait tároljuk itt
- computers: az elkészített eszközök listája

## Implementációs terv

Két tervezési mintát fogunk használni az alkalmazás fejlesztéséhez:
- Abstract Factory
- Decorator

