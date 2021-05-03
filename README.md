## Java Solitaire
*A game made with JavaFX*

### Installation
1. `requirements:` At least Java 11 installed.
3. `setup:`
<br/>2.1. **Intellij** -> Open the file in the IDE and execute \*MainApp\* file.
<br/>2.2. **Terminal** -> Inside of project folder, type `./gradlew run`.

### Game Rules
<pre>
This game introduces a deck mechanics (stack of cards), whose you have to manipulate
(I mean, move the cards around) between the seven under decks and the four single type ones.
Once your deck types (every) reach the King card, you win.
</pre>

### Card Rules
* You can get a card per time in the main deck
* Only different colors can be pushed into the under card decks
* A card number need to be minus 1 against the last under deck card
* A card number need to be plus 1 against the last type deck card
* You can move multiples card at once, if they're sequential
