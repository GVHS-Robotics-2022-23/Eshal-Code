package org.firstinspires.ftc.teamcode;

import java.lang.Math;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class EncTest extends LinearOpMode
{
    public DcMotor BR, BL, linear;
    public Servo claw;

    //clicks per degree
    double cpd = 21.94;

    //clicks per inch
    double cpi = 87.5;

    public enum robotMotion
    {
        forward, backward, right, left, openClaw, closeClaw, linearup, lineardown;
    }

    @Override
    public void runOpMode() throws InterruptedException
    {
        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BL");
        linear = hardwareMap.get(DcMotor.class, "L");
        claw = hardwareMap.get(Servo.class, "c");

        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        linear.setDirection(DcMotorSimple.Direction.REVERSE);

        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        linear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        linear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linear.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        BR.setPower(0);
        BL.setPower(0);
        linear.setPower(0);
        claw.setPosition(0);

        waitForStart();
        Clawmovement(200, EncTest.robotMotion.closeClaw, 0.45);
        sleep(100);
        //linear slide up 2 in so it doesn't slide on mat
        linearup(2,0.6);
        movementFB(robotMotion.forward, 12, 0.5);
        linearup(25,0.6);
        lineardown(27,-0.5);
        Clawmovement(200, EncTest.robotMotion.openClaw, 0);
        linearup(2,0.5);
        movementRL(robotMotion.right, 90, 0.5);
        BR.setPower(0);
        BL.setPower(0);
        linear.setPower(0);

    }


    private void movementFB(robotMotion action, double inch,  double power)
    {
        if(action == robotMotion.forward)
        {
            //Sets new position for motors
            BL.setTargetPosition((int) ( BL.getCurrentPosition() + (inch*cpi)));
            BR.setTargetPosition((int) ( BR.getCurrentPosition() + (inch*cpi)));

            //Sets desired power for motors
            BL.setPower(power);
            BR.setPower(power);

            //Makes the motors to run to the position
            BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            //Loop to run encoders method
            while (BL.isBusy() && BR.isBusy())
            {

            }

            //Stop motors
            BL.setPower(0);

            BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            linear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        }
        else if (action == robotMotion.backward)
        {
            //Sets new position for motors
            BL.setTargetPosition((int) ( BL.getCurrentPosition() - (inch*cpi)));
            BR.setTargetPosition((int) ( BR.getCurrentPosition() - (inch*cpi)));

            //Sets desired power for motors
            BL.setPower(power);

            //Makes the motors to run to the position
            BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            //Loop to run encoders method
            while (BL.isBusy() && BR.isBusy())
            {

            }

            //Stop motors
            BL.setPower(0);
            BR.setPower(0);

            BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            linear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
    }

    private void movementRL(robotMotion action, double degree,  double power)
    {
        if(action == robotMotion.left)
        {
            //Sets new position for motors
            BL.setTargetPosition((int) ( BL.getCurrentPosition() - (degree*cpd)));
            BR.setTargetPosition((int) ( BR.getCurrentPosition() + (degree*cpd)));

            //Sets desired power for motors
            BL.setPower(-power);

            //Makes the motors to run to the position
            BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            //Loop to run encoders method
            while (BL.isBusy() && BR.isBusy())
            {

            }

            //Stop motors
            BL.setPower(0);
            BR.setPower(0);

            BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            linear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
        else if (action == robotMotion.right)
        {
            //Sets new position for motors
            BL.setTargetPosition((int) ( BL.getCurrentPosition() + (degree*cpd)));
            BR.setTargetPosition((int) ( BR.getCurrentPosition() - (degree*cpd)));

            //Sets desired power for motors
            BL.setPower(power);

            //Makes the motors to run to the position
            BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            //Loop to run encoders method
            while (BL.isBusy() && BR.isBusy())
            {

            }

            //Stop motors
            BL.setPower(0);
            BR.setPower(0);

            BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            linear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
    }


    private void linearup(double inch, double power)
    {
        linear.setTargetPosition((int) (linear.getCurrentPosition() + (inch*cpi)));
        linear.setPower(power);
        linear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (linear.isBusy())
        {

        }
        // set to 0.1 because gravity pulls slide down; keep stable
        linear.setPower(0.1);

        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    private void lineardown(double inch, double power)
    {
        linear.setTargetPosition((int) (linear.getCurrentPosition() - (inch*cpi)));
        linear.setPower(power);
        linear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (linear.isBusy())
        {

        }
        linear.setPower(0);

        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    private void Clawmovement(int Sleep, robotMotion action, double position)
    {
        if(action == robotMotion.openClaw)
        {
            claw.setPosition(position);
            sleep(Sleep);
        }
        else if(action == robotMotion.closeClaw)
        {
            claw.setPosition(position);
            sleep(Sleep);
        }
    }

    private void robotsleep(int sleep, double power)
    {
        BR.setPower(0);
        BL.setPower(0);
        linear.setPower(0);
    }
}