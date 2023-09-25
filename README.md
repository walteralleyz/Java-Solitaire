# Java Solitaire

A game of classic Solitaire (aka _Klondike_) made with JavaFX

## Requirements

- Java (JDK) 11 or higher.
- *Any* graphics driver.

## Quick Start

1. Open this project in your IDE of choice, and run `Main.java` as a normal Java app.
2. Another option, is to your open Terminal / CMD, go to this project's root directory and execute:
    ```bash
   ./gradlew run
    ```

## Bonus: Building Native Installer (requires Java 15+)

Wouldn't it be awesome if you could just share the game's native OS installer to your users, without having them worry
about setting up Java? The game will be installed natively on their machine, with a shortcut & icon, and they can
uninstall it whenever they want. Well, you can easily achieve that with `jpackage` tool, included in the JDK, **since Java
15**! But it would also require for YOUR Dev machine to have a few extra requirements:

#### Windows

- WiX 3.0 or later, and added to PATH. [Get it here](https://wixtoolset.org/docs/wix3/)

#### MacOS

- Xcode command line tools

#### Linux

- For Red Hat Linux, the `rpm-build` package is required.
- For Ubuntu Linux, the `fakeroot` package is required.

### How to Build Native installer

Simply run this command below in your terminal/CMD, inside this project root directory, and wait for it to complete.
If successful, you will find the installer for your OS inside `./build/native/`. Building for other OS requires that
specific OS. Read more about [jpackage tool](https://docs.oracle.com/en/java/javase/20/docs/specs/man/jpackage.html)

```bash
 ./gradlew clean build jpackage
```

### About the game

- Wikipedia article about [Solitaire](https://en.wikipedia.org/wiki/Klondike_(solitaire))

Works the same as classic desktop Solitaire. The first objective is to release and play into position certain cards to
build up each foundation, in sequence and in suit, from the Ace through the King. The ultimate objective is to build the
whole pack onto the foundations, and if that can be done, the Solitaire game is won. You can move multiples card at
once, if they're sequential.

The rank of cards in Solitaire games is: K (high), Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2, A (low).