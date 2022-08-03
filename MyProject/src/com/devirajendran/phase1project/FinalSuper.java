package com.devirajendran.phase1project;


public class FinalSuper  {

	public static void main(String[] args) {

		FileCreations.createMainFolderIfNotPresent("main");

		Menu.printWelcomeScreen("          G-Plast Pvt. Ltd				", "Devi Rajrendran");

		Handled.handleWelcomeScreenInput();
	}

}

