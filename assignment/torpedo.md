# Torped� parancssoros j�t�k implement�ci�

* A f�l�v sor�n a hallgat�knak �n�ll�an kell lefejleszteni egy Java parancssoros Torped� j�t�kot
    * A Torped� k�tszem�lyes strat�giai t�blaj�t�k, mely 2x2 db n�gyzetar�nyos t�bl�n j�tszhat�
    * A gy�zelemhez ki kell l�ni az ellenf�l �sszes haj�j�t
    * Mindk�t j�t�kos el�tt k�t darab v�zszintesen bet�z�tt, �s f�gg�legesen sz�mozott t�bla van. Az egyiken � jel�li a l�v�seit, a m�sikon a saj�t haj�i vannak, �s az ellenf�l l�v�seit jel�li.
    * A j�t�kosok felv�ltva mondanak egym�snak poz�ci�kat, (pl. A3) �s mindketten kijel�lik a mondott ter�letet.
    * Tal�latnak sz�m�t, ha eltal�lunk egy haj�t, s�llyed�snek, ha minden kock�j�t eltal�ltuk.
    * Ha nem tal�ljuk el a haj�t, azt X-el, ha eltal�ljuk +-al jel�lj�k, az els�llyedt haj�t kisat�rozzuk.
    * A j�t�k akkor �r v�get, ha valamelyik j�t�kosnak az �sszes haj�ja ki van l�ve.
    * Forr�s: [Wikipedia](https://hu.wikipedia.org/wiki/Torped%C3%B3_(j%C3%A1t%C3%A9k))
* Eset�nkben az egyik j�t�kos mi magunk lesz�nk, ellenfel�nk pedig legyen egy lebut�tott robot, aki v�letlenszer� l�p�seket tesz
* A beadand� feladatot k�t �temben kell majd elk�sz�teni �s megv�deni
* A v�d�sek az �ra id�pontj�ban fognak t�rt�nni (7. �s 14. h�ten)
* **Elv�r�sok az els� (7. heti) v�d�sre:**
    * Egy publikus GitHub repository l�trehoz�sa
    * A l�trehozott Git repository tartalmazza a beadand� forr�sk�dj�t
    * A repository tartalmaz egy megfelel� .gitignore f�jlt annak �rdek�be, hogy IDE vagy Maven specifikus ideiglenes f�jlok ne ker�ljenek fel a repository-ba
    * Egy Java 11-es Maven projekt l�trehoz�sa (pom.xml �s Maven folder strukt�ra)
    * A Maven projekt az al�bbi konfigur�ci�kat tartalmazza:
        * Plugin-ek:
            * org.apache.maven.plugins.maven-jar-plugin - annak �rdek�ben, hogy felkonfigur�ljuk az alkalmaz�sunk bel�p�si pontj�t (Main Class)
            * org.apache.maven.plugins.maven-assembly-plugin - annak �rdek�ben, hogy egy f�gg�s�geket tartalmaz�, futtathat� JAR f�jl j�jj�n l�tre az alkalmaz�s build-el�se eredm�nyek�nt
            * org.jacoco.jacoco-maven-plugin - annak �rdek�ben, hogy a meg�rt Egys�g tesztek k�d lefedetts�g�t tudjuk m�rni
            * org.apache.maven.plugins.maven-checkstyle-plugin - annak �rdek�ben, hogy a projekten elk�vetett k�d form�z�si hib�kat �s egy�b rossz praktik�k automatikus detekt�ljunk
        * F�gg�s�gek:
            * JUnit5
            * Mockito
            * Logback
    * Az alkalmaz�s Objektum Orient�lt modellez�s�nek megkezd�se
        * Az alkalmaz�sunkhoz sz�ks�ges VO (Value Object) oszt�lyok l�trehoz�sa (�gyelve �s figyelembe v�ve a "best practice"-eket: Object methods overriding, Immutability, stb)
    * Az alkalmaz�s k�pes kezdetleges felhaszn�l�i interakci�kat fogadni
        * P�ld�ul: J�t�kos nev�nek bek�r�se, J�t�k elind�t�sa, Toreped� j�t�kt�r kiirat�sa, Haj�k lerak�s�nak interakci�ja, stb
        * Itt nem hat�rozunk meg k�telez� elv�r�sokat, tetsz�leges kezdetleges interakci�k elegend�ek
    * Egys�g tesztek 80% lefedetts�get biztos�tanak �zleti logik�t tartalmaz� oszt�lyokra (teh�t p�ld�ul VO oszt�lyokra nem sz�ks�ges Egys�g teszteket �rni)
* **Elv�r�sok a m�sodik (14. heti) v�d�sre:**
    * Spring IoC / DI framework bevezet�se a projektbe
    * A teljes Torped� j�t�k funkcionalit�s lefejleszt�sre ker�lt (lehets�ges egy j�t�kot v�gig j�tszani elej�t�l a v�g�ig)
    * Az alkalmaz�s egy adatb�zisba lementi a j�t�kosok nev�t �s azt, hogy h�nyszor nyertek
        * Az alkalmaz�s k�pes megjelen�teni parancssorban egy high score t�bl�zatot (melyik j�t�kos h�ny meccset nyert)
    * Egy aktu�lisan folyamatban l�v� j�t�k �ll�st az alkalmaz�s k�pes egy XML f�jlba kimenteni �s k�s�bb visszat�lteni (teh�t a j�t�kos onnan folytathatja a j�t�kot, ahol kor�bban abba hagyta)
    * Egys�g tesztek tov�bbra is 80% lefedetts�get biztos�tanak �zleti logik�t tartalmaz� oszt�lyokra
