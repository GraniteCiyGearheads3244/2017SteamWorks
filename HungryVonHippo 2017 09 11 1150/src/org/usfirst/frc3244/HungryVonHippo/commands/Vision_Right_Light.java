package org.usfirst.frc3244.HungryVonHippo.commands;

import org.usfirst.frc3244.HungryVonHippo.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Vision_Right_Light extends Command {

    private boolean m_state;

	public Vision_Right_Light(boolean state) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_state = state;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.vision_hardware.My_Right_Light(m_state);;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.vision_hardware.My_Right_Light(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
