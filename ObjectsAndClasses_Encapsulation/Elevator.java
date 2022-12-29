public class Elevator {

    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;


    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;

    }

    public int getCurrentFloor() {
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
        } else if (floor > minFloor || floor < maxFloor) {
            while (currentFloor != floor){
                if (floor > currentFloor)
                    moveUp();
                if (floor < currentFloor)
                    moveDown();
            System.out.println(currentFloor);
            }
        } else {
            System.out.println(getCurrentFloor());
        }
    }
}







