## Setup iOS
- Add files from ios/RNViewMask to your project folder
- import RNViewMask-Bridging-Header.h either in project settings or in a header file
- Add masks to your image assets (import from android/src/main/res/drawable-*)

## Usage
```
<JFViewMask maskName="asset"></JFViewMask>
```

## Adding custom masks
Adding a custom mask is really easy, 
- Create a png mask with black and transparent colors

The black part of the mask will be filled with content and the transparent part will remain transparent
- Add the png with a describing name to android drawables and import it to your xcode project image assets

Android: fork the module and add the png to android/src/main/res/drawable-* (add it to this module's android folder, not your app's!)
<br>
iOS: no need to fork, just import your png in xcode project image assets
- Use the mask with `<JFMaskView maskName="nameOfYourMask.png"></JFMaskView>`

## Current available masks
- hexagon_vertical
- fade_top