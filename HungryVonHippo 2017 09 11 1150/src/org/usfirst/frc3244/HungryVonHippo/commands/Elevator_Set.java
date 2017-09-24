// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3244.HungryVonHippo.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3244.HungryVonHippo.Robot;
import org.usfirst.frc3244.HungryVonHippo.util.Utils;

/**
 *
 */
public class Elevator_Set extends Command {

	private boolean m_hold_Command = false;
	private double m_thiscommand = 0.0;
	private double m_lastcommand = 0.0;
	private double m_resolution = 0.01;
	private Timer m_KeepServo = new Timer();
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public Elevator_Set() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elevatorServo);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
   
    // Called just before this Command runs the first time
    protected void initialize() {
    	m_KeepServo.reset();
    	m_KeepServo.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_thiscommand = Robot.elevatorServo.getSetpoint();
    	
    	m_hold_Command = Robot.flyWheel.My_getHold_Elevator();
    	
    	if((Math.abs(m_lastcommand-m_thiscommand) > m_resolution) || m_hold_Command){
    		Robot.elevatorServo.My_Elevator_set(m_thiscommand);
    		m_lastcommand = m_thiscommand;
    		m_KeepServo.reset();
    	}else{
    		if(m_KeepServo.get()>2){
    			Robot.elevatorServo.My_Elevator_Disable();
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}