package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
//import edu.wpi.first.wpilibj.templates.subsystems.Aimer;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.templates.subsystems.Gatherer;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;
import edu.wpi.first.wpilibj.templates.subsystems.subcompressor;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Gatherer subGatherer = new Gatherer(
            RobotMap.GathererWheelslot,
            RobotMap.GathererExtendSlot,
            RobotMap.GathererRetractSlot);
    public static DriveTrain subDriveTrain = new DriveTrain(
            RobotMap.leftEncoderSlot1,
            RobotMap.leftEncoderSlot2,
            RobotMap.rightEncoderSlot1,
            RobotMap.rightEncoderSlot2,
            RobotMap.LeftDriveslot,
            RobotMap.RightDriveslot,
            RobotMap.DriveGyroSlot);
    public static Shooter subShooter = new Shooter(
            RobotMap.Winchslot,
            RobotMap.ShooterEncoderslot,
            RobotMap.ShooterEncoderslot2,
            RobotMap.LimitSwitchslot,
            RobotMap.LimitSwitchslot2,         
            RobotMap.LatchPunematicslot);
  //  public static Aimer myAimer = new Aimer();
    public static subcompressor subCompressor = new subcompressor(
            RobotMap.compressorSwitchSlot,
            RobotMap.compressorSpikeSlot);

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
