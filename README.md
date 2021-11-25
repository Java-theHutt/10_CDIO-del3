# 10_CDIO-del3

 # Matador Junior spil - udarbejdet i led med CDIO del 3 opgave.

## Importering af projekt til IntelliJ med git
Som det første skal der oprettes en tom mappe til projektet på computeren.

Når dette er gjort skal kommandoprompten åbnes, dette kan gøres på flere måder:
 - Tryk Windows knap + R og skriv cmd i søgefeltet, tryk derefter OK.
 - I søgefeltet på skrivebordet, søg på kommandoprompt eller cmd og tryk Enter.

Når kommandoprompten er åben, skal der navigeres til den nyoprettede mappes lokation. Fx D:\Programmer\Coding\DTU\CDIO\CDIO-3
Herefter skal projektet klones fra Github. Dette gøres ved at skrive følgende kommando i kommandoprompten:
- c:\\...> git clone https://github.com/Java-theHutt/10_CDIO-del3.git

Tryk derefter på Enter. <br /> 
Kommandoprompten vil nu downloade projektet til mappen og projektet vil være importeret.

Åben IntelliJ. Tryk på File og derefter Open. <br />
Nu skal mappen der blev oprettet findes og åbnes.<br />
Happy coding!


## Sådan spiller man:

Spillet initialiseres ved at først navigere til src/main/java/Game/Main filen, som der dobbeltklikkes på for at åbne i IntelliJ: <br />
![alt text](https://i.imgur.com/n2ei2Lz.png)

Herefter kan spillet køres ved flere forskellige metoder:

- Der kan højre klikkes i koden og klikkes "Run 'Main.main()'
- Der kan klikkes på den grønne "Run" pil oppe i højre hjørne
- Der kan tastes genvejen Shift+F10 på tastaturen for at aktivere Run <br />

![alt text](https://i.imgur.com/0t7z1nw.png)<br />

Derefter burde der fås en pop-up med en GUI for spillebrættets startmenu <br />
![image](https://user-images.githubusercontent.com/83249678/143482813-30838257-2d28-4297-a92d-9e91e2dcfe99.png)

Samt et konsolvindue i intelliJ: <br />
![image](https://user-images.githubusercontent.com/83249678/143483228-2de9d52e-af8a-48e3-b582-b25030a7f726.png)

Fra startmenuen har brugeren to muligheder. Enten kan brugen trykke på knappen "Start Spiller" eller knappen "Regler".
![image](https://user-images.githubusercontent.com/83249678/143483801-fb3144d6-1c78-43a1-a204-55040a00696f.png)

Hvis brugeren vælger "Regler" vil brugeren kunne se reglerne. Derefter vender brugeren tilbage til startmenuen ved at trykke "OK", når brugeren har færdiglæst reglerne.

![image](https://user-images.githubusercontent.com/83249678/143484057-50b01d72-e14b-4fc8-af5f-c78eb9ae710c.png)

Når spillet bliver startet bliver brugeren bedt om at angive, hvor mange spillere der skal spille.
![image](https://user-images.githubusercontent.com/83249678/143484307-1a54a0d4-8790-44f1-96ec-4d14f6ebaf1d.png)

Brugeren skal indtaste et tal mellem fra og med 2 til og med 4. Hvis brugeren indtaster noget andet og trykker "OK", vil brugeren blive mødt af det samme vindue.
Når antallet af spillere er angivet korrekt vil spillet hoppe videre til næste bruger input
![image](https://user-images.githubusercontent.com/83249678/143484599-438bbfff-bebe-4114-82f2-49002ed13421.png)

Her skal hver spiller angive sit in-game navn, som vil være at se på spillerens brik og felter spilleren ejer.

Når alle spillere har angivet et spillernavn kommer de videre til følgende vindue
![image](https://user-images.githubusercontent.com/83249678/143485172-7d90e06d-c8fa-4329-a655-0fc07a4a4999.png)

Her kan spillerne se deres brik nede til venstre, samt deres balance og farve.
For at drikke kaffe tryk på knappen "Drik kaffe" eller bare drik din kaffe... 
For at slå medterningerne skal brugeren trykke på "Rul Terninger" knappen.

![image](https://user-images.githubusercontent.com/83249678/143485741-90cfc95c-c86a-4fbc-80f8-2ca64d21d312.png)

Her kan brugeren visuelt se på to terninger, der bliver tilfældigt placeret på brættet, hvad vedkommende har slået, og ved at læse teskten kan man se hvor man er landet.

Herefter kommer brugeren videre ved at trykke "OK", hvorefter brugerens balance på scoreboardet bliver opdateret, samt brugerens købte grundes rammer får brugerens farve (Bil farve).

![image](https://user-images.githubusercontent.com/83249678/143485980-4aab323d-a1a3-4da7-b69b-d0bd920a708b.png)

Yderligere informationer kan ses i konsollen. Det er bl.a. relevant når en spiller lander på "Prøv lykken".
![image](https://user-images.githubusercontent.com/83249678/143486201-456df523-00db-4f6e-8679-9ff263c078ec.png)

Brugeren afslutter sin tur ved at trykke "OK". Herefter går spillet i ring indtil der kun er en spiller tilbage.

Brugeren kan til hver en tid stoppe spillet ved at lukke pop-up vinduet med spillebrættet ved at trykke på X'et øverst i højre hjørne.

![image](https://user-images.githubusercontent.com/83249678/143483566-c5b5a3a6-3a56-42f9-8f80-23e98755fbd5.png)

GUI'en viser hver spillers lokation på boardet.
Spillet fortsætter indtil en spiller per. Monopoly Juniors regler, når 0 kroner, hvorefter spilleren med flest penge vinder.
Vinderen printes i terminal vinduet, hvorefter programmet vil terminere. Man kan herefter bruge Run igen, hvis man ønsker at spille igen.

Spillet kan også til hver en tid termineres på følgende måder, hvis man ikke ønsker at spille længere:

- Trykke på det røde kranie i terminal vinduet med "Stop 'Main'"
- Trykke på den røde firkant oppe i højre hjørne
- Taste genvejen Ctrl+F2 på tastaturen

Brugeren kan til hver en tid stoppe spillet ved at lukke pop-up vinduet med spillebrættet ved at trykke på X'et øverst i højre hjørne.
![image](https://user-images.githubusercontent.com/83249678/143483566-c5b5a3a6-3a56-42f9-8f80-23e98755fbd5.png)



## Mulige løsninger hvis programmet ikke virker:

Tjek at du runner den rigtige configuration, ved at vælge "Main" i drop-down menuet ved siden af run knappen:<br />
![alt text](https://i.imgur.com/In4ZNa3.png)<br />

Verificer at du kører den nyeste version af softwaren ved at klikke på den skrå blå pil udfor Git, for at opdatere projektet: <br />
![alt text](https://i.imgur.com/ViXf5Wr.png)

Verificer at du er på den korrekte github branch, ved at vælge Main, i popuppet nede i højre hjørne, under event log: <br />
![alt text](https://i.imgur.com/pLjpDKv.png) <br />
