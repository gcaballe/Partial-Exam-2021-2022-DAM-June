# Partial Exam 2021-2022 DA (June)
<!-- ------------------------ -->
## Overview
Duration: 2h

We present in this code lab the statement for the live-coding exam to pass course 102386-DAM. The students have two hours to accomplish 5 points by solving the different challenges proposed.

### Rules and constraints
- You are allowed to check the internet and class notes.
- You are not allowed to share information using any media.
- If plagiarism is detected in two or more students, all involved students will fail the test with a 0.
- To deliver the exam, students must present a pull request to the GitHub repository with the following information: *SurnameName*.

![course-logo](assets/logo.svg)

<!-- ------------------------ -->
## Pre-requisits
- Android Studio
- Git and Github

### Roadmap
1. Navigate to the exam public repository.
2. Fork the repository (clicking on the fork button).
3. Clone your fork into your laptop and start working with it.
4. Commit changes after solving each challenge proposed. (In another case, it will penalise you with -0.5 points in your final mark).
5. Push all the commits into your cloud repository.
6. Navigate to your cloud repository and click the button pull request.
7. Compare across forks. The base repo points to my repository and the head to your solution.
8. Add a title and description for the pull request.
9. Create the pull request to finish the test.

### Additional information
- [How to create a pull request](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request-from-a-fork).

<!-- ------------------------ -->
## Correcting bugs (2 points)

*Required*

Software bugs are inconvenient and potentially expensive. The exam repository contains some bugs and errors you need to correct. *This step is required to perform the others. If you cannot fix the issues, you fail the exam*. You can use:
 - Log information (LogCat)
 - Runtime information  (Run)


<!-- ------------------------ -->
## Infinite lives (2 points)

*Easy*

Implement a function that reads an integer from the Shared Memory (key: lives)  and increments its value by one unit when the user clicks the button (id: purchaseLivesBt). This way, the TextView (id:livesTv) must be updated each time the user clicks on the button.

Notes:
- Parameter lives must be inited to 0 value at LauncherActivity.
- Databinding is required.

<!-- ------------------------ -->
## No lives No game (2 points)

*Easy*

Implement a function that disables the gameplay when the user losses all his lifes.

Notes:
- Disabling the buttons is enough; it is NOT required any kind of user notification (Dialogs, Toast,...).

Implement a method that decreases lives by one unit each time the player fails in a level.

Notes:
-  You must save the value in the shared preferences.
-  You must update properly the (id:livesTv).

**Extra (0.5 points)**: Disable the button (mathAdventureButton) either when no more levels are available or when the user losses all their lifes.
<!-- ------------------------ -->
## 3 lives per day (1 points)

*Medium*

Implement a method to ensure that a user starts with three lives in the game each day. It does not matter how many lives it lost the previous day.

**Note**: You can use this function to compare two dates.

```java
public static boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
            && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
            && calendar1.get(Calendar.DAY_OF_MONTH)
                == calendar2.get(Calendar.DAY_OF_MONTH);
    }
```

<!-- ------------------------ -->
## More game more fun (4 points)

*Only do it if you want a 10*

Implement two game modes without duplicating code. You must reuse all the common parts to extend the gameplay. We want to have a math adventure and a string Adventure. To make it simple, this new adventure can provide a word without a letter and the user needs to guess the letter. For example, casa can be **ca_a**, and the user needs to guess the letter **a**.


<!-- ------------------------ -->
## GamePlay modes (1 point)

*Medium*

Implement three different modes (easy, medium and hard). To do it you must generate 3 buttons in game_layout.xml (easyBt, mediumBt, HardBt).
- Easy level: Operations admitted +,-,*,/ and integers numbers between 0,100).
- Medium level: Operations admitted +,-,*,/ and  numbers between 0,100) with two decimals.
- Hard level:  Operations admitted +,-,*,/  and operators can contain suboperations such as (10 + 4) * (4-2) = ? and  numbers between 0,100) with two decimals.
Each mode can

Notes:
- Make it simple, you can reuse all the code and classes. You only need to generate mock levels following this instructions. No more classes are needed to develop this functionallity.
- Use databinding to link the buttons with the different modes.

<!-- ------------------------ -->
## Resetting the game play (0.5 points)

*Easy*

Implement a button in Adventure View that allows the user to reset the sharedPreferences (key=current_level) to 0 value.

