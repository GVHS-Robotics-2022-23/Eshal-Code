package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Servo extends OpMode
{
    public com.qualcomm.robotcore.hardware.Servo gate;
    public DcMotor linear;

    @Override
    public void init(){
        linear = hardwareMap.get(DcMotor.class, "L");
        gate = hardwareMap.get(com.qualcomm.robotcore.hardware.Servo.class, "c");

        linear.setDirection(DcMotorSimple.Direction.FORWARD);

        linear.setPower(0);
        gate.setPosition(0);
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
            gate.setPosition(0.5);
        } else if (gamepad1.y)
        {
            gate.setPosition(0);
        }
    }
}
