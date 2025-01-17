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


### UML for classes 
**The following UML show the classes diagram**

![LDTSUML drawio](https://user-images.githubusercontent.com/36213075/204034768-e300cf2f-337c-4b68-8c74-8591a5dac1cb.png)


### DESIGN

We are model-view-controller architecture pattern to our code. We could improve the model/view dependency code, since they are sometimes mixed or too much dependents from each other. 

## **Template Method**:
Is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure. We use it on on the pools.

  ### Problem
  We had a simple algorithm and we needed to specialize them all into more specific classes;

  ### Solution
  As we had a base algorithm equal to all moves, we need to specialize for each case. In this way, an enemy moves                     automatically, a bullet is always the same and the Player responds to commands

## **Game Loop Pattern**: 
The pattern that we decided to apply for this was Game Loop, which mainly describes the problem at hand. Game Loop is a pattern that establishes a program in a loop, constantly waiting for input, updating the internal status and then rendering it.

  ### Problem:
  We need to run process without a before specified end.

  ### Solution:
  Apply that pattern to have a infinite loop until certain criteria (the user decide to go out from the game) be changed. 

## **Singleton Pattern:**
As the 'Game' class is the main class of the game, we have to ensure that there is only one object of this class. So we implement this pattern in the 'Game' class, to obtain this guarantee.

  ### Problem
  We want only one instance for that class.

  ### Solution
  We create a  private constructor and used a function to guarentee only one time we will use that constructor if we need to get that object from other classes. 
  

## **Observer Pattern:**
Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing. We use it on Control Class.

  ### Problem:
  We need a class to observer possible command from keyboard whenever they happens and do a action after that event. 

  ### Solution:
  Use the observer pattern to be able to whenever a key is pressed change the game state. 

## Code Smeels

- Alternative Classes with Different Interfaces in Pools because they have similar functions with differents names, doing more difficult to use that classes
- We have some dead code across all the files for planned or change code.
- Game class could be called as Lazy class, since could be merged with console.
- Maybe we could review some message chains, mostly of relation between objects and attributes. 


## Tests code coverage:

### Unit Tests

![image](https://user-images.githubusercontent.com/36213075/209405429-1d272365-23db-4f88-872b-4abbb8d094bd.png)


### Mutation Testing

![image](https://user-images.githubusercontent.com/36213075/209405533-57ff4a9a-ac48-495f-94a6-2ae4b867edf0.png)

## New Features and refactorings after the apresentantion in class

- Power Ups working
- Menu, instructions and game over and game win screens.
- Mutation Testing
- Better separation in Model-View-Controller architeture
- Better Function names
- Some refactor related with pools
- Some refactor related with levels. 


## Self-Evaluation
| Name           | Contribution  |
| -------------  | ------------- |
| João Alves     | 1/3           |
| Matias Vaz     | 1/3           |
| Miguel Santos  | 1/3           |
