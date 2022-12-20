public class Elevator {

    private static int currentFloor;
    private static int minFloor;
    private static int maxFloor;


    public Elevator(int minFloor, int maxFloor) {
        currentFloor = 1;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;

    }

    public static int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor - 1;
    }

    public void moveUp() {
        currentFloor = currentFloor + 1;
    }

    public void move(int floor) {

        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Такого этажа не существует");
        } else if (floor > currentFloor) {
            while (currentFloor != floor){
            moveUp();
            System.out.println(currentFloor);
            }
        } else if (floor < currentFloor) {
            while (currentFloor != floor) {
            moveDown();
            System.out.println(currentFloor);
            }
        } else {
            System.out.println(getCurrentFloor());
        }
    }
}







