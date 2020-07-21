## Minesweeper API 

### Notes
* You can find the API documentation here: [API DOCUMENTATION](api-doc.md)

* The API documentation will initially be added as a Markdown file
  instead of using OAS. This decision was made considering that 
  there are only 4 endpoints and entites are quite simple.

* The Board entity is in charge of executing actions related to the 
  cells, like revealing, flagging and adding question marks. This 
  will allow the Board to detect when the game is over.
  
* The Board services is in charge of processing the events and
  persisting the board after the event is applied.

* Most parameters validations are missing.

* The only filter implemented for the list of boards is "username".

* The User is just a string saved in the Board entity. Implementing
  an authentication and authorization layer will take me more time 
  and I think is out of the scope of this challenge.


