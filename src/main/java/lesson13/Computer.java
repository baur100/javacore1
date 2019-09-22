package lesson13;


public class Computer {
    private SystemBlock systemBlock;
    private Monitor monitor;

    public Computer(SystemBlock sb, Monitor mn){
        systemBlock=sb;
        monitor=mn;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public SystemBlock getSystemBlock() {
        return systemBlock;
    }
}
