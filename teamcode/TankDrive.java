package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp
public class TankDrive extends OpMode
{
    private double powerLX, powerLY, powerRX, powerRY;
    private DcMotor FR, FL, BR, BL;


    @Override
    public void init()
    {
        FR = hardwareMap.get(DcMotor.class, "FR");
        FL = hardwareMap.get(DcMotor.class, "FL");
        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BL");

        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.FORWARD);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);

        FR.setPower(0);
        FL.setPower(0);
        BR.setPower(0);
        BL.setPower(0);
    }

    @Override
    public void loop()
    {
        powerLX = gamepad1.left_stick_x;
        powerLY = gamepad1.left_stick_y;
        powerRX = gamepad1.right_stick_x;
        powerRY = gamepad1.right_stick_y;

        if(powerLX < -0.3 || powerLX > 0.3)
        {
            FL.setPower(powerLX);
            BL.setPower(powerLX);
        } else {
            FL.setPower(0);
            BL.setPower(0);
        }

        if(powerLY < -0.3 || powerLY > 0.3)
        {
            FL.setPower(powerLY);
            BL.setPower(powerLY);
        } else {
            FL.setPower(0);
            BL.setPower(0);
        }

        if(powerRX < -0.3 || powerRX > 0.3)
        {
            FR.setPower(powerRX);
            BR.setPower(powerRX);
        } else {
            FR.setPower(0);
            BR.setPower(0);
        }

        if(powerRY < -0.3 || powerRY > 0.3)
        {
            FR.setPower(powerRY);
            BR.setPower(powerRY);
        } else {
            FR.setPower(0);
            BR.setPower(0);
        }

    }
}
