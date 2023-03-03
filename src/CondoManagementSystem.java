import java.util.Scanner;

public class CondoManagementSystem {
    public static void press(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press ENTER to continue...!");
        input.nextLine();
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int option = 0;
        String[][] condo = new String[0][];
        int floor;
        int room = 0;
        int desiredFloor = 0;
        int desiredRoom = 0;
        String CondoOwnerName = " ";
        boolean isFloorValid = false;
        boolean isRoomValid = false;
        do{
            System.out.println("\n=============== SETTING UP THE CONDO ===============");
            System.out.print("-> Enter number of Floor : ");
            floor = input.nextInt();
            if(floor > 0){
                isFloorValid = true;
                System.out.print("-> Enter number of Room : ");
                room = input.nextInt();
                if(room > 0){
                    isRoomValid = true;
                    condo = new String[floor][room];
                    System.out.println("Congratulations !! You have successfully set up the condo...");
                    if(floor>1){
                        System.out.println("=> Number of Floor = " + floor + " floors.");
                    }else{
                        System.out.println("=> Number of Floor = " + floor + " floor.");
                    }
                    if(room>1){
                        System.out.println("=> Number of Room = " + room + " rooms.");
                    }else{
                        System.out.println("=> Number of Room = " + room + " room.");
                    }
                    if(floor*room > 1){
                        System.out.println("Total Condo : "+(floor * room)+" rooms.");
                    }else{
                        System.out.println("Total Condo : "+(floor * room)+" room.");
                    }
                }else{
                    System.out.print("FLOOR CANNOT BE ZERO OR NEGATIVE");

                }
            }else{
                System.out.print("ROOM CANNOT BE ZERO OR NEGATIVE");
            }
        }while(!isFloorValid || !isRoomValid);
        press();

        do{
            System.out.println("============ Welcome to JASMINE-TAA Condo ============");
            System.out.println("1. Buy Condo");
            System.out.println("2. Sell Condo");
            System.out.println("3. Search Condo Information");
            System.out.println("4. Display Condo Information");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------------");
            System.out.print("-> Choose option from (1-5) : ");
            option = input.nextInt();


            switch(option){
                case 1:
                    //String CondoOwnerName = " ";
                    isFloorValid = false;
                    isRoomValid = false;
                    boolean isConditionValid = false;
                    int buyOption;
                    do{
                        System.out.println("---------------- Buying the Condo -------------------");
                        System.out.print("Please Enter your desired floor (1 - " +floor+ ") : ");
                        desiredFloor = input.nextInt();

                        if(desiredFloor > 0 && desiredFloor <= floor){
                            isFloorValid = true;
                            System.out.print("Please Enter your desired room (1 - " +room+ ") : ");
                            desiredRoom = input.nextInt();

                            //add owner name
                            if(desiredRoom > 0 && desiredRoom <= room){
                                if(condo[desiredFloor - 1][desiredRoom - 1] == null){
                                    isRoomValid = true;
                                    isConditionValid = true;
                                    System.out.print("Please Enter your Name : ");
                                     input.nextLine();
                                    CondoOwnerName = input.nextLine();

                                    condo[desiredFloor-1][desiredRoom-1] = CondoOwnerName;
                                    System.out.println("Congratulations, you have successfully bought the condo.");
                                }else{
                                    System.out.println("The room is already owned by someone else.");
                                    isRoomValid = false;
                                }
                            }else{
                                System.out.println("ROOM RANGE START FROM  (1 - " + room + ")");
                                isRoomValid = false;
                            }
                        }else{
                            System.out.println("FLOOR RANGE START FROM  (1 - " + floor + ")");
                            isFloorValid = false;
                        }
                        if(!isFloorValid || !isRoomValid){
                            press();
                        }
                    }while(!isConditionValid);
                    break;
                case 2:
                    System.out.println("----------------- Selling the Condo Back -----------------");
                    System.out.print("-> Enter the floor you want to sell : ");
                    desiredFloor = input.nextInt();
                    System.out.print("-> Enter the room you want to sell : ");
                    desiredRoom = input.nextInt();

                    if(desiredFloor > 0 && desiredFloor <= floor && desiredRoom > 0 && desiredRoom <= room){
                        if(condo[desiredFloor-1][desiredRoom-1] != null){
                            System.out.println(">> Selected Condo Information :");
                            System.out.println("Floor : " + desiredFloor + "   " + " Room : " + desiredRoom +
                                                "    Belong to : " + CondoOwnerName);

                            System.out.print("Enter 1 to confirm and 0 to cancel : ");
                            int choice = input.nextInt();
                            if(choice == 1){
                                condo[desiredFloor-1][desiredRoom-1] = null;
                                System.out.println("\nCongratulations, you have successfully sold the condo !!");
                            }else if(choice == 0){
                                System.out.println("You have cancelled to sell the condo.");
                            }else {
                                System.out.println("Invalid input (1 or 0) :");
                            }
                        }else{
                            System.out.println("CANNOT SELL THE CONDO, CAUSE YOU DON'T HAVE THE OWNERSHIP!");
                        }
                    }else{
                        System.out.println("Error!!! Floor and room is invalid.");
                    }
                    break;
                case 3:
                    int searchOption;
                    System.out.println("------------------ Search Condo Information ----------------");
                    System.out.println("1. --> Search by ownr's name");
                    System.out.println("2. --> Search by floor");
                    System.out.println("3. --> Exit");
                    System.out.print("Please choose your option from (1-3) : ");
                    searchOption = input.nextInt();

                    switch(searchOption){
                        case 1 -> {
                            String searchOwnerName;
                            boolean ownerExist = false;
                            System.out.println("+++++++++++++++++ Search by Owner's name +++++++++++++++++");
                            System.out.print("--> Please Enter owner name to search : ");
                            input.nextLine();
                            searchOwnerName = input.nextLine();
                            for(int i = 0; i < condo.length; i++){
                                for(int j =0; j < condo[i].length; j++){
                                    if(searchOwnerName.equalsIgnoreCase(condo[i][j])){
                                        ownerExist = true;
                                        System.out.println("Owner Name : " + searchOwnerName  + " stay in Room " +
                                                "No : " + (i+1) + "    Floor No : " + (j+1));
                                    }
                                }
                            }
                            if(!ownerExist) {
                                System.out.println("User : " + searchOwnerName + " doesn't exist in our condo system.!.!");
                            }
                            break;
                        }
                        case 2 -> {
                            int searchFloor;
                            System.out.print("================ Search by Floor =================");
                            System.out.print("\n-> Enter the floor you want to search : ");
                            searchFloor = input.nextInt();

                            if(searchFloor > 0 && searchFloor <= floor){
                                // System.out.println("Floor " + searchFloor + " : ");
                                for(int i=0; i<condo[searchFloor-1].length; i++){
                                    System.out.println("\t[" + condo[searchFloor-1][i]+ "]");
                                }
                                System.out.println();
                            }else{
                                System.out.println("ERROR! Invalid Floor (Choose from 1 to " + floor + " )");
                            }
                            break;
                        }
                        case 3 -> {
                            System.out.println("You have exited from Search Condo Information");
                            break;
                        }
                        default -> {
                            System.out.println("Wrong Option! Please choose from (1-3).");
                            break;
                        }

                    }
                    break;
                case 4:
                    System.out.println("------------------ Display Condo Information -----------------");
                    for(int i= condo.length-1; i>=0; i--){
                        System.out.print("Floor ["+(i+1)+"] => ");
                        for(int j=0; j<condo[i].length; j++){
                            System.out.print("\t["+condo[i][j]+"]");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("You have exited from this Program.");
                    break;
                default:
                    System.out.println("Wrong Option! Please choose from (1-5).");
                    break;
            }
        }while(option != 5);
    }

}
