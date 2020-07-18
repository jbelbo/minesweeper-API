## Minesweeper API 

### Notes
* The API documentation will initially be added as a Markdown file
  instead of using OAS. This decision was made considering that 
  there are only 3 endpoints.

* The Board entity is in charge of executing actions related to the 
  cells, like revealing, flagging and adding question marks. This 
  will allow the Board to detect when the game is over.
  
* The Board services is in charge of processing the events and
  persisting the board after the event is applied.