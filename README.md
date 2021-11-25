# 10_CDIO-del3

 # Matador Junior spil - udarbejdet i led med CDIO del 3 opgave.

## Importering af projekt til IntelliJ med git
Som det første skal der oprettes en tom mappe til projektet på computeren.

Når dette er gjort skal kommandoprompten åbnes, dette kan gøres på flere måder:
 - Tryk Windows knap + R og skriv cmd i søgefeltet, tryk derefter OK.
 - I søgefeltet på skrivebordet, søg på kommandoprompt eller cmd og tryk Enter.

Når kommandoprompten er åben, skal der navigeres til den nyoprettede mappes lokation. Fx D:\Programmer\Coding\DTU\CDIO\CDIO-3
Herefter skal projektet klones fra Github. Dette gøres ved at skrive følgende kommando i kommandoprompten:
- git clone https://github.com/Java-theHutt/10_CDIO-del3.git
Tryk derefter på Enter. 
Kommandoprompten vil nu downloade projektet til mappen og projektet vil være importeret.

Åben IntelliJ. Tryk på File og derefter Open. 
Nu skal mappen der blev oprettet findes og åbnes.
Happy coding!


## Sådan spiller man:

Spillet initialiseres ved at først navigere til src/main/java/Game/Main filen, som der dobbeltklikkes på for at åbne i IntelliJ: <br />
![alt text](https://i.imgur.com/n2ei2Lz.png)

Herefter kan spillet køres ved flere forskellige metoder:

- Der kan højre klikkes i koden og klikkes "Run 'Main.main()'
- Der kan klikkes på den grønne "Run" pil oppe i højre hjørne
- Der kan tastes genvejen Shift+F10 på tastaturen for at aktivere Run <br />

![alt text](https://i.imgur.com/0t7z1nw.png)<br />

Derefter burde der fås en pop-up med en GUI for spillebrættet: <br />
![alt text](https://i.imgur.com/NodN4Cd.png) <br />

Samt et terminal pop-up med teksten "Spillet er tilegnet 2-4 spillere. Indtast antal spillere her:" <br />
Brugeren indtaster det ønskede antal spillere og trykker enter, hvorefter konsolen vil prompte hver spiller til at kaste terningerne når det er deres tur. Terningerne kastes ved at taste en vilkårlig tast, og trykke enter.
GUI'en viser hver spillers lokation på boardet.
Spillet fortsætter indtil en spiller per. Monopoly Juniors regler, når 0 kroner, hvorefter spilleren med flest penge vinder.
Vinderen printes i terminal vinduet, hvorefter programmet vil terminere. Man kan herefter bruge Run igen, hvis man ønsker at spille igen.

Spillet kan også til hver en tid termineres på følgende måder, hvis man ikke ønsker at spille længere:

- Trykke på det røde kranie i terminal vinduet med "Stop 'Main'"
- Trykke på den røde firkant oppe i højre hjørne
- Taste genvejen Ctrl+F2 på tastaturen




## Mulige løsninger hvis programmet ikke virker:

Tjek at du runner den rigtige configuration, ved at vælge "Main" i drop-down menuet ved siden af run knappen:<br />
![alt text](https://i.imgur.com/In4ZNa3.png)<br />

Verificer at du kører den nyeste version af softwaren ved at klikke på den skrå blå pil udfor Git, for at opdatere projektet: <br />
![alt text](https://i.imgur.com/ViXf5Wr.png)

Verificer at du er på den korrekte github branch, ved at vælge Main, i popuppet nede i højre hjørne, under event log: <br />
![alt text](https://i.imgur.com/pLjpDKv.png) <br />
