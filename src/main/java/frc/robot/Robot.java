// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import io.github.tigerbotics7125.tigerlib.input.controller.XboxController;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    private XboxController mXbox = new XboxController(0);

    private CANSparkMax mLeft1 = new CANSparkMax(0, MotorType.kBrushed);
    private CANSparkMax mLeft2 = new CANSparkMax(1, MotorType.kBrushed);
    private CANSparkMax mRight1 = new CANSparkMax(2, MotorType.kBrushed);
    private CANSparkMax mRight2 = new CANSparkMax(3, MotorType.kBrushed);

    private DifferentialDrive mDrive = new DifferentialDrive(mLeft1, mRight1);

    @Override
    public void robotInit() {
        mLeft2.follow(mLeft1);
        mRight2.follow(mRight1);
    }

    @Override
    public void robotPeriodic() {}

    @Override
    public void autonomousInit() {}

    @Override
    public void autonomousPeriodic() {
        mDrive.arcadeDrive(0, .5, false);
    }

    @Override
    public void teleopInit() {
        mDrive.arcadeDrive(mXbox.leftY().get(), mXbox.rightX().get(), false);
    }

    @Override
    public void teleopPeriodic() {}

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}

    @Override
    public void testInit() {}

    @Override
    public void testPeriodic() {}
}
