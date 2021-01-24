package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gyroscope;
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
    double shooterLowPower;
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

        // If the user is pressing the left bumper the intake actives at 100% power and the converyor actives at 75% power
        if (gamepad1.left_bumper) {
            intakeMotor.setPower(1);
            conveyorMotor.setPower(.75);
        }
        //If the user lets go of the left bumper the intake and conveyor sets their power to 0%
        else {
            intakeMotor.setPower(0);
            conveyorMotor.setPower(0);
        }

        // If the right trigger is being pressed the shooter activates at 100% power and the conveyour actives at 75% power
        if (gamepad1.right_trigger >= 0.01){
            shooterLeft.setPower(1);
            shooterRight.setPower(-1);
            conveyorMotor.setPower(.75);
        }
        //else if the right bumper is being pressed the shooter actives at 85% power and the conveyour actives at 75% power
        else if(gamepad1.right_bumper){
            shooterLeft.setPower(.85);
            shooterRight.setPower(-.85);
            conveyorMotor.setPower(.75);
        }
        //If neither are being pressed the shooter and conveyour sets the power to 0%
        else{
            shooterLeft.setPower(0);
            shooterRight.setPower(0);
            conveyorMotor.setPower(0);
        }

        telemetry.addData("Status", "Running");
        telemetry.addData("Gamepad 1 Left Trigger: ", gamepad1.left_trigger);
        telemetry.addData("Shooter Left Power: ", shooterLeft.getPower());
        telemetry.addData("Shooter Right Power: ", shooterRight.getPower());
        telemetry.update();
    }
}
}