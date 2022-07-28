// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class driveWithJoystick extends CommandBase {

  private final Drive s_drive;
  private final Joystick joystickLeft;
  private final Joystick joystickRight;
  /** Creates a new driveWithJoystick. */
  public driveWithJoystick(Drive s_drive, Joystick joystickLeft, Joystick joystickRight) {
    this.s_drive = s_drive;
    this.joystickLeft = joystickLeft;
    this.joystickRight = joystickRight;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(s_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_drive.speedDriveJoystick(joystickLeft, joystickRight);
    s_drive.speedDriveJoystick(joystickLeft, joystickRight);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
