/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
//import sun.awt.image.PixelConverter.ByteGray;
import edu.wpi.first.wpiutil.math.Num;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource;


public class Vision {

    private CvSink video;
    private UsbCamera camera;
    private CameraServer server;
    private VideoSource source;

    public Integer[] color;

    public Vision(){


        camera = new UsbCamera("USB Camera 0", 0);
        camera.setWhiteBalanceManual(6500);
        camera.close();
        
        server = CameraServer.getInstance();
        source = server.startAutomaticCapture();


        video = new CvSink("USB Camera 0");
        video.setSource(source);

       
    }
    
    public Integer[] getColor(){
        Mat image = new Mat(video.getSource().getVideoMode().height, video.getSource().getVideoMode().width, 0);
        video.grabFrame(image);
        double[] currColor = image.get(image.rows()/2, image.cols()/2);
        int r = (int)currColor[2];
        int g = (int)currColor[1];
        int b = (int)currColor[0];
        
        
        Integer guess = null;
        if (r > 128 && g < 128 && b < 128){
            guess = 2; //RED
        }
        if (r > 128 && g > 128 && b < 100){
            guess = 3; //Yellow
        }
        if (r < 128 && g > 128 && b < 128){
            guess = 1; //GREEN
        }
        if (r < 128 && g > 100 && b > 128){
            guess = 0; //CYAN
        }
        color = new Integer[]{r,g,b,guess};
        System.out.println(Arrays.toString(color));
        return color;
        //0123-null
        //BGRY-none
    }

}