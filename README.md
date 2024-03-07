# Java Solitaire

A game of classic Solitaire (aka _Klondike_) made with JavaFX

## Requirements

- Java (JDK) 17 or higher.
- *Any* graphics driver.

## Quick Start

1. Open this project in your IDE of choice, and run `Main.java` as a normal Java app.
2. Another option, is to your open Terminal / CMD, go to this project's root directory and execute:
```bash
 ./gradlew run
```

## Bonus: Building Native Installer

You can build a native installer, such as `.msi` for Windows, `.dmg` for MacOS, for JavaFX apps. The installer contains a slim JRE, your app, icons and shortcuts setup. You can _easily_ achieve that with `jpackage` tool, included in the JDK, **since JDK 15**! Learn more about [jpackage tool](https://docs.oracle.com/en/java/javase/20/docs/specs/man/jpackage.html)
You'll need a few extra dependecies: 

#### Windows

- WiX Installer 3.0 or later, and added to PATH. [Get it here](https://wixtoolset.org/docs/wix3/)

#### MacOS

- Xcode 
- Apple Developer tools. Run this in Terminal
 ```bash
 sudo xcode-select install
 ```

### How to Build Native installer (1 command ONLY)

- Simply run this command below in your terminal/CMD, inside this project root directory.
```bash
 ./gradlew clean build jpackage
```

- If done, you'll find the installer for your OS inside foler `build/native/`. Building for other OS requires that target OS. Cannot cross compile. 


### About the game

- Wikipedia article about [Solitaire](https://en.wikipedia.org/wiki/Klondike_(solitaire))

Works the same as classic desktop Solitaire. The first objective is to release and play into position certain cards to
build up each foundation, in sequence and in suit, from the Ace through the King. The ultimate objective is to build the
whole pack onto the foundations, and if that can be done, the Solitaire game is won. You can move multiples card at
once, if they're sequential.

The rank of cards in Solitaire games is: K (high), Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2, A (low).