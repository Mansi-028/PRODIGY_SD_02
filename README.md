# PRODIGY_SD_02 — Guessing Game 🎯

![Status](https://img.shields.io/badge/status-completed-brightgreen)
![Internship](https://img.shields.io/badge/Prodigy%20InfoTech-Task%2002-blueviolet)
![License](https://img.shields.io/badge/license-MIT-blue)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?logo=javascript&logoColor=black)
![Java](https://img.shields.io/badge/Java-007396?logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Java-Swing-orange)

> **Task 02** of my Software Development Internship at **Prodigy InfoTech**.
> Build a program that generates a random number and challenges the user to guess it.

Made with 💙 by **Mansi** — B.Tech Student.

---

## 📌 Problem Statement

Build a program that generates a random number and challenges the user to guess it.
The program should prompt the user for input, compare it to the generated number,
and provide feedback if the guess is **too high** or **too low**. It should keep going
until the user guesses correctly, then display the **number of attempts** it took.

---

## ✨ Features

- 🎲 Random number generated between **1 and 100**
- ⬆️ ⬇️ "Too high" / "Too low" feedback after every guess
- 🔢 Attempt counter that updates live
- 🛡️ Input validation (empty / non-numeric / out-of-range)
- 🔁 Reset / Play Again button
- 🌐 Web version (HTML + CSS + JS) — also shows your guess history as chips
- 🖥️ Java console version
- 🪟 Java Swing GUI version

---

## 📁 Project Structure

```
PRODIGY_SD_02/
├── index.html            # Standalone web app (open in any browser)
├── GuessingGame.java     # Java console version
├── GuessingGameGUI.java  # Java Swing GUI version
└── README.md             # You're reading it :)
```

---

## 🚀 Getting Started

### 🌐 Web Version
Just open `index.html` in any modern browser. That's it — no install, no build.

To host it on **GitHub Pages**:
1. Push the repo to GitHub.
2. Go to **Settings → Pages**.
3. Choose `Branch: main` and `/ (root)`.
4. Your game will be live at `https://<your-username>.github.io/PRODIGY_SD_02/`.

### ☕ Java Console Version
Requires **JDK 8+**.
```bash
javac GuessingGame.java
java GuessingGame
```

### 🪟 Java Swing GUI Version
```bash
javac GuessingGameGUI.java
java GuessingGameGUI
```

---

## 🧠 What I Learned

- Generating random numbers (`Math.random()` / `java.util.Random`)
- Using **loops** to keep the game running until the user wins
- Handling user input safely with `try / catch` and validation
- Updating the DOM in vanilla JS (no frameworks!)
- Building a simple **Swing GUI** with `BorderLayout` + `BoxLayout`
- Keeping the same logic across **3 different implementations** (Web, Console, GUI)

---

## 📸 Preview

The web version uses a dark gradient background with a clean white card,
guess chips colored by hint (🟢 correct / 🟡 too low / 🔴 too high),
and a live attempt counter.

---

## 🙋‍♀️ About Me

Hi! I'm **Mansi**, a B.Tech student interning at **Prodigy InfoTech**
in the Software Development track. This is **Task 02** of 5.

- 🔗 [Task 01 — Temperature Converter](https://github.com/<your-username>/PRODIGY_SD_01)

---

## 📜 License

MIT © Mansi
