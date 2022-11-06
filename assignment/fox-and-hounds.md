# Fox and Hounds parancssoros j�t�k implement�ci�

* A f�l�v sor�n a hallgat�knak �n�ll�an kell lefejleszteni egy Java parancssoros Fox-and-Hounds j�t�kot
* Ennek le�r�sa itt olvashat� a Fox and Hounds szekci�ban (angolul):
    https://en.wikipedia.org/wiki/Fox_games
    * A fox-and-hounds k�tszem�lyes strat�giai t�blaj�t�k, mely 1 db n�gyzetar�nyos NxN-es (N p�ros sz�m, 4 <=N<=12), tipikusan 8x8-as t�bl�n j�tszhat�.
    * Az oszlopok sz�moz�sa tipikusan a,b,c, ... bet�kkel t�rt�nik, a sorok� 1,2,3,..,N sorsz�mokkal -- de ett�l nem f�gg a j�t�kprogram.
    * Indul�skor N/2 darab kutya �ll a fels� sor p�ros oszlopindex� mez�iben, �s 1 db r�ka �ll a bal als� sarokban. Ez azt jelenti, hogy azonos sz�n� mez�k�n �llnak, ha sakkp�ly�nak gondoljuk a p�ly�t. 
    * A k�t j�t�kos k�z�l az egyik a r�k�t vezeti, a m�sik a kuty�kat; minden k�rben mindk�t j�t�kos egyet l�p. Egy k�rben a kuty�kat vezet� csak egy kuty�val l�phet. 
    * A l�p�sek sor�n a b�buk egy �tl�s ir�nyban egyet mozdulhatnak el. (1 hossz� fut�l�p�s  sakkban.) Nyilv�n a p�ly�r�l nem lehet lel�pni.
    * A kuty�k c�lja az, hogy beszor�ts�k a r�k�t �gy, hogy ne tudjon l�pni. A r�ka c�lja az, hogy eljusson a fels� sor ak�rmelyik mez�j�re.
    * A j�t�k akkor �r v�get, ha valamelyik j�t�kos el�ri a c�lj�t.
* Eset�nkben az egyik j�t�kos a parancssoron be adja meg a l�p�s�t ( mi a r�k�t vezetj�k), ellenfel�nk pedig legyen egy lebut�tott robot, aki v�letlenszer� l�p�seket tesz a kuty�kkal, ugye, mindig csak eggyel.
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
        * P�ld�ul: J�t�kos nev�nek bek�r�se, J�t�k elind�t�sa, Fox-and_Hounds j�t�kt�r kiirat�sa, Egy l�p�s fogad�sa a parancssoron, a l�p�s vizsg�lata abb�l a szempontb�l, hogy alkalmazhat�-e; a l�p�s alkalmaz�sa �s az eredm�ny ki�r�sa, stb
        * Itt nem hat�rozunk meg k�telez� elv�r�sokat, tetsz�leges kezdetleges interakci�k elegend�ek
    * Egys�g tesztek 80% lefedetts�get biztos�tanak �zleti logik�t tartalmaz� oszt�lyokra (teh�t p�ld�ul VO oszt�lyokra nem sz�ks�ges egys�gteszteket �rni)
* **Elv�r�sok a m�sodik (14. heti) v�d�sre:**
    * A teljes Fox and Hounds j�t�k funkcionalit�s lefejleszt�sre ker�lt (lehets�ges egy j�t�kot v�gig j�tszani elej�t�l a v�g�ig)
    * A projekt a `mvn clean install` parancs futtat�s�ra hiba n�lk�l fordul
	* Spring IoC / DI framework bevezet�se a projektbe
    * Az alkalmaz�s egy adatb�zisba lementi a j�t�kosok nev�t �s azt, hogy h�nyszor nyertek
        * Az alkalmaz�s k�pes megjelen�teni parancssorban egy high score t�bl�zatot (melyik j�t�kos h�ny meccset nyert)
    * Opcion�lis (plusz pont�rt): egy aktu�lisan folyamatban l�v� j�t�k �ll�st az alkalmaz�s k�pes egy XML f�jlba kimenteni �s k�s�bb visszat�lteni (teh�t a j�t�kos onnan folytathatja a j�t�kot, ahol kor�bban abba hagyta)
    * Egys�g tesztek tov�bbra is 80% lefedetts�get biztos�tanak �zleti logik�t tartalmaz� oszt�lyokra
