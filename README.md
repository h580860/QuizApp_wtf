# QuizApp_DAT153

## The Name Quiz app
This little app should help us to learn the names of our classmates (or a random selection of cute animal pictures): it maintains a list of names with associated pictures. There are three core activities, which the user should be able to choose from when the application starts:

* the "database": it shows all names & pictures, if necessary, letting the user scroll through the list. There should be buttons for adding a new entry, removing an existing entry, and sorting all existing entries in the database in alphabetical order or reverse order (from A to Z or from Z to A).
* the "quiz": When users click on this activity, the app will randomly select a photo from the database, and shows it on the screen. The app should present the right name for the photo and two wrong names in random order, and the user has to select the one they think is correct. After submission, there should be an indication by the app if the name was correct or not. If not, the app should show the correct name. After that, the whole process repeats until the user decides to leave this activity. The app should keep track of the score (the number of correct answers vs all attempts) and show it on the screen during the quiz.
* the "add entry": Here the user can add a new entry (i.e., a pair of a photo and the associated name) into the database. Please allow the user to choose an existing photo from his/her phone or enable the user to take a photo using his/her camera (Please consider this an optional feature). The name/photo pair should then be available to the "database" and the "quiz". There should also be a shortcut allowing the user to go from the "database" activity to the "add entry".

Other remarks:

* don't immediately try to use one of the fancy databases such as SQLite or Rooms! Use a simple datastructure from the Collections interface to maintain photos & names!
* add 2 or 3 photos and names to the app through the resource folder, and use it to initialize your database when the app starts! That is, load the image data and put it into your datastructure. Find out what's the best way to maintain global in-memory data in an Android app - the database is shared between all activities, after all. (Make sure that the images are not too large, because it will also be in Git -- you can also of course use a cat-pic instead of your real face.)
* do not worry about persistently storing new entries (or the score) on the phone. We will add this functionality in the next oblig, for now it is okay if your app "forgets" everything except for the builtin-photos above when we restart the app.
* Make sure navigating back from an activity works correctly (common mistakes: internal data structure not updating correctly when adding/removing, memory leak when dealing with image files).
* Document your code!
* Please use git "properly", that is, only store the Android Studio project, not generated files like JARs and class-files.
