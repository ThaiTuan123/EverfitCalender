# Coding Test

Build out a calendar to manage working training. Should be able to 
1) View the title and status of current week’s workouts.
2) mark them as completed (locally). 

## Product Requirements
TRAINING CALENDAR SCREEN

1. Should show 1 week of day containers, Monday to Sunday
     a. The days of the week should show up on top left of each cell
     b. The days of the month for this current week should show up just below the day of the week
     c. The date for Today should be colored purple (example shown on Sat)  

2. Each day container can hold a number of workouts

3. Each workout container will have:
     a. A workout name, that ends in “...” if the name is too long 
     b. Total number of exercises belong to that workout
     c. Status if the workout is in the past (Missed, Completed), today (Assigned, Completed), or in the future (greyed out)
     d. Color should be different for different states (According to design)
4. When u tap on a non empty cell, it should mark / unmark that cell locally (based on the item ID). If the cell marked, there will be a checkmark appear on the right side of the cell.

5. When the API request is loading, all cells should still have the dates, but empty data.

### Tech Requirements  
1. Use the best architecture that you confident (as clean as possible)
2. API Call requires
3. The data must be cached and loaded next time the app open
Bonus point: Unit test

## UI
calender image


## Build Gradle

```

    //Dimens
    implementation 'com.intuit.sdp:sdp-android:1.1.0'

    //Coroutine
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'

    //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation('com.squareup.retrofit2:converter-gson:2.9.0')
    implementation 'com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2'

    //ViewModel
    implementation 'androidx.lifecycle:lifecycle-viewmodel:2.5.1'

    //LiveData
    implementation 'androidx.lifecycle:lifecycle-livedata:2.5.1'
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"

    //Navigation
    implementation "androidx.navigation:navigation-fragment-ktx:2.5.3"
    implementation "androidx.navigation:navigation-ui-ktx:2.5.3"

    //Koin For AndroidX
    implementation "io.insert-koin:koin-android:3.3.3"

```
