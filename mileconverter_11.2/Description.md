# **Mile Converter Lab**
This lab consists of the [MileConverter](src/MileConverter.java) class, and its intended function is to get a number of miles from the user, and display three different converted values: Kilometers, meters, and feet. The purpose of this lab is to show us how to get filtered inputs from a user.

# **Challenges**
As with my 10.1 lab, JFrame is still new to me. I tried using the Number class like was shown in the lecture, but it refused to accept inputs less than 1, and I went back to using the Scanner like in 10.1, admittedly defeating the purpose of JFormattedTextField's sanitization, as the scanner was set to use the next double. There was also quite a few scaling oddities like last time; I commented out the pack() because the labels would abbreviate when the results stretched too far.
