package Final;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.Shape;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

public class AnimationMain extends Application {


// variables are given names for the shapes in the program
private Shape C1;
private Shape R1;
private Shape L1;

// the counter (X) equal is started at 0
private double counter = 0;
    	
/**
* 
* @param stage 
* javafx application fun using the start method
*/

@Override
public void start(Stage stage)

{
// the height and width is given dimensions for the output screen

int heightofPanel = 300;
int widthofPanel = 400;

// the title of the panel screen is set
stage.setTitle("Final Project - Animation Player ");

// shape array based on shape position
Shape circle = AnimationPlayer.shapes[0];
Shape rectangle = AnimationPlayer.shapes[1];
Shape line = AnimationPlayer.shapes[2];

// private variables are given shape names to use 
C1 = circle;
R1 = rectangle;
L1 = line;


// the opacity of the shapes is set to a value of 0
C1.setOpacity(0);
R1.setOpacity(0);
L1.setOpacity(0);

// a new label is created to show in panel
Label label = new Label();

// a group is made including the label and shapes to use in panel
Group group = new Group(C1,L1,R1, label);

// a new output window is created with the scene having the following parameters
Scene scene = new Scene(group, heightofPanel, widthofPanel);

// object scene is imported to stage
stage.setScene(scene);

// showing stage (objects)
stage.show();

// Create an animation timer, used from frames
AnimationTimer timer = new AnimationTimer() {

// a last run with a long variable type is initiated, can be identified as another counter for handle
private long recentRun = 0;
    
    /**
    * 
    * @param now 
    * animation timer override 
    * 
    */
    
// handle method with parameter here to have most recent run the same at the current time
@Override
public void handle(long here) {
    if (recentRun == 0){
        recentRun = here;
    
    return;
}

// elapsed time is found and converted to seconds, period
double period = (here - recentRun)/1e9;

// elapsed time is added to counter
counter += period;


// the circle frame appearance is displayed
int frameAppearanceC1 = getFrameAppearanceC1(1);
int frameAppearanceC2 = getFrameAppearanceC1(3);

int C1EffectTime1 = getEffectTime(frameAppearanceC1);
int C1EffectTime2 = getEffectTime(frameAppearanceC2);

// the rectangle frame appearance is displayed
int frameAppearanceR1 = getFrameAppearanceR1(1);
int frameAppearanceR2 = getFrameAppearanceR1(3);

int R1EffectTime1 = getEffectTime(frameAppearanceR1);
int R1EffectTime2 = getEffectTime(frameAppearanceR2);

int newX = Integer.parseInt(AnimationPlayer.R1Effect[4]);
int newY = Integer.parseInt(AnimationPlayer.R1Effect[5]);

// the line frame appearance is displayed
int frameAppearanceL1 = getFrameAppearanceL1(1);
int frameAppearanceL2 = getFrameAppearanceL1(3);

int L1EffectTime1 = getEffectTime(frameAppearanceL1);
int L1EffectTime2 = getEffectTime(frameAppearanceL2);
 
 
 // set label to be stated as the counter*speed
 double labelState = counter * AnimationPlayer.speed;
 
 // setText for the string of the label
 label.setText(String.format("Frame: %.0f", (labelState)));
    
    /**
    * look for the present time that is with the assigned time for the effects
    * look for the shapes of circle, rectangle and line 
    */
 
 // Comparing the given time to the current time for effect of each shape
 
 // if statements to manipulate effects 
 
 // if counter is larger than the effect time (1) of the circle, increase opacity
 if (counter > C1EffectTime1) {
 C1.setOpacity(1.0);
 }
 // if counter is larger than the effect time (2) of the circle, decrease opacity
 if (counter > C1EffectTime2) {
 C1.setOpacity(0.0);
 }
 // if counter is larger than the effect time (1) of the rectangle, increase opacity
 if (counter > R1EffectTime1) {
 R1.setOpacity(1.0);
 }
 // if counter is larger than the effect time (2) of the rectangle, decrease opacity
 if (counter > R1EffectTime2) {
 R1.setOpacity(0.0);
 
 // relocating rectangle to allocated parameters
 R1.relocate(newX, newY);
 }
 // if counter is larger than the effect time (1) of the line, increase opacity
 if (counter > L1EffectTime1){
 L1.setOpacity(1.0);
 }
 // if counter is larger than the effect time (2) of the line, decrease opacity
 if (counter > L1EffectTime2){
 L1.setOpacity(0.0);
 }


 // most recent run is equal to here
 recentRun = here;
 start();
 }
 
 };
 // start the timer of the animation to get frames
 timer.start();
 
 }
    
    /**
    * 
    * @param n
    * @return frameAppearance
    * the frame is received when parsed 
    */
 
 // parsing integer value from the circle effects String and returning to get frame
 public int getFrameAppearanceC1(int number){
 int frameAppearance = Integer.parseInt(AnimationPlayer.C1Effect[number]);
 return frameAppearance; 
 }
    
    /**
    * 
    * @param n
    * @return frameAppearance
    * the frame is received when parsed 
    */
 
// parsing integer value from the rectangle effects String and returning to get frame
 public int getFrameAppearanceR1(int number){
 int frameAppearance = Integer.parseInt(AnimationPlayer.R1Effect[number]);
 return frameAppearance; 
 }
    
    /**
    * 
    * @param n
    * @return frameAppearance
    * the frame is received when parsed 
    */
   
 // parsing integer value from the line effects String and returning to get frame
 public int getFrameAppearanceL1(int number){
 int frameAppearance = Integer.parseInt(AnimationPlayer.L1Effect[number]);
 return frameAppearance; 
 }
    
    /**
    * 
    * @param frameAppearance
    * @return effectTime
    * Divide the time that the effect will occur by the speed to determine the time in seconds
    */
    
 // getting EffecTime from dividing time of speed to convert the time into seconds
 public int getEffectTime(int frameAppearance){
 int effectTime = frameAppearance/AnimationPlayer.speed;
 return effectTime;
 }
    
    /** 
    * @param args arguments for the command line 
    */
 
 // main to run the program (reading txt file and running controller) 
 public static void main(String[] args) {
 
 //animationPlayer player = new AnimationPlayer();
 AnimationPlayer.readFile();
 launch(args);
 }
 
 
}
