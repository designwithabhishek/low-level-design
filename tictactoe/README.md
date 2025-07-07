Here's a clean and well-structured `README.md` file for your **Tic Tac Toe Low-Level Design** project:

---

````markdown
# Tic Tac Toe - Low-Level Design (LLD)

This is a low-level design implementation of the classic **Tic Tac Toe** game in Java. The project follows object-oriented principles and modular class separation to model the game mechanics in a clean and scalable manner.

## 🧩 Components

### 1. `Board`
- Represents the game board of dynamic size `N x N`.
- Maintains a 2D matrix of `PlayingPiece`.
- Provides methods to add a piece and display the current state.

### 2. `PlayingPiece`
- Wrapper class for `PieceType` (e.g., `X` or `O`).
- Allows future extensibility (e.g., for a 3-player game or different symbols).

### 3. `PieceType` (Enum)
- Enum defining possible piece types: `CROSS`, `ZERO`, etc.

### 4. `Player`
- Represents a player in the game.
- Has an `id`, `name`, and their assigned `PlayingPiece`.

### 5. `Game`
- Core game controller class.
- Handles player turns, board updates, input handling, and winner detection.
- Supports dynamic board size and multiple rounds.
- Implements logic to detect winning conditions for:
  - Rows
  - Columns
  - Diagonals
- Can detect draw when the board is full with no winner.

---

## ▶️ How to Play

1. Clone the repo:
   ```bash
   git clone https://github.com/yourusername/tictactoe-lld.git
   cd tictactoe-lld
````

2. Compile and run:

   ```bash
   javac Main.java
   java Main
   ```

3. The game prompts each player to enter row and column values for their move.

---

## 📁 Package Structure

```
tictactoe/
├── Board.java
├── Game.java
├── Main.java
├── PieceType.java
├── Player.java
└── PlayingPiece.java
```

---

## ✅ Features

* Clean OOP design
* Dynamic board size (e.g., 3x3, 4x4)
* Alternating turns
* Win detection logic for all directions
* Draw detection when no moves remain

---

## 🚀 Future Enhancements

* Add a UI (Swing or JavaFX)
* Support for AI bot
* Undo/redo feature
* Support for 3+ player variants

---

## 👨‍💻 Author

Developed by Abhishek
Feel free to contribute or suggest improvements!

