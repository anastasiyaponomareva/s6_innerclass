
public abstract class Car {
    private String make;

    public abstract void start();

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }
}

class Program {
    public static void main(String[] args) {
        Car Hybrid = new Car() {
            private int battery = 3000;

            @Override
            public void start() {
                battery -= 100;
                System.out.println("battery= " + battery);
            }

            public void setMake(String make) {
                super.setMake(make);
            }

            public int getBattery() {
                return battery;
            }
        };
        Hybrid.start();
        Hybrid.setMake("Hyundai");


    }
}