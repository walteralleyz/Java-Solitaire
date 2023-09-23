# Java Solitaire

A game of classic Solitaire (aka _Klondike_) made with JavaFX

## Requirements for build

- At least Java (JDK) 11 installed.
- *Any* graphics driver. (will not work on headless machines)

### Quick Start

1. Open this project in your IDE of choice, and run `Main.java` as a normal Java app.
2. Another option, is to open Terminal / CMD, at this project's root directory and execute:
    ```bash
   ./gradlew clean assemble
    ```
3. After step 2, you can find the packaged JAR inside `build/libs/solitaire-fx.jar`. Double-click it to start the game.
4. This packaged JAR can now be shared, and will work on any computer with at least **JRE 11**

### About the game

- Wikipedia article about [Klondike Solitaire](https://en.wikipedia.org/wiki/Klondike_(solitaire))

The first objective is to release and play into position certain cards to build up each foundation, in sequence and in
suit, from the Ace through the King. The ultimate objective is to build the whole pack onto the foundations, and if that
can be done, the Solitaire game is won.

The rank of cards in Solitaire games is: K (high), Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2, A (low).

### Game Rules

* You can get a card per time from the main deck
* Only different colors can be pushed into the under card decks
* A card number need to be minus 1 against the last under deck card
* A card number need to be plus 1 against the last type deck card
* You can move multiples card at once, if they're sequential
