/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
   public boolean isYToggled = false;

   public XboxController main = new XboxController(RobotMap.Controller.MAIN);
   /*
    * RobotMap.Controller.MAIN is the ID of the controller, you can check this
    * using Driver Station
    */

   public void updateY() {
      if (main.getYButtonPressed())
         isYToggled = !isYToggled;
   }

   public boolean getYToggle() {
      return isYToggled;
   }

   public double getDriveValue() {
      return -(main.getTriggerAxis(Hand.kRight) - main.getTriggerAxis(Hand.kLeft));
   }

   public double getTurnValue() {
      return main.getX(Hand.kLeft);
   }

   public void log(){
      SmartDashboard.putBoolean("isYToggled (Quick Turn Mode)", isYToggled);
   }
}
