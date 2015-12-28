package controllers;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import commands.CommandProcessor;

import modelviewcontroller.BrickGUI;
import modelviewcontroller.CADGUIController;
import modelviewcontroller.DimensionView;
import modelviewcontroller.FrontView;
import modelviewcontroller.SideView;
import modelviewcontroller.TopView;

public class ViewMenuController extends CADGUIController {

	private BrickGUI gui;
	public JInternalFrame mframe;
	
	public ViewMenuController(BrickGUI gui, CommandProcessor processor) {
		super(gui, processor);
		this.gui = gui;
		//gui.getBrick().addObserver(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JInternalFrame frame = new JInternalFrame();
		String cmd = e.getActionCommand();
		//SideView side = new SideView(frame, gui.getBrick());
		if (cmd.equals("Front View")){
			frame = new FrontView(gui.getBrick());
			((JComponent)frame.getContentPane()).setOpaque(false);
			//frame.setVisible(true);
			//frame.add(front);
		}
		else if (cmd.equals("Side View")){
			frame = new SideView(gui.getBrick());
			((JComponent)frame.getContentPane()).setOpaque(false);
			//side = new SideView(frame, gui.getBrick());
			//gui.getDesktop().add(frame);
			//frame.add(side);
		}
		else if (cmd.equals("Top View")){
			frame = new TopView(gui.getBrick());
			((JComponent)frame.getContentPane()).setOpaque(false);
			//frame.add(top);
		}else if (cmd.equals("Dimension View")){
			frame = new DimensionView(gui);
			((JComponent)frame.getContentPane()).setOpaque(false);
			//frame.add(top);
		}
			//gui.getBrick().addObserver(frame);
			frame.pack();
			JDesktopPane desktop = gui.getDesktop();
			desktop.add(frame);
			frame.setVisible(true);
			frame.setSize(300,300);
			if(cmd.equals("Dimension View"))
			{
				frame.setSize(250,200);
			}
			mframe = frame;
			//side.painter(frame.getGraphics());
			
 
		
	}

}
