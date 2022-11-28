package put.io.patterns.implement;

public class SystemGarbageCollectorObserver implements SystemStateObserver{
    public void update(SystemMonitor monitor){
        SystemState lastSystemState = monitor.getLastSystemState();
        //double memory =monitor.getLastSystemState().getAvailableMemory();

    System.out.println(String.format("Available memory: %.2f MB", lastSystemState.getAvailableMemory()));
    // Run garbage collector when out of memory
    if (lastSystemState.getAvailableMemory() < 200.00){
        System.out.println("> Running garbage collector...");
    }
}}
