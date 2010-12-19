/*
#
# ButtonControler.java
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


package events;


import generic.Utils;

import java.awt.Graphics2D;
import java.util.Vector;

import objects.hud.HudButton;
import objects.hud.HudInputBox;
import objects.hud.HudMenuButton;
import objects.hud.Object2D;
import objects.hud.HudSlider;
import rendering.Scene;

public class ButtonControler {
	
	static Vector<Object2D> monitored = new Vector<Object2D>();
	
	public ButtonControler(){
		addMainMenu();
	}
	
	public static boolean checkLocation(int x,  int y){
		return checkLocation(monitored,x,y);
	}
	
	public static boolean checkLocation(Vector<Object2D> tocheck, int x,  int y){
		for(Object2D b : tocheck){
			//Utils.console(""+x+","+y+"=="+b.x+","+b.y);
			if(b.x < x && b.y < y){
				if(b.getAbsoluteSizeX() > x && b.getAbsoluteSizeY() > y){
					if(b.isVisible()){
						((HudButton)b).runPayload();
						return true;
					}
				}	
			}
		}
		return false;
	}
	
	public static void addMainMenu(){
		new HudMenuButton(0,0,"File");
		new HudMenuButton(70,0,"Edit");
		new HudMenuButton(140,0,"View");
		new HudButton(210,0,"Help");
	}
	
	public static void rightClickMenu(int x, int y){
		new HudButton(x,y+00,"Button1");
		new HudButton(x,y+20,"Button2");
		new HudButton(x,y+40,"Button3");
		new HudButton(x,y+60,"Button4");
	}
	
	public static void addButton(Object2D b){
		monitored.add(b);
	}

	public void render(Graphics2D g) {
		for(Object2D b : monitored){
			b.render(g);
		}
	}
}
