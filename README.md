# quizdroid
Homework requirement:

we want an application that will allow users to take multiple-choice quizzes


Stories:

As a user, when I start the app, I should see a list of different topics on which to take a quiz. (For now, these should be hard-coded to read "Math", "Physics", and "Marvel Super Heroes", as well as any additional topics you feel like adding into the mix.)

As a user, when I select a topic from the list, it should take me to the "topic overview" page, which displays a brief description of this topic, the total number of questions in this topic, and a "Begin" button taking me to the first question.

As a user, when I press the "Begin" button from the topic overview page, it should take me to the first question page, which will consist of a question (TextView), four radio buttons each of which consist of one answer, and a "Submit" button.

As a user, when I am on a question page and I press the "Submit" button, if no radio button is selected, it should do nothing. If a radio button is checked, it should take me to the "answer summary" page. (Ideally, the Submit button should not be visible until a radio button is selected.)

As a user, when I am on the "answer summary" page, it should display the answer I gave, the correct answer, and tell me the total number of correct vs incorrect answers so far ("You have 5 out of 9 correct"), and display a "Next" button taking me to the next question page, or else display a "Finish" button if that is the last question in the topic.
 

Homework Grading:

All your code should be in a GitHub repo under your account
repo should be called 'quizdroid'
repo should contain all necessary build artifacts
include a directory called "screenshots", including:
screenshot of app running on emulator
pic or screenshot or movie of app running on a device
We will clone and build it from the GH repo
5 points, one for each satisfied story
