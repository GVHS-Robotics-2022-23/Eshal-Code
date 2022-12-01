package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp
public class TankDrive extends OpMode
{
    private double powerLY, powerRY;
    private DcMotor BR, BL;


    @Override
    public void init()
    {
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
        powerLY = gamepad2.left_stick_y;
        powerRY = gamepad2.right_stick_y;

        if(powerLY < -0.3 || powerLY > 0.3)
        {
            BL.setPower(powerLY);
        } else {
            BL.setPower(0);
        }

        if(powerRY < -0.3 || powerRY > 0.3)
        {
            BR.setPower(powerRY);
        } else {
            BR.setPower(0);
        }

    }
}
