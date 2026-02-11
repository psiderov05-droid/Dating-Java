package performance;

import java.io.FileInputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Charater {
	private double X;
	private double Y;
	private Image image;
	private ImageView imageView;
	private static final String pathToImages = "resources/img/";
	
	public Charater(double X, double Y, String image){
		this.X = X;
		this.Y = Y;
		String path = pathToImages+image;
		try {
			this.image = new Image(new FileInputStream(path));
		}catch (Exception e) {
			System.out.println("Could not load image");
		}
		this.imageView = new ImageView();
		//-------------------------
		this.imageView.setImage(this.image);
		this.imageView.setX(this.X);
		this.imageView.setY(this.Y);
	}
	

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
	
	
}
