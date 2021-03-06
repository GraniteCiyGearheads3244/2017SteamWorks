package org.usfirst.frc3244.HungryVonHippo.autonomousroutines;

import org.usfirst.frc3244.HungryVonHippo.commands.CG_FireFuel_WithVision;
import org.usfirst.frc3244.HungryVonHippo.commands.DeliverFuel_ConditionalCommand;
import org.usfirst.frc3244.HungryVonHippo.commands.Drive_For_Distance;
import org.usfirst.frc3244.HungryVonHippo.commands.Drive_Turn_To_Setpoint;
import org.usfirst.frc3244.HungryVonHippo.commands.FlyWheel_Run_ToPot;
import org.usfirst.frc3244.HungryVonHippo.commands.FlyWheel_Run_ToSetPoint;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Blue Alliance Hopper Autonomous Sequence continued from the Place Left Gear
 */
public class Auto_02_2_Peg_Left_Shoot_Boiler extends CommandGroup {

	private static final double ROBOT_TO_BLUE_BOILER_ANGLE = -138.0;
	
    public Auto_02_2_Peg_Left_Shoot_Boiler() {
    	//Run Peg Left routine
    	addSequential(new Auto_02_1_Peg_Left()); //Not set
    	//Spin to Boiler
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_TO_BLUE_BOILER_ANGLE),2);
    	
    	//*********** Added after first Practice match
    	//Forward to Boiler
    	addSequential(new Drive_For_Distance(0.0, 0.3, 0.0, 13),3); //8
    	//*********** Added after first Practice match
    	
    	//Find Target
    	// TO DO
    	//Deliver Fuel for the remainder of the match
    	addSequential(new DeliverFuel_ConditionalCommand(),15);
    	//addSequential(new CG_FireFuel_WithVision(),15);
    	//addSequential(new FlyWheel_Run_ToPot(), 15);
    	// use pot and timer --- after match 2   	addSequential(new FlyWheel_Run_ToSetPoint(83.0),15); //FlyWheel_Run_ToSetPoint.PIN_LEFT_FUEL_POWER = 75
    	//addSequential(new FlyWheel_Run_ToPot(),15);
    }
}
