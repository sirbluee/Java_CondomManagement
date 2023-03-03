
import java.util.Scanner;

public class Condo {
    public static void main(String[] args) {

        int floor, room;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("------------------------------------- Setup Condo -------------------------------------");
            System.out.print("Input Number of Floor :  ");

            floor = sc.nextInt();
            if (floor <= 0) {
                System.out.println("The floor can't be NEGATIVE or ZERO!");
            }

            System.out.print("Input Number of Room : ");
            room = sc.nextInt();
            if (room <= 0) {
                System.out.println("The room can't be NEGATIVE or ZERO!");
            }

        } while (!(floor > 0 && room > 0));

        System.out.println("Total of Condos rooms : " + (floor * room));

        int option;
        String[][] condo = new String[floor][room];

        do {

            System.out.println("------------------------------------- Welcome -------------------------------------");

            System.out.println("1.Buy condo");
            System.out.println("2.Sell condo");
            System.out.println("3.Search Information");
            System.out.println("4.Display Information");
            System.out.println("5.Exit");
            System.out.println();
            System.out.print("Please choose your option: ");
            option = sc.nextInt();

            switch (option) {
                case 1: {


                    //setup
                    do {
                        System.out.println("------------------------- Buy Condo -------------------------");

                        System.out.println("Enter the floor  number that you want: " + "1" + "-" + floor);
                        int wantFloor = sc.nextInt();

                        if (wantFloor > 0 && wantFloor <= floor) {
                            System.out.println("Enter the room  number that you want: " + "1" + "-" + room);
                            int wantRoom = sc.nextInt();
                            if (wantRoom > 0 && wantRoom <= room) {
                                if (condo[wantFloor - 1][wantRoom - 1] != null) {
                                    System.out.println("Already have owner");
                                } else {
                                    System.out.print("Enter your name : ");
                                    String name = sc.next();
                                    condo[wantFloor - 1][wantRoom - 1] = name;
                                    break;
                                }
                            } else {
                                System.out.println(" Room can be selected from 1 to " + room);
                            }
                        } else {
                            System.out.println(" Floor can be selected from 1 to " + floor);
                        }

                    } while ((floor > 0 && room > 0));
                    break;
                }
                case 2: {



                    //sell
                    do {

                        System.out.println("------------------------- Sell Condo-------------------------");

                        System.out.println("Enter the  floor for sell");
                        int saleF = sc.nextInt();

                        if (saleF > 0 && saleF <= floor) {
                            System.out.println("Enter the room  for sell");
                            int saleR = sc.nextInt();
                            if (saleR > 0 && saleR <= room) {
                                if (condo[saleF-1][saleR-1] != null) {
                                    System.out.println("floor : " + floor);
                                    System.out.println("room : " + room);

                                    System.out.println("Owner : " + condo[saleF - 1][saleR - 1]);
                                    System.out.println("Press 1 to confirm and 0 for cancel : ");

                                    int number = sc.nextInt();
                                    if (number == 1) {
                                        condo[floor - 1][room - 1] = null;
                                        System.out.println("successfully!!");
                                        break;
                                    }
                                    if (number == 0) {
                                        System.out.println("0 to cancel");
                                        break;
                                    }

                                } else {
                                    System.out.println("Can't sale, don't have the ownership yet!");
                                }
                            } else {
                                System.out.print("The room can be selected from 1 to : " + room);
                            }
                        } else {
                            System.out.println("The floor can be selected from 1 to :  " + room);
                        }

                    } while ((floor > 0 && room > 0));
                    break;
                }
                case 3: {
                    System.out.println("------------------------- Search Info list -------------------------");
                    System.out.println("1.Search by owner's name : ");
                    System.out.println("2.Search by floor : ");
                    System.out.println("3.Exit");
                    System.out.println("=> Choose One Option ");




                    option = sc.nextInt();
                    if (option == 1) {

                        System.out.println("Search by owner's name: ");
                        String nameSearch = sc.next();
                        boolean isFound = false;

                        for (int row = 0; row < condo.length; row++) {
                            for (int col = 0; col < condo[row].length; col++) {

                                if (nameSearch.equals(condo[row][col])) {
                                    isFound = true;
                                    System.out.println("Owner name :" + nameSearch + " Room:" + (col + 1) + " Floor: " + (row + 1));
                                }
                            }
                        }

                        //search check
                        if (!isFound) {
                            System.out.println("Searched Not Found!");
                        }
                    }
                }
                if (option == 2) {
                    System.out.print("Enter Floor to search : ");

                    int searchF = sc.nextInt();
                    for (int row = 0; row < condo.length; row++) {
                        for (int col = 0; col < condo[row].length; col++) {
                            if ((row + 1) == searchF) {
                                System.out.println("floor" + (row + 1) + "=>" + condo[row][col]);
                            }
                        }
                    }

                }
                if (option == 3) {
                    System.out.println("Exit");
                }
                break;
                case 4: {
                    System.out.println("------------------------- Show Condo -------------------------");

                    for (int row = 0; row < condo.length; row++) {
                        System.out.print("floor" + (row + 1));

                        for (int col = 0; col < condo[row].length; col++) {
                            System.out.print(" \t" + condo[row][col]);
                        }
                        System.out.println();
                    }
                    break;
                }
            }
        } while (option != 5);

    }
}
