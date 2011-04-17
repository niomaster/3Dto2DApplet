/*
#
# Camera.java
#
# copyright (c) 2009-2010, Danny Arends
# last modified Dec, 2010
# first written Dec, 2010
#
#     This program is free software; you can redistribute it and/or
#     modify it under the terms of the GNU General Public License,
#     version 3, as published by the Free Software Foundation.
# 
#     This program is distributed in the hope that it will be useful,
#     but without any warranty; without even the implied warranty of
#     merchantability or fitness for a particular purpose.  See the GNU
#     General Public License, version 3, for more details.
# 
#     A copy of the GNU General Public License, version 3, is available
#     at http://www.r-project.org/Licenses/GPL-3
#
*/

package nl.dannyarends.applet.objects;

import nl.dannyarends.applet.objects.renderables.Object3D;
import nl.dannyarends.rendering.Scene;

/// Represents the camera in 3D space
//<p>
//TODO
//</p>
//

public class Camera extends Object3D{
	
	private static double near = 3.0f;
	private static double nearToObj = 0.1f;

	public Camera(double x, double y, double z){
		super(x,y,z);
	}
	
	public Camera(double x, double y, double z,int hrot, int vrot){
		super(x,y,z,hrot,vrot);
	}
	
	public void move(double[] offset){
		move(offset[0],offset[1],offset[2]);
	}
	
	public void move(double x, double y, double z){
		location[0] += 1.5*x;
		location[1] += 1.5*y;
		location[2] += 1.5*z;
		Scene.updateScene(false, true);
	}

	public void setNear(double n) {
		near = n;
	}

	public static double getNear() {
		return near;
	}

	public void setNearToObj(double nto) {
		nearToObj = nto;
	}

	public static double getNearToObj() {
		return nearToObj;
	}

	@Override
	public double[] getTextureCoords(double[] point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double intersect(Vector3D ray) {
		// TODO Auto-generated method stub
		return 0;
	}
}