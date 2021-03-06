import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {

    private Image image;
    private double xPos;
    private double yPos;    
 	private double velocityX;
    private double velocityY;
    private int timer;
 	private double width;
	private double height;

    
    public Sprite() {
        xPos = 0;
        yPos = 0;    
        velocityX = 0;
        velocityY = 0;
        timer = 0;
    }
    
    public Image getImage() {
    	return image;
    }
    
    public double getxPos() {
    	return xPos;
    }
    
    public double getyPos() {
    	return yPos;
    }
    
    public double getVelocityX() {
    	return velocityX;
    }
    
    public double getVelocityY() {
    	return velocityY;
    }
    
    public int getTimer() {
    	return timer;
    }

    public void setTimer(int time) {
    	timer = time;
    }
    
    public void setImage(Image i) {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String filename) {
        Image i = new Image(filename);
        setImage(i);
    }

    public void setPosition(double x, double y) {
        xPos = x;
        yPos = y;
    }

    public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
    }
    
    public void update(double time) {
        xPos += velocityX * time;
        yPos += velocityY * time;
    }
 
    public void render(GraphicsContext gc) {
        gc.drawImage( image, xPos, yPos );
    }
    
    public Rectangle2D getBoundary() {
        return new Rectangle2D( xPos, yPos, width, height);
    }
 
    public boolean intersects(Sprite target) {
        return target.getBoundary().intersects( this.getBoundary() );
    }
 
}
