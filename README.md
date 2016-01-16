# Tic Tac Toe Game
Written as a Web Service using Play Framework

The solution is an attempt to solve the problem statement

## Problem Statement URL
<http://www.venturesity.com/challenge/id/107>

##Problem Statement
The game of n by n Tic-Tac-Toe

### Create an API

### A. The Game

There is a board game played between two players. The board is an n by n grid where 3<= n <= 8. Each player takes turns in marking spaces on the grid. The first player marks each space with X while the second player marks each space with O. The first player to get k of their marks in a row, column or diagonal where 3<=k<=n wins the game (user defined); otherwise the game is a draw if all squares are filled with no player winning.

#### B. What You Need to Do

Write a bot that can play the game on your behalf. Expose the bot as a webservice. Run the webservice on port 8080. Expose the following three APIs:

| URL   | Type      | Parameter    | Sample Response	Purpose |
| ----- | ------    | -----------  | -------------------------- |
| /ping |	GET	    | {ok:true}	   | To let us know your bot is alive |
| /start | GET p, q | {ok:true}    | For you to initialize the round. p indicates size of the grid and q indicates the number of marks in a row that you need to do to win. |
| /move  | GET      | m {m:"1\|2"}  | m: the last square marked by your opponent. Your response will convey your next play (or any error e.g. spot is filled etc.) |

Note: All positions are represented as x|y where x and y are respective coordinates on the board. The bottom left corner is 1|1.
