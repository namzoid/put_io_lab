package put.io.patterns.implement;

public class SystemCoolerObserver implements SystemStateObserver{
    public void update(SystemMonitor monitor){
        SystemState lastSystemState = monitor.getLastSystemState();
        //double cpuTemp = monitor.getLastSystemState().getCpuTemp();

    System.out.println(String.format("CPU temperature: %.2f C", lastSystemState.getCpuTemp()));

    // Increase CPU cooling if the temperature is to high
    if (lastSystemState.getCpuTemp() > 60.00){
        System.out.println("> Increasing cooling of the CPU...");
    }
}}
