import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomRepository {

    public RoomRepository(){

    }

    public Room createNewRoom(Scanner in) {

        try {
            System.out.print("Podaj numer pokoju: ");
            int number = in.nextInt();

            BedType bedType[] = chooseBedType(in);
            Room newRoom = new Room(number, bedType);
            System.out.println(newRoom.getInfo());
            return newRoom;
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Numbers only required, when selecting bed type");
        }
    }

        public BedType[] chooseBedType (Scanner in){
            System.out.print("Ile łóżek w pokoju?: ");

            try {
                int bedNumber = in.nextInt();
                BedType[] bedTypes = new BedType[bedNumber];

                for (int i = 0; i < bedNumber; i++) {
                    System.out.println("Dostępne łóżka: ");
                    System.out.println("\t1. Łóżko pojedyńcze (SINGLE)");
                    System.out.println("\t2. Łóżko podwójne (DOUBLE)");
                    System.out.println("\t3. Łoże królewskie (KING_SIZE)");
                    System.out.print("Wybierz opcję: ");

                    int bedTypeOption = in.nextInt();
                    BedType bedType = null;
                    if (bedTypeOption == 1) {
                        bedType = BedType.SINGLE;
                    } else if (bedTypeOption == 2) {
                        bedType = BedType.DOUBLE;
                    } else if (bedTypeOption == 3) {
                        bedType = BedType.KING_SIZE;
                    } else {
                        throw new WrongOptionException("Wrong option in bed's type menu.");
                    }
                    bedTypes[i] = bedType;
                }

                return bedTypes;

            } catch (InputMismatchException e) {
                throw new OnlyNumberException("Use only numbers typing number of beds");
            }
        }

}
