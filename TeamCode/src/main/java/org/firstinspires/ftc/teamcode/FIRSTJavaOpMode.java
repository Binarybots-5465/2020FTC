package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor shooterLeft;
    private DcMotor shooterRight;
    private DcMotor conveyorMotor;
    private DcMotor intakeMotor;
    private DigitalChannel digitalTouch;
    private Servo servoTest;

@Override
public void runOpMode(){
    imu = hardwareMap.get(Gyroscope.class, "imu");
    // Front left is located on port 0
    frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
    //Front Right is located on port 1
    frontRight = hardwareMap.get(DcMotor.class, "frontRight");
    // Back Left is located on port 2
    backLeft = hardwareMap.get(DcMotor.class, "backLeft");
    // Back Right is located on port 3
    backRight = hardwareMap.get(DcMotor.class, "backRight");

    shooterLeft = hardwareMap.get(DcMotor.class, "shooterLeft");

    shooterRight = hardwareMap.get(DcMotor.class, "shooterRight");

    conveyorMotor = hardwareMap.get(DcMotor.class, "conveyorMotor");

    intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

    frontLeft.setDirection(DcMotor.Direction.FORWARD);
    frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    frontRight.setDirection(DcMotor.Direction.REVERSE);
    frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    backLeft.setDirection(DcMotor.Direction.FORWARD);
    backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    backRight.setDirection(DcMotor.Direction.REVERSE);
    backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    shooterLeft.setDirection(DcMotor.Direction.FORWARD);
    shooterLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    shooterRight.setDirection(DcMotor.Direction.FORWARD);
    shooterRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    conveyorMotor.setDirection(DcMotor.Direction.REVERSE);
    conveyorMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    intakeMotor.setDirection(DcMotor.Direction.REVERSE);
    intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    double leftPower;
    double rightPower;
    boolean shooterOn;
    double shooterPower;
    double conveyorPower;
    double intakePower;

    telemetry.addData("Status", "Initialized");
    telemetry.update();
    // Wait for the game to start or driver presses play
    waitForStart();

    // Keep running till the driver stops
    while(opModeIsActive()){
        leftPower = gamepad1.left_stick_y;
        frontLeft.setPower(leftPower);
        backLeft.setPower(leftPower);
        telemetry.addData("Left Stick: ",String.valueOf(leftPower));

        rightPower = gamepad1.right_stick_y;
        frontRight.setPower(rightPower);
        backRight.setPower(rightPower);
        telemetry.addData("Right Stick: ",String.valueOf(rightPower));

        shooterPower = gamepad1.left_trigger;
        shooterLeft.setPower(10 * shooterPower);
        shooterRight.setPower(-10 * shooterPower);

        conveyorPower = gamepad1.right_trigger;
        conveyorMotor.setPower(conveyorPower);

        intakePower = gamepad1.right_trigger;
        intakeMotor.setPower(intakePower);

        telemetry.addData("Status", "Running");
        telemetry.update();
    }
}
}