# World Navigator

World Navigator is a java console game, that is built using OOP, design patterns and SOLID principles,  
This game is made by **Samer Rawashdeh** as a solution for the Atypon's internship World Navigator assignment



## How to Start
The only way to control this game is to enter the intended command index, then press Enter on your keyboard.

The game controls is built using the Command Design pattern, in the game report we will discuss this in details 

The start is easy, you need to run "**Main**" class from "**src**" directory.

```text
*** World Navigator ***
What do you want next?
0 : Start new game
1 : Exit World Navigator
Enter index :
```

This is the main menu, in this case you should enter 0 unless you want to exit the game



```text
invalid input!
```

If you see this, it's because you entered a wrong index or a non-integer character, keep this in your mind if you see it as you play the game



```text
which map do you want?
0 : 3Rooms 1min.ser
1 : 3Rooms 3min.ser
2 : 3Rooms 5min.ser
3 : 5Rooms 3min.ser
4 : 5Rooms 5min.ser
Enter map index : 
```

These are the maps that are available in your "**resources/maps**" directory , every map has a time-limit to go threw the map and win the game, as you can see here, the map designer chose to put the map time-limit in the name of the map file, some map names could not have this info shown, it all depends on what the map designer wants to show

(Proxy pattern is used here, to improve the performance of the game, more details in the game report)



```text
which game mode do you want?
0 : One player with a timer
Enter game mode index : 
```

After choosing  the map, you should choose the game mode that you want to play, for now there is just one game mode

In the future implementing a multiplayer version of this game or even some creative game modes is possible without changing one line in the code 

(we will talk about that in the report with details)



```text
Game controller commands : 
0 : Restart Map
1 : Quit This Map
2 : Go Forward
3 : Go Backward
4 : Turn Left
5 : Turn right
6 : Player status
7 : Look
8 : Check
9 : Open
10 : Hold light from inventory
11 : Drop held light back to inventory
12 : Use Held Light
13 : Switch Room Light
14 : Trade
15 : Use Key
Enter index : 
```

for the first game mode, this is the command list that you as a player will work with

And this is how to start a game, after finishing a game, the main menu will be shown again



## Information About the Game Logic

* To go threw entry ways (doors) the entry way must be **unlocked** and must be **opened**
* To check a chest it must be **unlocked**, no need for it to be opened, the '**Check**' command open the chest and check for loot
* To unlock a chest or a door we use key to do so, not all chests and doors have locks
* To open a chest or door we use the '**Open**' command
* To unlock using a key we use '**Use Key**' command
* Some rooms have room lights, it could be switched on/off using '**Switch Room Light**' command
* To look around the room, there must be a light on around, the player could use room lights or he can use a light from his/her inventory
* To use a light from inventory use '**Hold light from inventory**' command
* Held light will be removed  inventory so the item can't be sold, unless the light is put back using '**Drop held light back to inventory**' command
* To turn the held light on/off use '**Use Held Light**' command