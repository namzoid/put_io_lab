package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver{
    private int countusb;
    public void update(SystemMonitor monitor){
        SystemState lastSystemState=monitor.getLastSystemState();
        if (lastSystemState.getUsbDevices() != countusb){
            System.out.println("Zmienila sie liczba urzadzen USB");
        }
    }
}
