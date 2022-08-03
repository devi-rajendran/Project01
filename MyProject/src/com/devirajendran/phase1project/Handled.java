package com.devirajendran.phase1project;
import java.util.List;
import java.util.Scanner;

public class Handled {
	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				Menu.displayMenu();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					FileCreations.displayAllFiles("main");
					break;
				case 2:
					handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					System.out.println("Thank you ! Visit Again !");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}

	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				Menu.displayFileMenuOptions();
				FileCreations.createMainFolderIfNotPresent("main");

				int input = sc.nextInt();
				switch (input) {
				case 1:
					// File Add
					System.out.println("Enter the name of the file to be added to the \"main\" folder");
					String fileToAdd = sc.next();

					FileCreations.createFile(fileToAdd, sc);

					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the name of the file to be deleted from \"main\" folder");
					String fileToDelete = sc.next();

					FileCreations.createMainFolderIfNotPresent("main");
					List<String> filesToDelete = FileCreations.displayFileLocations(fileToDelete, "main");

					String deletionPrompt = "\nAre you sure to delete this file \n"+""
							+ "If \"YES\" then press 0 Or \"NO\" For press any number" ;
					System.out.println(deletionPrompt);				 
					int idx = sc.nextInt();

					if (idx==0) {				
						for (String path : filesToDelete) {
							FileCreations.deleteFileRecursively(path);
						}
					}
					else {

						System.out.println("File not deleted !");
						break;
					}

					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"main\" folder");
					String fileName = sc.next();

					FileCreations.createMainFolderIfNotPresent("main");
					FileCreations.displayFileLocations(fileName, "main");					
					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
} 
 


