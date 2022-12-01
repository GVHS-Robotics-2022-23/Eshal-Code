package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class JagWired extends OpMode
{
    public Servo claw;
    public DcMotor linear;

    @Override
    public void init(){
        linear = hardwareMap.get(DcMotor.class, "L");
        claw = hardwareMap.get(Servo.class, "c");

        linear.setDirection(DcMotorSimple.Direction.FORWARD);

        linear.setPower(0);
        claw.setPosition(0);
    }

    @Override
    public void loop()
    {
        if(gamepad1.dpad_up)
        {
            linear.setPower(0.7);
        } else if (gamepad1.dpad_down)
        {
            linear.setPower(-0.7);
        }
        if (gamepad1.a)
        {
            claw.setPosition(0.5);

        } else if (gamepad1.y)
        {
            claw.setPosition(0);
        }
    }
}
