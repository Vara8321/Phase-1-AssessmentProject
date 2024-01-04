package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CameraRentalSystem {
	 private static List<Camera> cameras;

	    public CameraRentalSystem() {
	        this.cameras = new ArrayList<>();
	        initializeCameras(); // Initialize the system with some sample cameras
	    }

	    private void initializeCameras() {
	        // Add some sample cameras to the list during system initialization
	        cameras.add(new Camera(1, "Canon", "EOS R5", 200.0f, "Available"));
	        cameras.add(new Camera(2, "Nikon", "Z6 M34", 250.0f, "Available"));
	        cameras.add(new Camera(3, "Sony", "A7 III", 500.0f, "Rented"));
	        cameras.add(new Camera(4, "samsung", "AII M2", 5000.0f, "Available"));
	        cameras.add(new Camera(5, "Panasonic", "Model1", 1000.0f, "Available"));
	    }
	    
	    private static void addCameras() {
	        
	        Scanner ad=new Scanner(System.in);

	        char addMoreCameras;
	        do {
	            System.out.print("Enter the camera brand: ");
	            String brand = ad.next();

	            System.out.print("Enter the model: ");
	            String model = ad.next();

	            System.out.print("Enter the per day price (INR): ");
	            float rentalRate = ad.nextFloat();

	            // Generate a unique ID for the camera (you can modify the logic as needed)
	            int cameraID = cameras.size() + 1;
	            String status= "Available";
	            
	            

	            // Create and add the camera to the list
	            cameras.add(new Camera(cameraID, brand, model, rentalRate,status));

	            System.out.print("Do you want to add another camera? (y/n): ");
	            addMoreCameras = ad.next().charAt(0);

	        } while (addMoreCameras == 'y' || addMoreCameras == 'Y');
	        System.out.println("Your Camera successfully added to list");
	    }
	    
	    private static void removeCameraById(int cameraID) {
	        Iterator<Camera> iterator = cameras.iterator();
	        while (iterator.hasNext()) {
	            Camera camera = iterator.next();
	            if (camera.getCameraID() == cameraID) {
	                iterator.remove();
	                System.out.println("Camera with ID " + cameraID + " removed successfully.");
	                return;
	            }
	        }
	        System.out.println("Camera with ID " + cameraID + " not found.");
	    }

	    private static void displayCameras() {
	    	System.out.println("=====================================================================================");
	        System.out.printf("%-15s%-15s%-15s%-20s%-15s\n", "Camera ID", "Brand", "Model", "Price(Per Day)", "Status");
	        System.out.println("=====================================================================================");
	        for (Camera camera : cameras) {
	            
	                System.out.printf("%-15d%-15s%-15s%-20.2f%-15s\n",camera.cameraID,camera.brand,camera.model,camera.rentalRate,camera.status);
	        }
	        System.out.println("=====================================================================================");
	    }
	    
	    public static void rentAvailableCamera(int cameraID) {
	    	
	    	
	    	Iterator<Camera> iterator = cameras.iterator();
	        while (iterator.hasNext()) {
	            Camera camera = iterator.next();
	            if (camera.getCameraID() == cameraID) {
	            	if(camera.getRentalRate()<=Wallet.getBudget()) {
	                camera.setStatus("Rented");
	                Wallet.budget=Wallet.budget-camera.rentalRate;
	                System.out.println("Your Transaction for Camera - " + camera.getBrand()+ camera.getModel() + 
	                		" with rent INR." + camera.getRentalRate()+
	                		" has successfully completed ");
	            	}else {
	            		System.out.println("Error: Transacttion Failed due to insufficient"
	            				+ " wallet balance. Please Deposit the amount to your wallet");
	            	}
	            }
	        }
	        
            
	        
	    }
	    	
	    
	    private static void displayAvailableCameras() {
	    	
	        System.out.println("Following is the list of Available Cameras - ");
	        System.out.println("=====================================================================================");
	        System.out.printf("%-15s%-15s%-15s%-20s%-15s\n", "Camera ID", "Brand", "Model", "Price(Per Day)", "Status");
	        System.out.println("=====================================================================================");
	        for (Camera camera : cameras) {
	            if (camera.getStatus().contentEquals("Available")) {
	                System.out.printf("%-15d%-15s%-15s%-20.2f%-15s\n",camera.cameraID,camera.brand,camera.model,camera.rentalRate,camera.status);
	            }
	        }
	        System.out.println("=====================================================================================");
	    }

	    public static void main(String[] args) {
	    	
	        CameraRentalSystem rentalSystem = new CameraRentalSystem();
	        
	        Wallet wallet=new Wallet();
	        
	        Scanner scanner=new Scanner(System.in);
	        System.out.println("+-------------------------------------+");
	        System.out.println("|   Welcome to the Camera Rental APP  |");
	        System.out.println("+-------------------------------------+");
	        System.out.println("Please login to continue- ");
	        System.out.print("USERNAME - ");
	        String username = scanner.nextLine();
	        System.out.print("PASSWORD - ");
	        String password = scanner.nextLine();
	        optionsSelection();
	    }
	        
	        private static void optionsSelection() {
	            String[] arr = {"1. MY CAMERA",
	                    "2. RENT A CAMERA",
	                    "3. VIEW ALL CAMERAS",
	                    "4. MY WALLET",
	                    "5. EXIT"
	            };
	            int[] arr1 = {1,2,3,4,5};
	            int  slen = arr1.length;
	            for(int i=0; i<slen;i++){
	                System.out.println(arr[i]);
	 
	            }
	            Scanner sc = new Scanner(System.in);
	            int  options =  sc.nextInt();
	            
	                    switch (options){
	                        case 1:
	                            choiceSelection();
	                            break;
	                        case 2:
	                        	displayAvailableCameras();
	                        	System.out.println("Enter the camera ID you want to rent - ");
	                        	int cameraID=sc.nextInt();
	                        	rentAvailableCamera(cameraID);
	                            optionsSelection();

	                            break;
	                        case 3:
	                        	displayCameras();
	                            optionsSelection();
	                            break;
	                        case 4:
	                            System.out.println("Your current wallet balance is - INR." + Wallet.getBudget());
	                            selectYesOrNo();
	                            optionsSelection();
	                            break;
	                        case 5:
	                        	closeApp();
	                            break;
	         
	                        default:
	                            System.out.println("You have made an invalid choice!");
	                            System.out.println("Enter Correct Choice");
	                            optionsSelection();
	                            break;
	                    }
	                
	        
	    }
	        
	        public static void selectYesOrNo() {
	        	System.out.println("Do you want to deposit more amount to your wallet?(1.YES 2.NO)");
	        	Scanner imp=new Scanner(System.in);
                int selectYesNo=imp.nextInt();
                switch(selectYesNo) {
                	case 1:
                		System.out.println("Enter the amount (INR) - ");
                		float amount=imp.nextInt();
                		Wallet.budget=Wallet.budget+amount;
                		System.out.println("Your wallet balance updated successfully. Current "
                				+ "wallet balance - INR." + Wallet.budget);
                		break;
                	case 2:
                		optionsSelection();
                		break;
                	default:
                		System.out.println("Invalid choice: Enter correct choice");
                		selectYesOrNo();
                			
                }
	        }

			private static void choiceSelection() {
				
				String[] firstChoice= {"1. ADD",
                		"2. REMOVE",
                		"3. VIEW MY CAMERAS",
                		"4. GO TO PREVIOUS MENU"
                };
                int[] arr2= {1,2,3,4};
                int len=arr2.length;
                for(int a=0;a<len;a++) {
                	System.out.println(firstChoice[a]);
                }
                Scanner ch=new Scanner(System.in);
                int choice=ch.nextInt();
                
                		switch(choice) {
                			case 1:
                				addCameras();
                				choiceSelection();
                				break;
                			case 2:
                				displayCameras();
                				System.out.println("Enter the Camera ID to Remove - ");
                				int cameraID=ch.nextInt();
                				removeCameraById(cameraID);
                				choiceSelection();
                				break;
                			case 3:
                				displayCameras();
                				choiceSelection();
                				break;
                			case 4:
                				optionsSelection();
                				break;
                			default:
                				System.out.println("You have made an invalid choice!");
                				System.out.println("Enter correct choice");
                				choiceSelection();
	                            break;
                		}
			}
			
			private static void closeApp() {
		        System.out.println("Closing your application... \nThank you!");
		            }
}
