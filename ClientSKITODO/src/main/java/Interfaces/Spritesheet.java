package Interfaces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	

	//Instance Variables
	    private String path;
	    private int frameWidth;
	    private int frameHeight;
	    private BufferedImage sheet = null;
	    
	    public BufferedImage getimage() {
	    	return sheet;
	    }

	//Constructors
	    public Spritesheet(String aPath, int width, int height) {

	        path = aPath;
	        frameWidth = width;
	        frameHeight = height;

	        try {
	            sheet = ImageIO.read(new File(path));
	         //   frameImages = getAllSprites();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	    public int getHeight() {
	        return frameHeight;
	    }

	    public int getWidth() {
	        return frameWidth;
	    }
	

}
