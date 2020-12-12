package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="AutonomusOpMode", group = "OpMode")
class AutonomusOpMode extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor shooterLeft;
    private DcMotor shooterRight;
    private DcMotor conveyorMotor;
    private DcMotor intakeMotor;

    @Override
    public void runOpMode() throws InterruptedException {
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

        waitForStart();

        frontLeft.setPower(1);
        frontRight.setPower(1);
        backLeft.setPower(1);
        backRight.setPower(1);

        sleep(2000);

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
}