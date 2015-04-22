/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author 997robotics4
 */
public class ShootThenDriveAutonomous extends CommandGroup {
    Timer myTimer;
    public ShootThenDriveAutonomous() {
        myTimer = new Timer();
        myTimer.reset();
        myTimer.start();
        
        addSequential(new PrepShooter());
        //addSequential(new WaitForHotGoal(myTimer));
        addSequential(new Shoot());
        addSequential(new DriveToSetpoint(RobotMap.distanceToDriveDuringAutonomous));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
