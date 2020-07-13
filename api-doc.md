# Minesweeper API Documentation

## Create a Board
To create a new Board you have to send 3 required parameters:
* numberOfRows
* numberOfColumns
* numberOfMines

The response will contain the created Board. 

### POST /api/boards
#### Example
Request
```
POST /api/boards
{
    "numberOfRows":2,
    "numberOfColumns":3,
    "numberOfMines":4
}
```

Response
```
{
    "id": "14cb66af-b835-41da-b726-b821b401dcca",
    "numberOfRows": 2,
    "numberOfColumns": 3,
    "numberOfMines": 4,
    "createdAt": "2020-07-13T12:37:29.563+00:00",
    "finishedAt": null,
    "cells": [
        {
            "id": "0a5b1e96-3b4c-47ea-adf3-d982b653d436",
            "position": {
                "x": 1.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 0,
            "hasMine": true,
            "hasFlag": false,
            "hasQuestionMark": false,
            "idHidden": true
        },
        {
            "id": "7b0b5d7d-a3f2-4225-9382-14f36d1dda79",
            "position": {
                "x": 1.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 0,
            "hasMine": true,
            "hasFlag": false,
            "hasQuestionMark": false,
            "idHidden": true
        },
        {
            "id": "1c16e638-e710-4924-8f89-35bf16684d54",
            "position": {
                "x": 2.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 0,
            "hasMine": true,
            "hasFlag": false,
            "hasQuestionMark": false,
            "idHidden": true
        },
        {
            "id": "3fc0692a-d583-4fda-ad0b-8a6a5290e1a0",
            "position": {
                "x": 2.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 0,
            "hasMine": true,
            "hasFlag": false,
            "hasQuestionMark": false,
            "idHidden": true
        },
        {
            "id": "7fd9baaa-65dc-4a0e-a8b8-2139bebb30f2",
            "position": {
                "x": 0.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 2,
            "hasMine": false,
            "hasFlag": false,
            "hasQuestionMark": false,
            "idHidden": true
        },
        {
            "id": "7d53e9c7-e421-4a8d-ae20-e981c4ae94fd",
            "position": {
                "x": 0.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 2,
            "hasMine": false,
            "hasFlag": false,
            "hasQuestionMark": false,
            "idHidden": true
        }
    ]
}
```

## Get Board by ID
### GET /api/boards/{boardId}
#### Example
Request
```
GET /api/boards/40f1c0df-1608-473c-b25a-6098730bedca
```

Response
```
{
  "id":"40f1c0df-1608-473c-b25a-6098730bedca",
  "numberOfRows": 4,
  "numberOfColumns": 4,
  "numberOfMines": 6,
  "cells": [
      {...},{...},{...}
  ]
}
```

## Update a cell
To update a cell from a certain board you need to use the
sub-resource URL: ``/api/boards/{boardId}/cells``

The available operations are:
* Reveal cell
* Add a flag to cell
* Add a question mark to cell

You need to send the whole cell object in the request body
and edit the field you wish to change.


To reveal a cell you need change ``isHidden: true``  
to ``isHidden: false``. The same works for adding a flag, 
or a question mark. For those cases, update the ``hasFlag`` 
or ``hasQuestionMark`` fields respectively.

The response will contain the whole Board with its current status.

### PUT /api/boards/{boardId}/cells/{cellId}
#### Example
Request
```
PUT /api/boards/40f1c0df-1608-473c-b25a-6098730bedca/cells/296ae7ae-14a6-4048-8b0b-f79553a50e0c
{
    "id": "296ae7ae-14a6-4048-8b0b-f79553a50e0c",
    "position": {
        "x": 0.0,
        "y": 0.0
    },
    "numberOfSurroundingMines": 2,
    "hasMine": false,
    "hasFlag": false,
    "hasQuestionMark": false,
    "idHidden": false
}
```

Response
```
{
    "id": "40f1c0df-1608-473c-b25a-6098730bedca",
    "numberOfRows": 2,
    "numberOfColumns": 3,
    "numberOfMines": 4,
    "createdAt": "2020-07-13T12:37:29.563+00:00",
    "finishedAt": null,
    "cells": [
        {...},{...},{...}
    ]
}
```