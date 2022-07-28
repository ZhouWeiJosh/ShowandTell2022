// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  TalonSRX leftdrivemaster = new TalonSRX(3);
  TalonSRX leftdriveslave = new TalonSRX(4);
  TalonSRX rightdrivemaster = new TalonSRX(1);
  TalonSRX rightdriveslave = new TalonSRX(2);

  /** Creates a new Motors. */
  public Drive() {
    leftdriveslave.follow(leftdrivemaster);
    rightdriveslave.follow(rightdrivemaster);
    leftdrivemaster.configFactoryDefault();
    rightdrivemaster.configFactoryDefault();

    leftdrivemaster.setNeutralMode(NeutralMode.Brake);
    rightdrivemaster.setNeutralMode(NeutralMode.Brake);

    leftdrivemaster.setInverted(true);
    leftdriveslave.setInverted(true);
  }

  public void driveJoystick(Joystick joystickLeft, Joystick joystickRight) {
    double leftspeed = joystickLeft.getY();
    double rightspeed = joystickRight.getY();

    leftdrivemaster.set(ControlMode.PercentOutput, leftspeed);
    rightdrivemaster.set(ControlMode.PercentOutput, rightspeed);
  }

     public void speedDriveJoystick(Joystick joystickLeft, Joystick joystickRight) {
       double speed = joystickLeft.getY();
       double rotation = joystickRight.getX();

       leftdrivemaster.set(ControlMode.PercentOutput, speed);
       rightdrivemaster.set(ControlMode.PercentOutput, speed);

        leftdrivemaster.set(ControlMode.PercentOutput, -rotation);
        rightdrivemaster.set(ControlMode.PercentOutput, rotation);
     }

     

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
