package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="AutonomousOpMode", group= "Autonomous")
public class AutonomousOpMode extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor shooterLeft;
    private DcMotor shooterRight;
    private DcMotor conveyorMotor;
    private DcMotor intakeMotor;
    private Servo wobbleFront;
    private Servo wobbleBack;

    static final double motorTickCount = 288;

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

        wobbleFront = hardwareMap.get(Servo.class, "wobbleFront");

        wobbleBack = hardwareMap.get(Servo.class, "wobbleBack");

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        shooterLeft.setDirection(DcMotor.Direction.FORWARD);
        shooterLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        shooterRight.setDirection(DcMotor.Direction.FORWARD);
        shooterRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        conveyorMotor.setDirection(DcMotor.Direction.REVERSE);
        conveyorMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        intakeMotor.setDirection(DcMotor.Direction.REVERSE);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        wobbleFront.setDirection(Servo.Direction.FORWARD);

        wobbleBack.setDirection(Servo.Direction.REVERSE);

        double distanceToShootingPostion = motorTickCount * 5.4;

        waitForStart();
        // Tell the robot to reset the encoders
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Tell the robot to set the starting position
        frontLeft.setTargetPosition((int)distanceToShootingPostion);
        frontRight.setTargetPosition((int)distanceToShootingPostion);
        backLeft.setTargetPosition((int)distanceToShootingPostion);
        backRight.setTargetPosition((int)distanceToShootingPostion);
        //Set the robots power to 1
        frontLeft.setPower(1);
        frontRight.setPower(1);
        backLeft.setPower(1);
        backRight.setPower(1);

        shooterLeft.setPower(.92);
        shooterRight.setPower(-.92);
        // Have the robot run towards the postion.
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //Keep track of where the robot is running or not
        while(frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()){
            telemetry.addData("Status", "Going to the shooting position");
            telemetry.update();
        }
        //When the robot is finished set the power to zero, to stop it
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

//        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        sleep(1000);

        conveyorMotor.setPower(.5);
        intakeMotor.setPower(1);

        telemetry.addData("Shooter Left Power: ", shooterLeft.getPower());
        telemetry.addData("Shooter Right Power: ", shooterRight.getPower());
        telemetry.update();

        sleep(24000);

        shooterLeft.setPower(0);
        shooterRight.setPower(0);
        conveyorMotor.setPower(0);

        sleep(600);
    }
}