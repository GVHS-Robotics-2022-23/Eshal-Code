package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class JagEshal extends OpMode
{
    public Servo claw;
    public DcMotor linear;

    private double powerLY, powerRY;
    private DcMotor BR, BL;

    @Override
    public void init()
    {
        linear = hardwareMap.get(DcMotor.class, "L");
        claw = hardwareMap.get(Servo.class, "c");

        linear.setDirection(DcMotorSimple.Direction.FORWARD);

        linear.setPower(0);
        claw.setPosition(0);

        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BL");

        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.FORWARD);

        BR.setPower(0);
        BL.setPower(0);
    }

    @Override
    public void loop()
    {
            if(gamepad2.dpad_up)
            {
                linear.setPower(0.7);
            } else
            {
                linear.setPower(0);
            }
             if(gamepad2.dpad_down)
             {
                 linear.setPower(-0.6);
             } else
                 linear.setPower(0);
             }
        {
            linear.setPower(0);
            if (gamepad2.a)
            {
                claw.setPosition(0.5);
            } else if (gamepad2.y)
            {
                claw.setPosition(0);
            }

        powerLY = gamepad2.left_stick_y;
        powerRY = gamepad2.right_stick_y;

        if(powerLY < -0.7 || powerLY > 0.7)
        {
            BL.setPower(powerLY);
        } else {
            BL.setPower(0);
        }

        if(powerRY < -0.7 || powerRY > 0.7)
        {
            BR.setPower(powerRY);
        } else {
            BR.setPower(0);
        }

    }

}
