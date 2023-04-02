For this task I apply a simple command line solution which allows to easily interact with the library.

Following the requirements, I developed a method responsible for:

1. Creating a new Game - (by clicking ***'1'***)
2. Updating the Game score - (by clicking ***''2'***')
3. Finishing a chosen game - (by clicking ***''3'***' and then by providing corresponding number visible right next to the game name in brackets)

> [1] Poland 0 - Albania 0

> [2] England 0 - Spain 0

Example: To finish match England vs Spain select ***'2'***

4. Retrieving a summary of all games in progress, (by clicking '4').
5. There is also an exit app functionality - (simply click '5' to exit)
***
Providing any other number outside the range 1-5 will return an information 'Option is not valid. Please try again'.

When trying to provide another format than an integer, the current implementation will cause a throw InputMismatchException.

This can be handled by implementing a custom Exception which inherits from RuntimeException. That will allow to run the application and request a correct input.
