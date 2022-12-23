<h1>LDTS_T14_G03</h1>
<h2>Game Description:</h2>

 
The game is a shooting based game inspired by the games The Binding of Isaac and The Legend of Zelda. As you pass to the next levels, you will encounter a different range of locals with increased difficulty. Every time the player kills someone, it maight received a chance to regenerate it life and at the same time it could received any tipe of power. 

This project was developed by João Alves (up202006281@fe.up.pt), Matias Vaz (up201900194@edu.dc.up.pt) and Miguel Santos (up202008450@fe.up.pt) for LDTS 2022-23. 

### IMPLEMENTED FEATURES

Since the last presentation we have introduced the following features:
- **Menu**;
- **Monsters Attacks**;
- **Player Attacks**;
- **PowerUps**;


- **Menu** - A menu iniciates the application where the user can choose to play from there, or to read the instructions, and lastly to exit the application;

![image](https://user-images.githubusercontent.com/94482929/209367553-95923012-e6fd-4e31-bd00-b130d5788735.png)

![image](https://user-images.githubusercontent.com/94482929/209367596-9df5d88e-6bf6-482f-8887-0e1803272fec.png)

-	**Instructions** - From the menu of the game, the user is able to choose to see the instructions by pressing Enter when the Instructions are displayed blue;

![image](https://user-images.githubusercontent.com/94482929/209367850-7b45262e-cb6e-4cba-bc9e-2469ea6f20bb.png)

- **Player Moving** - The game character will move to the left when the Left Arrow key is pressed and to the right when the Right Arrow key is pressed. It will move up when Up Arrow key is pressed and will move down when Down Arrow key is pressed; 
- **Monsters Moving** - The enemies of the game move on its own; 
- **Game Screen** - The screen for see the game; 
- **Keyboard control** - The control of the game by the final user; 
- **Monsters Attacks** - The enemies will atack on its own, doing damage on the Player;
- **Player Attacks** - The game character will shoot a bullet when the Space Bar is pressed;
- **PowerUps** – Every time the player kills an enemy there is a chance that the monster drops an Upgrade Item that (if picked up) can regenerate the player’s life or give it a PowerUp;
- **Player's Lives Display** - The Player has 2 lives at the beginning of the game, losing one if the Player gets shot by a Monster. Also, the number of lives remaining are displayed on the bottom left corner of the screen;

![image](https://user-images.githubusercontent.com/94482929/209370765-cb4f59f2-bcef-4fe8-b60e-9b47f85ddb09.png)



### PLANNED FEATURES

- **Different Levels** - For now, the game only has one level. In the future, we plan to introduce more;
- **Help** - A screen to help understand how to play the game;


### DESIGN PATTERNS USED

- **GameObject, Bullet, Enemy and Player** - was used the abstract factory method (game object) to create several child classes to have common atributes and methods. 
- **Game** - was used the singleton pattern to create a instance for the entire running game. The reason to choose that was because we only want one instance of game running. 
- **GameScreen, level, menu(planned), help(planned)** - was used the abstract factory method (Game screen) to create several child classes to have common atributes and methods. 
- **KeyboardObserver** - was used the observer pattern to create a class to listen keyboard pressed keys. The reason to choose that pattern was "When an object should be able to notify other objects without making assumptions about who those objects are."

### UML for classes 
**The following UML show the classes diagram**

![LDTSUML drawio](https://user-images.githubusercontent.com/36213075/204034768-e300cf2f-337c-4b68-8c74-8591a5dac1cb.png)


### DESIGN

THE GAME SHOULD WAIT FOR INPUT BY THE USER AND ONLY STOP WHEN A THE ENEMIES KILL THE PLAYER OR WHEN THE PLAY KILL ALL THE ENEMIES

- **Template Method**:
Is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.


- **GAME LOOP Pattern**: 
The pattern that we decided to apply for this was Game Loop, which mainly describes the problem at hand. Game Loop is a pattern that establishes a program in a loop, constantly waiting for input, updating the internal status and then rendering it.


- **Singleton Pattern:**
As the 'Game' class is the main class of the game, we have to ensure that there is only one object of this class. So we implement this pattern in the 'Game' class, to obtain this guarantee.


- **Observer Pattern:**
Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

