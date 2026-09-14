# Mobility Lens

A small Android app that walks through the six things that make mobile apps different from desktop apps. I built it for an Android development course assignment.

The idea is that a developer can look through each dimension one at a time, read what the constraint is and what it means for their own work, and then type in the name of an app or feature they are designing to see it paired with whichever dimension is currently on screen.

The six dimensions covered are:

1. Input and interaction
2. Screen size, orientation, and density
3. Lifecycle and resource constraints
4. Context awareness
5. Usage patterns
6. Security and privacy expectations

Everything sits on one screen. The Previous and Next buttons move between the dimensions.

## Built with

- Kotlin
- Jetpack Compose (no XML layouts)
- Material 3

## Running it

You need Android Studio installed. I used Quail 4 Feature Drop.

1. Clone the repo:
   ```
   git clone https://github.com/jerinjoseph121/mobility-lens-assignment-1.git
   ```
2. Open Android Studio and pick **Open**, then select the project folder.
3. Wait for Gradle to sync. This takes a couple of minutes the first time since it downloads dependencies.
4. Create an emulator in Device Manager if you do not have one already. Any Pixel device on API 26 or higher works.
5. Hit the green Run button.

Minimum SDK is 26 (Android 8.0), so anything below that will not install.

## Note

The app does not save its state when you rotate the screen. The current dimension resets and the text field clears. That is on purpose for this assignment, since part of the work was observing and writing about what happens to state during a configuration change.
