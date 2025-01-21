[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.

:white_check_mark: Grandma can attack, specialAttack, support self, and support allies <br />
:white_check_mark: MiddleAgedMan can attack, specialAttack, support self, and support allies <br />
:white_check_mark: Baby can attack, specialAttack, support self, and support allies <br />
:white_check_mark: Death boss class works <br />
:white_check_mark: All classes are unique and the theme is cohesive <br />
:white_check_mark: The game starts with a random number of enemies <br />
:white_check_mark: When an invalid input is entered, the user is properly reprompted <br />
:white_check_mark: Enemies make moves randomly <br />
:white_check_mark: Results are displayed within the border <br />
:white_check_mark: Game ends on quit <br />
:x: Game does not end on either party death <br />
:ballot_box_with_check: Each subclass has a number of possible random names <br />
:beetle: No special output when an adventurer misses or is affected by other status conditions <br />
:beetle: When adventurers die, their latest action remains on screen <br />


## Adventurer Subclasses

### Grandma subclass
 - Initial HP: 15/15
 - Initial SP: 0/4 cookies

| Move Category | Move Description                                                                                                                                                                 |
| :------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Attack        | - Hits opponent with rolling pin <br />- Does 8 damage                                                                                                                           |
| Special       | - Consumes cookies to get a hyper attack <br />- Deals damage equal to SP * 4 <br />- Sets SP to 0                                                                               |
| Support(self) | - Bakes cookies <br />- Heal 4 hp <br />- Gain 1 SP                                                                                                                              |
| Support(ally) | - Tells final words <br />- 75% chance to increase allies damage by 50% for 2 turns <br />- 25% chance to set hp to 0 and make allies take 50% less damage and do 50% more damage permanently |

### Middle Aged Man subclass
- Initial HP: 25/25
- Initial SP: 5/5 coffee

| Move Category | Move Description                                                                                                                                                     |
| :------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Attack        | - Punches opponent <br />- Does 4 damage                                                                                                                             |
| Special       | - Spills hot coffee onto opponent <br />- Deals 8 damage <br />- Removes 1 SP                                            |
| Support(self) | - Drinks coffee <br />- Heal 8 hp <br />- Removes 1 SP                                                                                                               |
| Support(ally) | - Works overtime <br />- Deals 6 damage to self <br />- Allies take 50% less damage for 1 turn                                                                       |

### Baby subclass
- Initial HP: 18/18
- Initial SP: 6/6 spit

| Move Category | Move Description                                                                                                                                                     |
| :------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Attack        | - Bites opponent <br />- Does 6 damage                                                                                                                               |
| Special       | - Spits into opponent's face <br />- Deals 4 damage <br />- The opponent has a 75% chance to miss their attack/special in the next 2 turns <br />- Removes 1 SP      |
| Support(self) | - Crawls to dodge <br />- 80% chance to dodge next attack (does not go away until next attack aimed at baby)                                                         |
| Support(ally) | - Cries <br />- Allies do 50% more damage for 1 turn                                                                                                                 |

### Death subclass
- Initial HP: 60/60
- Initial SP = 3/15

| Move Category | Move Description                                                                                                                                                     |
| :------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Attack        | - Attacks opponent with scythe  <br />- Does a random amount of damage from 6 - 10                                                                                                  |
| Special       | - Calls from his graveyard <br />- Does normal attack and deals 1 extra damage per 3 souls used (consumed from graveyard) <br />                                     |
| Support(self) | - Calls from his graveyard <br />- Heals 10 extra damage per 5 souls used (consumed from graveyard) <br />                                                           |
| Support(ally) | - XXXX <br />- The boss has no friends                                                                                                                               |
