package Interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PannelPhoto extends JPanel{

    private Spritesheet spritesheet;
    private BufferedImage currentFrame;
    private String nomPhoto ;

    public PannelPhoto() {
        spritesheet = new Spritesheet("src/main/java/Photos/image1.jpg", 1400, 800);
        currentFrame = spritesheet.getimage();
    }
    
    public PannelPhoto(String nomPhoto) {
        spritesheet = new Spritesheet("src/main/java/Photos/"+nomPhoto, 1400, 800);
        currentFrame = spritesheet.getimage();
    }
    
    public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	@Override
    public Dimension getPreferredSize() {
        return new Dimension(1400, 800);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentFrame != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            int x = (getWidth() - spritesheet.getWidth()) / 2;
            int y = (getHeight() - spritesheet.getHeight()) / 2;
            g2d.drawImage(currentFrame, x, y, this);
            g2d.dispose();
        }
    }

}

