<h1>LDTS_T14_G03</h1>
<h2>Game Description:</h2>

 
The game is a shooting based game inspired by the games The Binding of Isaac and The Legend of Zelda. As you pass to the next levels, you will encounter a different range of locals with increased difficulty. Every time the player kills someone, it maight received a chance to regenerate it life and at the same time it could received any tipe of power. 

This project was developed by João Alves (up202006281@fe.up.pt), Matias Vaz (up201900194@edu.dc.up.pt) and Miguel Santos (up202008450@fe.up.pt) for LDTS 2022-23. 

### IMPLEMENTED FEATURES

- **Player Moving** - The game character will move to the left when the Left Arrow key is pressed and to the right when the Right Arrow key is pressed. It will move up when Up Arrow key is pressed and will move down when Down Arrow key is pressed; 
- **Monsters Moving** - The enemies of the game move on its own; 
- **Game Screen** - The screen for see the game; 
- **Keyboard control** - The control of the game by the final user; 


### PLANNED FEATURES

- **Monsters Attacks** - The enemies will atack on its own, doing damage on the Player;
- **Player Attacks** - The game character will shoot a bullet when the Space Bar is pressed;
- **Different Levels** - For now, the game only has one level. In the future, we plan to introduce more;
- **PowerUps** – Every time the player kills an enemy there is a chance that the monster drops an Upgrade Item that (if picked up) can regenerate the player’s life or give it a PowerUp;
- **Menu** - A menu to begin the game and have the possibility to go to the screen help;
- **Help** - A screen to help understand how to play the game;


### DESIGN PATTERNS USED

- **GameObject, Bullet, Enemy and Player** - was used the abstract factory method (game object) to create several child classes to have common atributes and methods. 
- **Game** - was used the singleton pattern to create a instance for the entire running game. The reason to choose that was because we only want one instance of game running. 
- **GameScreen, level, menu(planned), help(planned)** - was used the abstract factory method (Game screen) to create several child classes to have common atributes and methods. 
- **KeyboardObserver** - was used the observer pattern to create a class to listen keyboard pressed keys. The reason to choose that pattern was "When an object should be able to notify other objects without making assumptions about who those objects are."

### UML for classes 
**The following uml show the classes diagram**

![LDTSUML drawio](https://user-images.githubusercontent.com/36213075/204034768-e300cf2f-337c-4b68-8c74-8591a5dac1cb.png)

