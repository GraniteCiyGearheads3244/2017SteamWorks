package org.usfirst.frc3244.HungryVonHippo.commands;

import org.usfirst.frc3244.HungryVonHippo.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Vision_Right_Light_toggle extends Command {

    private boolean m_state;

	public Vision_Right_Light_toggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_state =!m_state;
    	Robot.vision_hardware.My_Right_Light(m_state);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
