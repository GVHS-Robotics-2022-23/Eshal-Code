package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class HolonomicCode extends OpMode
{
    public DcMotor BR, BL;
    private double powerRY, powerRX, powerLX, powerLY, robotAngle, PowerMultiplier, br, bl;

    @Override
    public void init()
    {
        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BL");

        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);

        BR.setPower(0);
        BL.setPower(0);
    }

    @Override
    public void loop()
    {
        powerLX = gamepad2.left_stick_x;
        powerLY = gamepad2.left_stick_y;
        powerRX = gamepad2.right_stick_x;
        powerRY = gamepad2.right_stick_y;

        if (gamepad1.right_bumper || gamepad1.left_bumper)
        {
            powerLX = gamepad2.left_stick_x/2;
            powerLY = gamepad2.left_stick_y/2;
            powerRX = gamepad2.right_stick_x/2;
            powerRY = gamepad2.right_stick_y/2;
        }

        if (gamepad1.left_stick_x != 0)
        {
            br = -powerRY;
            bl = powerRY;

            BR.setPower(br);
            BL.setPower(bl);
        }
        else
        {
            robotAngle = Math.atan2(powerRX, powerRY);
            telemetry.addData("Robot angle:", robotAngle);
            telemetry.update();

            PowerMultiplier = Math.sqrt((Math.pow(powerRX, 2) + Math.pow(powerRY, 2)));

            if(powerRX == 0 || powerRY == 0)
            {
                if (powerRY <= 1 && powerRX == 0)
                {
                    br = powerRY;
                    bl = powerRY;

                    BR.setPower(br);
                    BL.setPower(bl);
                }
                else if (powerRX <= 1 && powerRY == 0)
                {
                    br= powerRX;
                    bl = -powerRX;

                    BR.setPower(br);
                    BL.setPower(bl);
                }
            }
            br = (PowerMultiplier*(Math.sin(robotAngle+(Math.PI/4))));
            bl = (PowerMultiplier*-1*Math.sin(robotAngle-(Math.PI/4)));

            BR.setPower(br);
            BL.setPower(bl);
        }
    }
}



