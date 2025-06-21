package Week1_DesignPrinciplesAndPatterns.Exercise3_BuilderPattern.Code;

class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String graphicsCard;
    private final String operatingSystem;
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }
    public String getConfiguration() {
        return "Computer Configuration:\n" +
                "CPU: " + CPU + "\n" +
                "RAM: " + RAM + "\n" +
                "Storage: " + storage + "\n" +
                "Graphics Card: " + graphicsCard + "\n" +
                "OS: " + operatingSystem ;
    }
    public static class Builder {
        private final String CPU;
        private final String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }
        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }
        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();
        System.out.println(basicComputer.getConfiguration());

        System.out.println();

        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();
        System.out.println(gamingComputer.getConfiguration());
    }
}