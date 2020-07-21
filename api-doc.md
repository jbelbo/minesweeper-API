# Minesweeper API Documentation

## Create a Board
To create a new Board you have to send 3 parameters:
* numberOfRows (Integer - required)
* numberOfColumns (Integer - required)
* numberOfMines (Integer - required)
* username (String - optional)

The response will contain the created Board. 

### POST /api/boards
#### Example
Request
```
POST /api/boards
{
    "numberOfRows":2,
    "numberOfColumns":3,
    "numberOfMines":4,
    "username": "Matias"
}
```

Response
```
{
    "id": "514861c1-9894-4656-b3b7-4da3709b06b3",
    "numberOfRows": 2,
    "numberOfColumns": 3,
    "numberOfMines": 4,
    "status": "PLAYING",
    "username": "Matias",
    "createdAt": "2020-07-21T12:31:33.779+00:00",
    "finishedAt": null,
    "cells": [
        {
            "id": "dc64234a-535a-4096-b128-623ebf3135d4",
            "position": {
                "x": 0.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        },
        {
            "id": "f54304d7-53bd-40fe-a07c-ee6cccf17ce1",
            "position": {
                "x": 1.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        },
        {
            "id": "c02d7637-17d0-4a0e-b481-18c643e053d0",
            "position": {
                "x": 2.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        },
        {
            "id": "0ef7fab5-72d1-4c58-af58-40752803cdfe",
            "position": {
                "x": 1.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        },
        {
            "id": "fa892a56-aceb-4a6f-ae59-7181926db67f",
            "position": {
                "x": 0.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 3,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        },
        {
            "id": "998bde4e-16df-46c6-884d-9f6b9c1ea59b",
            "position": {
                "x": 2.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 3,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        }
    ]
}
```


## List Boards
### GET /api/boards

Query string parameters:
* username (String - optional)

#### Example
Request
```
GET /api/boards?username=juan
```

Response
```
[
    {
        "id": "85f62910-2d5d-4550-b1c4-5a575baae00d",
        "numberOfRows": 2,
        "numberOfColumns": 3,
        "numberOfMines": 4,
        "status": "PLAYING",
        "username": "juan",
        "createdAt": "2020-07-21T12:12:24.011+00:00",
        "finishedAt": null,
        "cells": [
            {
                "id": "b302e7dc-826e-4ade-8ba1-a87f0b16ad51",
                "position": {
                    "x": 0.0,
                    "y": 0.0
                },
                "numberOfSurroundingMines": 0,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            },
            {
                "id": "c26c3204-15d5-4153-b45e-f85270cbde20",
                "position": {
                    "x": 2.0,
                    "y": 1.0
                },
                "numberOfSurroundingMines": 0,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            },
            {
                "id": "047b42d6-e075-40b6-a1ee-6682e914a8e1",
                "position": {
                    "x": 2.0,
                    "y": 0.0
                },
                "numberOfSurroundingMines": 0,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            },
            {
                "id": "c4c60d66-f186-4f52-9aae-cf1645eaba28",
                "position": {
                    "x": 0.0,
                    "y": 1.0
                },
                "numberOfSurroundingMines": 0,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            },
            {
                "id": "5748ab15-81dc-4155-bc5d-b628d2322fd1",
                "position": {
                    "x": 1.0,
                    "y": 0.0
                },
                "numberOfSurroundingMines": 4,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            },
            {
                "id": "c7a61d0d-1984-4899-ac7b-91f519a54a89",
                "position": {
                    "x": 1.0,
                    "y": 1.0
                },
                "numberOfSurroundingMines": 4,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            }
        ]
    },
    {
        "id": "3f10b002-0c70-4db3-bd18-bce589b41ed1",
        "numberOfRows": 2,
        "numberOfColumns": 3,
        "numberOfMines": 4,
        "status": "PLAYING",
        "username": "juan",
        "createdAt": "2020-07-21T13:13:34.075+00:00",
        "finishedAt": null,
        "cells": [
            {
                "id": "c2bd52ff-a5eb-48ce-a850-ff5ecfc3c7a0",
                "position": {
                    "x": 1.0,
                    "y": 1.0
                },
                "numberOfSurroundingMines": 0,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            },
            {
                "id": "1bf29918-1665-4452-b2d6-877a981d8ab3",
                "position": {
                    "x": 1.0,
                    "y": 0.0
                },
                "numberOfSurroundingMines": 0,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            },
            {
                "id": "61380f92-ab1e-493a-904e-3cce4b1b8c7e",
                "position": {
                    "x": 2.0,
                    "y": 1.0
                },
                "numberOfSurroundingMines": 0,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            },
            {
                "id": "660e2804-13b7-4cea-b8f3-c299be840449",
                "position": {
                    "x": 0.0,
                    "y": 1.0
                },
                "numberOfSurroundingMines": 0,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            },
            {
                "id": "479385ac-ba6f-45d1-ac24-7b826d9b2fd5",
                "position": {
                    "x": 2.0,
                    "y": 0.0
                },
                "numberOfSurroundingMines": 3,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            },
            {
                "id": "d00979c2-7a12-46ff-a7eb-8cddcf37f64d",
                "position": {
                    "x": 0.0,
                    "y": 0.0
                },
                "numberOfSurroundingMines": 3,
                "hasFlag": false,
                "hasQuestionMark": false,
                "isHidden": true
            }
        ]
    }
]
```



## Get Board by ID
### GET /api/boards/{boardId}
#### Example
Request
```
GET /api/boards/514861c1-9894-4656-b3b7-4da3709b06b3
```

Response
```
{
    "id": "514861c1-9894-4656-b3b7-4da3709b06b3",
    "numberOfRows": 2,
    "numberOfColumns": 3,
    "numberOfMines": 4,
    "status": "PLAYING",
    "username": "Matias",
    "createdAt": "2020-07-21T12:31:33.779+00:00",
    "finishedAt": null,
    "cells": [
        {
            "id": "dc64234a-535a-4096-b128-623ebf3135d4",
            "position": {
                "x": 0.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        },
        {
            "id": "f54304d7-53bd-40fe-a07c-ee6cccf17ce1",
            "position": {
                "x": 1.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        },
        {
            "id": "c02d7637-17d0-4a0e-b481-18c643e053d0",
            "position": {
                "x": 2.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        },
        {
            "id": "0ef7fab5-72d1-4c58-af58-40752803cdfe",
            "position": {
                "x": 1.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        },
        {
            "id": "fa892a56-aceb-4a6f-ae59-7181926db67f",
            "position": {
                "x": 0.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 3,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        },
        {
            "id": "998bde4e-16df-46c6-884d-9f6b9c1ea59b",
            "position": {
                "x": 2.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 3,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": true
        }
    ]
}
```

## Update a cell
To update a cell from a certain board you need to create an
UpdateCellEvent using the following URL: ``/api/boards/{boardId}/cells``

The event object consists of the following properties:
```
{
  "cellId": {cellId},
  "type": {type}
}
```

The available event types are:
* Reveal cell (REVEAL)
* Add a flag to cell (ADD_FLAG)
* Add a question mark to cell (ADD_QUESTION_MARK)

For example, to reveal a cell of id 296ae7ae-14a6-4048-8b0b-f79553a50e0c
you need to send this object in the request body:
```
{
  "cellId": "296ae7ae-14a6-4048-8b0b-f79553a50e0c",
  "type": "REVEAL"
}
```

The response will contain the whole Board with its current status.

### PUT /api/boards/{boardId}/events
#### Example
Request
```
POST /api/boards/514861c1-9894-4656-b3b7-4da3709b06b3/events
{
  "cellId": "dc64234a-535a-4096-b128-623ebf3135d4",
  "type": "ADD_FLAG"
}
```

Response
```
{
    "id": "514861c1-9894-4656-b3b7-4da3709b06b3",
    "numberOfRows": 2,
    "numberOfColumns": 3,
    "numberOfMines": 4,
    "status": "LOST",
    "username": "Matias",
    "createdAt": "2020-07-21T12:31:33.779+00:00",
    "finishedAt": "2020-07-21T13:08:14.113+00:00",
    "cells": [
        {
            "id": "dc64234a-535a-4096-b128-623ebf3135d4",
            "position": {
                "x": 0.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": false
        },
        {
            "id": "f54304d7-53bd-40fe-a07c-ee6cccf17ce1",
            "position": {
                "x": 1.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": false
        },
        {
            "id": "c02d7637-17d0-4a0e-b481-18c643e053d0",
            "position": {
                "x": 2.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": false
        },
        {
            "id": "0ef7fab5-72d1-4c58-af58-40752803cdfe",
            "position": {
                "x": 1.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 0,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": false
        },
        {
            "id": "fa892a56-aceb-4a6f-ae59-7181926db67f",
            "position": {
                "x": 0.0,
                "y": 1.0
            },
            "numberOfSurroundingMines": 3,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": false
        },
        {
            "id": "998bde4e-16df-46c6-884d-9f6b9c1ea59b",
            "position": {
                "x": 2.0,
                "y": 0.0
            },
            "numberOfSurroundingMines": 3,
            "hasFlag": false,
            "hasQuestionMark": false,
            "isHidden": false
        }
    ]
}
```