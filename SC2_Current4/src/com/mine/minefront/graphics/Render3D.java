package com.mine.minefront.graphics;

import com.mine.minefront.Game;
import com.mine.minefront.input.Controller;
import com.mine.minefront.level.Level;

public class Render3D extends Render {

	public double[] zBuffer;
	private double renderDistance = 5000;
	private double forward, right, cosine, sine, up , walking;

	public Render3D(int width, int height) {
		super(width, height);
		zBuffer = new double[width * height];
	}

	public void floor(Game game) {

		double floorPosition = 8;// Math.sin(game.time / 4) + 10;
		double ceilingPostion = 8; // Math.sin(game.time / 4) + 10;
		forward = game.controls.z;
		right = game.controls.x;
		up = game.controls.y;
		walking = 0;
		double rotation = game.controls.rotation;//Math.sin(game.time / 40.0) * 0.5; //
		cosine = Math.cos(rotation);
		sine = Math.sin(rotation);

		for (int y = 0; y < height; y++) {
			double ceiling = (y - height / 2.0) / height;
			double z = (floorPosition + up) / ceiling;
			
			if (Controller.walk) {
				walking = Math.sin(game.time / 6.0) * 0.7;
				z = (floorPosition + up + walking) / ceiling;
			}
			if (Controller.crouchWalk && Controller.walk) {
				walking = Math.sin(game.time / 6.0) * 0.2;
				z = (floorPosition + up + walking) / ceiling;
				}
			if (Controller.sprintWalk && Controller.walk) {
				walking = Math.sin(game.time / 6.0) * 0.9;
				z = (floorPosition + up + walking) / ceiling;
			}
			
		//System.out.println("walking" + walking);
			
			if (ceiling < 0) {
				z = (ceilingPostion - up) / -ceiling;
				if (Controller.walk) {
					z = (ceilingPostion - up - walking) / -ceiling;
				}
		
			}

			for (int x = 0; x < width; x++) {
				double Depth = (x - width / 2.0) / height;
				Depth *= z;
				double xx = (Depth * cosine + z * sine);
				double yy = (z * cosine - Depth * sine);
				int xPix = (int) (xx + right);
				int yPix = (int) (yy + forward);
				zBuffer[x + y * width] = z;
				pixels[x + y * width] = Texture.floor.pixels[(xPix & 7)+ (yPix & 7) * 16];// ((xPix & 15) * 16) | ((yPix & 15)*// 16) << 8;

				  if (z > 500){ 
					  pixels[x + y * width] = 0; 
				}
			}  	
		}
		
		Level level = game.level;
		int size = 5;
		for (int xBlock = -size; xBlock <= size; xBlock++ ){
			
		}
	}

	public void renderWall(double xLeft, double xRight, double zDistanceLeft, double zDistanceRight,double yHeight) {
		double upCorrect = 0.0625;
		double rightCorrect = 0.0625;
		double forwardCorrect = 0.0625;
		double walkCorrect = -0.0625;
		
		double xcLeft = ((xLeft) - (right * rightCorrect )) * 2;
		double zcLeft = ((zDistanceLeft) - (forward * forwardCorrect)) * 2;

		double rotLeftSideX = xcLeft * cosine - zcLeft * sine;
		double yCornerTL = ((-yHeight) - (-up * upCorrect + (walking * walkCorrect))) * 2;
		double yCornerBL = ((+0.5 - yHeight) - (-up * upCorrect+ (walking* walkCorrect))) * 2;
		double rotLeftSideZ = zcLeft * cosine + xcLeft * sine;

		double xcRight = ((xRight) - (right * rightCorrect)) * 2;
		double zcRight = ((zDistanceRight) - (forward * forwardCorrect)) * 2;

		double rotRightSideX = xcRight  * cosine - zcRight * sine;
		double yCornerTR = ((-yHeight) - (-up * upCorrect+ (walking* walkCorrect))) * 2;
		double yCornerBR = ((+0.5 - yHeight) - (-up * upCorrect+ (walking* walkCorrect))) * 2;
		double rotRightSideZ = zcRight * cosine + xcRight * sine;

		double xPixelLeft = (rotLeftSideX / rotLeftSideZ * height + width / 2);
		double xPixelRight = (rotRightSideX / rotRightSideZ * height + width / 2);
		
		double tex30 = 0;
		double tex40 = 8;
		double clip = 0.5;
		
		if ( rotLeftSideZ < clip && rotRightSideZ < clip){
			return;
		}
		
		if(rotLeftSideZ < clip){
			double clip0 = (clip - rotLeftSideZ)/ (rotRightSideZ - rotLeftSideZ);
			rotLeftSideZ = rotLeftSideZ + (rotRightSideZ - rotLeftSideZ)* clip0;
			rotLeftSideX = rotLeftSideX + (rotRightSideX - rotLeftSideX)* clip0;
			tex30 = tex30 + (tex40 - tex30) * clip0;
		}
		if(rotRightSideZ < clip){
			double clip0 = (clip - rotLeftSideZ)/ (rotRightSideZ - rotLeftSideZ);
			rotRightSideZ = rotLeftSideZ + (rotRightSideZ - rotLeftSideZ)* clip0;
			rotRightSideZ = rotLeftSideX + (rotRightSideX - rotLeftSideX)* clip0;
			tex30 = tex30 + (tex40 - tex30) * clip0;
		}
		if (xPixelLeft >= xPixelRight) {
			return;
		}

		int xPixelLeftInt = (int) (xPixelLeft);
		int xPixelRightInt = (int) (xPixelRight);

		if (xPixelLeftInt < 0) {
			xPixelLeftInt = 0;
		}
		if (xPixelRightInt > width) {
			xPixelRightInt = width;
		}

		double yPixelLeftTop =  yCornerTL / rotLeftSideZ * height + height / 2.0;
		double yPixelLeftBottom =  yCornerBL / rotLeftSideZ * height + height / 2.0;
		double yPixelRightTop =  yCornerTR / rotRightSideZ * height + height / 2.0;
		double yPixelRightBottom =  yCornerBR / rotRightSideZ * height + height / 2.0;

		double tex1 = 1 / rotLeftSideZ;
		double tex2 = 1 / rotRightSideZ;
		double tex3 = tex30 / rotLeftSideZ;
		double tex4 = tex40 / rotRightSideZ - tex3;
		
		for (int x = xPixelLeftInt; x < xPixelRightInt; x++) {
			double pixelRotation = (x - xPixelLeft)/ (xPixelRight - xPixelLeft);
			
			int xTexture = (int) ((tex3 + tex4 * pixelRotation)/ (tex1 + (tex2 -tex1)*pixelRotation ));
			
			double yPixelTop = yPixelLeftTop + (yPixelRightTop - yPixelLeftTop)* pixelRotation;
			double yPixelBottom = yPixelLeftBottom+ (yPixelRightBottom - yPixelLeftBottom) * pixelRotation;

			int yPixelTopInt = (int) (yPixelTop);
			int yPixelBottomInt = (int) (yPixelBottom);

			if (yPixelTopInt < 0) {
				yPixelTopInt = 0;
			}
			if (yPixelBottomInt > height) {
				yPixelBottomInt = height;
			}
			for (int y = yPixelTopInt; y < yPixelBottomInt; y++){
				double pixelRotationY =(y- yPixelTop)/ (yPixelBottom - yPixelTop);
				int yTexture = (int) (8*pixelRotationY );
				pixels[x + y * width] = Texture.floor.pixels[((xTexture & 7)+ 8)+ ((yTexture & 7)+ 8) * 16];
				//pixels[x+y*width] = xTexture* 10 + yTexture * 10 * 256; //hex color (picker)
				zBuffer[x+y* width] = 1 / ( tex1 + (tex2 -tex1)*pixelRotation ) * 8;
			}
		}

	}

	public void renderDistanceLimiter() {
		for (int i = 0; i < width * height; i++) {
			int color = pixels[i];
			int brightness = (int) (renderDistance / (zBuffer[i]));
			// Brightness only goes form 0 - 255
			if (brightness < 0) {
				brightness = 0;
			}

			if (brightness > 225) {
				brightness = 225;
			}

			int r = (color >> 16) & 0xff;
			int g = (color >> 8) & 0xff;
			int b = (color) & 0xff;

			r = r * brightness / 255;
			g = g * brightness / 255;
			b = b * brightness / 255;

			pixels[i] = r << 16 | g << 8 | b;
		}
	}
}