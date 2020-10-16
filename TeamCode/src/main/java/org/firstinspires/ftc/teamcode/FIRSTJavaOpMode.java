package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;


// Testing Opmode
@TeleOp

public class FIRSTJavaOpMode extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor motorTest;
    private DigitalChannel digitalTouch;
    private Servo servoTest;

@Override
public void runOpMode(){
    imu = hardwareMap.get(Gyroscope.class, "imu");
    motorTest = hardwareMap.get(DcMotor.class, "motorTest");
    digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
    servoTest = hardwareMap.get(Servo.class, "servoTest");

    telemetry.addData("Status", "Initialized");
    telemetry.update();
    // Wait for the game to start or driver presses play
    waitForStart();

    // Keep running till the driver stops
    while(opModeIsActive()){
        telemetry.addData("Status", "Running");
        telemetry.update();
    }
}
}