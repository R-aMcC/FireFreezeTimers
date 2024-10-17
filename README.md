# Basic FireFreeze timers for f3/m3

Simple firefreeze timers for f3/m3. Displays a message on the screen 5 seconds before you need to click, with a countdown. No customizability right now, but if someone wants me to do this just send me a message on discord and can work on setting up a config file, with a UI if needed.

## Commands
- Toggle  - /firefreeze enable|disable

## Debug commands
### Putting this here, but this ***SHOULD NOT*** be used unless you know what you are doing
(it does reset when you close game so if it breaks just reset it)
### Main command - /fftdebug <option> <value>
Options:
- posx -> float
    - Determines the X offset
- posy -> float
    - Determines the Y offset *(its the opposite of what you would think; - goes up, + goes down)*  
- Scale -> float
  - Determines the scale of the text
  - NOTE: *Increasing scale makes it not center properly *
 - zTranslate -> int
   - Determines how far forwards it is (Makes it display over other ui elements)
   
  ### /fftdebug ttf<time (ms)>
- Sets the `ttFreeze` to a specific number of miliseconds. This is really only used for debugging


### ***MESSAGE ME ON DISCORD FOR ANY PROBLEMS*** 
### (wyannnnn)
