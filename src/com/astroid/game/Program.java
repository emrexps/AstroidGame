package com.astroid.game;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Program {
	public static void main(String[] arg) {
		Game game = new Game();
		game.play();
	}
}

abstract class Obj {
	abstract void evolve();

	abstract void draw(Graphics g);
}
