// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3244.Watson.subsystems;

import org.usfirst.frc3244.Watson.commands.turnController;
import org.usfirst.frc3244.Watson.Robot;
import org.usfirst.frc3244.Watson.RobotMap;
import org.usfirst.frc3244.Watson.commands.*;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {

	public static double velacityFactor = 1;// RobotMap.RobotDriveTrainSettings.VELOCITY_NORMAL.get();
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon motor_Left_Front = RobotMap.driveTrainMotor_Left_Front;
    private final CANTalon motor_Left_Rear = RobotMap.driveTrainMotor_Left_Rear;
    private final CANTalon motor_Right_Front = RobotMap.driveTrainMotor_Right_Front;
    private final CANTalon motor_Right_Rear = RobotMap.driveTrainMotor_Right_Rear;
    private final RobotDrive robotDrive41 = RobotMap.driveTrainRobotDrive41;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new turnController());
    }
    public void myArcadeDrive(double m, double r) {
		// TODO Auto-generated method stub
		robotDrive41.arcadeDrive(m, r);
		
	}
public void my_Basic_Drive_Mecanum(double x, double y, double r, double gyro){
    	
    	//Slow It down
    	x=x*velacityFactor;
    	y=y*velacityFactor;
    	r=r*velacityFactor;
    	
    	x = Robot.driveTrain.target(x,.1,-1,1);
    	y = Robot.driveTrain.target(y,.1,-1,1);
    	r = Robot.driveTrain.target(r,.1,-1,1);
    	
    	//x = Robot.driveTrain.rampTarget(x,.1,-1,1,.2);
    	//y = Robot.driveTrain.rampTarget(y,.1,-1,1,.2);
    	//r = Robot.driveTrain.rampTarget(r,.1,-1,1,.2);
    	
    robotDrive41.mecanumDrive_Cartesian(x, y, -r, gyro);	
    }

	public double target(double target,double deadband, double min, double max) {
	    if(Math.abs(target)<deadband){
	    	target=0;
	    }
	    	
	    //Check Target less than max
	    if(target>max){
	    	target=max;
	    }
	    	
	    //Check Target Greater Than Min
	    if(target<-max){
	    	target=-max;
	    }
	    	
	    	return target;
	    }
}
