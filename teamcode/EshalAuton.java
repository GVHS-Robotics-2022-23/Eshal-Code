package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous
public class EshalAuton extends LinearOpMode
{
    public DcMotor BR, BL, linear;
    public Servo claw;
    double power = 0.5;

    public enum robotMotion
    {
        forward, backward, right, left, openClaw, closeClaw, linearup, lineardown;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BR");
        linear = hardwareMap.get(DcMotor.class, "L");
        claw = hardwareMap.get(Servo.class, "c");

        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        linear.setDirection(DcMotorSimple.Direction.REVERSE);

        BR.setPower(0);
        BL.setPower(0);
        linear.setPower(0);
        claw.setPosition(0);


        waitForStart();
        movementFB(300, robotMotion.forward, 0.5);
        robotSleep(200, 0.00);
        Clawmovement(750, )

    }

        private void movementFB(int Sleep, robotMotion action, double power)
        {
            if(action == robotMotion.forward)
            {
                BR.setPower(power);
                BL.setPower(power);
                sleep(Sleep);
                BR.setPower(0);
                BL.setPower(0);
            }
            else if (action == robotMotion.backward)
            {
                BR.setPower(-power);
                BL.setPower(-power);
                sleep(Sleep);
                BR.setPower(0);
                BL.setPower(0);
            }
        }

        private void movementRL(int Sleep, robotMotion action, double power)
        {
            if(action == robotMotion.left)
            {
                BR.setPower(power);
                BL.setPower(-power);
                sleep(Sleep);
                BR.setPower(0);
                BL.setPower(0);
            }
            else if (action == robotMotion.right)
            {
                BR.setPower(-power);
                BL.setPower(power);
                sleep(Sleep);
                BR.setPower(0);
                BL.setPower(0);
            }
        }

        private void linearup(int Sleep, double power)
        {
           linear.setPower(power);
           sleep(Sleep);
           linear.setPower(0);
        }

        private void lineardown(int Sleep, double power)
        {
            linear.setPower(power);
            sleep(Sleep);
            linear.setPower(0);
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

    private void robotSleep(int sleep, double power)
    {
        BR.setPower(0);
        BL.setPower(0);
    }

}