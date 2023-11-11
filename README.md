![](https://github.com/196Sebastian/jet-biz-card/blob/main/My_JetBiz_Card.png)

# 🌟 Project Description
` Application built using Android Jetpack Compose` 

This application is all about me! With just a click of a button you’re able to see some of my recent projects that I’ve built with a short 
description explaining the purpose of the application. 
Highlighted link sends you to the project's repository, where you get to see some more information about the project with some screenshots of the app 
as well as information about the building processes of the application. 
Let's get connected! 


<img src="https://user-images.githubusercontent.com/87108242/153422512-9394c584-96dd-4fa0-94ec-bafb41369bf0.png" width="600" height="600">

# 👨‍💻 The Building Process
- Application uses Surface Layout.
- Created a card to give the UI more of a business card feel. 
- Used Column and divider throughout the application.
- Added a LazyColumn Layout for our cards.
- Toggle Functionality.




<img src="https://user-images.githubusercontent.com/87108242/153422507-314df6a5-49a7-4c9e-a073-93837c7fba15.png" width="600" height="600">

# 🔧 Problem/Question About The Project
```
val annotatedLinkString: AnnotatedString = buildAnnotatedString {
        val str = "View it on GitHub!"
        val startIndex = str.indexOf("View")
        val endIndex = startIndex + 18
        append(str)
        addStyle(
            style = SpanStyle(
                color = Color(0xff64B5F6),
                fontSize = 11.sp,
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )

        addStringAnnotation(
            tag = "URL",
            annotation = "https://github.com/196Sebastian/nyc-restaurants",
            start = 0,
            end = endIndex
        )
    }
```

- When building the application I knew I wanted to have a link to the project's repository.
- Created a function that did just that but the link was the same for every column.
- I was calling the same function in each column in this case the function was called ClickableLinks().
- Trying to make a list of the URLs using Collection﻿, List﻿Of, and mutableListOf I just kept running in the same problem, 
the link would work but all the card would link the same repository and I didn’t want to have multiple functions linking different URLs. 
- After trial and error my solution was to have multiple functions linking different URLs.
- Would love some feedback into what would be the best approach, thank you.

# 🔔 Contact Me!

  [📝 Portfolio](https://sebastiancorrea.netlify.app/) • [💼 Linkedin](https://www.linkedin.com/in/sebastian-correa-b6858b177/)
  
